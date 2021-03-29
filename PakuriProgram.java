import java.util.Scanner;

public class PakuriProgram {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String menuChoice = "0";

        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        int capacity = 0;
        boolean correctChoice = false;
        while (!correctChoice) { //continue looping until a correct input is given
            System.out.print("Enter max capacity of the Pakudex: ");
            try { //try/catch for invalid inputs
                capacity = Integer.parseInt(scnr.next());
                if (capacity <= 0) {
                    System.out.println("Please enter a valid size.");
                } else {
                    correctChoice = true;
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid size.");
            }
        }
        Pakudex dex = new Pakudex(capacity); //Pakudex object
        System.out.println("The Pakudex can hold " + capacity + " species of Pakuri.");

        while (!menuChoice.equals("6")) { //Pakudex menu loop so long as the program is
            printMenu();                  //not exited
            menuChoice = scnr.next();
            switch (menuChoice) {
                case "1": //lists the Pakuri in the Pakudex with its number in order
                    if (dex.getSize() == 0) { //if there is no Pakuri in the Pakudex yet
                        System.out.println("No Pakuri in Pakudex yet!");
                    } else {
                        System.out.println("Pakuri In Pakudex:");
                        String[] listOfPakuri = dex.getSpeciesArray();
                        for (int i = 0; i < dex.getSize(); i++) {
                            System.out.println((i + 1) + ". " + listOfPakuri[i]);
                        }
                    }
                    break;

                case "2": //prompts for a species, collects species info, then displays it
                    System.out.print("Enter the name of the species to display: ");
                    String name = scnr.next(); //input Pakuri species
                    if (dex.getStats(name) == null) //if the input doesn't match a species in the Pakudex
                        System.out.println("Error: No such Pakuri!");
                    else { //used to print the stats of the Pakuri
                        int[] stats = dex.getStats(name);
                        System.out.println("\nSpecies: " + name +
                                "\nAttack: " + stats[0] +
                                "\nDefense: " + stats[1] +
                                "\nSpeed: " + stats[2]);
                    }
                    break;

                case "3": //adds a Pakuri by reading the species name and giving a confirmation
                    if (dex.getCapacity() == 0) { //aka at capacity
                        System.out.println("Error: Pakudex is full!");
                    } else { //adds species to the Pakudex
                        System.out.print("Enter the name of the species to add: ");
                        String name1 = scnr.next();
                        boolean added = dex.addPakuri(name1);
                        if (added) {
                            System.out.println("Pakuri species " + name1 + " successfully added!");
                        } else {
                            System.out.println("Error: Pakudex already contains this species!");
                        }
                    }
                    break;

                case "4": //evolves inputted Pakuri if it exists
                    System.out.print("Enter the name of the species to evolve: ");
                    String nameEvolve = scnr.next();
                    boolean evolved = dex.evolveSpecies(nameEvolve);
                    if (evolved) { //success/fail prompts
                        System.out.println(nameEvolve + " has evolved!");
                    } else {
                        System.out.println("Error: No such Pakuri!");
                    }
                    break;

                case "5": //sorts Pakuri into lexicographical order
                    dex.sortPakuri();
                    System.out.println("Pakuri have been sorted!");
                    break;

                case "6": //Quits the program
                    System.out.println("Thanks for using Pakudex! Bye!");
                    break;

                default: //default error message prompting for a valid input
                    System.out.println("Unrecognized menu selection!");
                    break;
            }
        }
    }


    private static void printMenu() { //method to print menu
        System.out.print("\nPakudex Main Menu" + "\n" + //displays menu prompt and menu options
                "-----------------" + "\n" +
                "1. List Pakuri" + "\n" +
                "2. Show Pakuri" + "\n" +
                "3. Add Pakuri" + "\n" +
                "4. Evolve Pakuri" + "\n" +
                "5. Sort Pakuri" + "\n" +
                "6. Exit" + "\n\nWhat would you like to do? ");
    }
}

//import java.util.*;
//public class PakuriProgram
//{
//    public static void main(String[] args)
//    {
//        //initialize scanner & other variables
//        Scanner scnr = new Scanner(System.in);
//        int maxCap = 0;
//        int size = 0;
//        //startup message
//        System.out.print("Welcome to Pakudex: Tracker Extraordinaire!\n");
//        //keep trying to obtain user info for max cap of Pakudex until successful
//        boolean init = true;
//        while (init)
//        {
//            System.out.print("Enter max capacity of the Pakudex: ");
//            try
//            {
//                maxCap = Integer.parseInt(scnr.next());
//                init = false;
//                System.out.println("The Pakudex can hold " + maxCap + " species of Pakuri\n");
//            }
//            catch (Exception e)
//            {
//                System.out.println("Please enter a valid size.");
//            }
//        }
//        //create Pakudex object
//        Pakudex myPakudex = new Pakudex(maxCap);
//        //start loop for the actual program itself
//        init = true;
//        while (init)
//        {
//            displayMenu();
//            int userSelect;
//            try
//            {
//                userSelect = Integer.parseInt(scnr.next());
//            }
//            catch (Exception e)
//            {
//                System.out.println("Unrecognized menu selection!");
//                continue;
//            }
//
//            switch(userSelect)
//            {
//                case 1:
//                    try
//                    {
//                        if (myPakudex.pakudexArray[0] == null)
//                        {
//                            throw new Exception();
//                        }
//                        System.out.println("Pakuri in Pakudex: ");
//                        System.out.println();
//                        for (int i = 0; i < myPakudex.getSize(); i++)
//                        {
//                            System.out.println((i + 1) + ". " + myPakudex.pakudexArray[i].getSpecies());
//                        }
//                        System.out.println();
//                    }
//                    catch(Exception e)
//                    {
//                        System.out.println("\nNo Pakuri in Pakudex yet!\n");
//                    }
//                    break;
//                case 2:
//                    try{
//                        System.out.print("Enter the name of the species to display: ");
//                        String species = scnr.next();
//                        for (int i = 0; i < myPakudex.getSize(); i++)
//                        {
//                            if (myPakudex.pakudexArray[i].getSpecies().equals(species))
//                            {
//                                System.out.println("\nSpecies: " + species + "\nAttack: " + myPakudex.pakudexArray[i].getAttack() + "\nDefense: " + myPakudex.pakudexArray[i].getDefense() + "\nSpeed: " + myPakudex.pakudexArray[i].getSpeed() + "\n");
//                            }
//                            if (i == myPakudex.getSize() - 1)
//                            {
//                                if (!myPakudex.pakudexArray[i].getSpecies().equals(species))
//                                {
//                                    throw new Exception();
//                                }
//                            }
//                        }
//
//                    }
//                    catch(Exception e)
//                    {
//                        System.out.println("\nError: No such Pakuri!\n");
//                    }
//                    break;
//                case 3:
//                    System.out.print("Enter the name of the species to add: ");
//                    String species = scnr.next();
//                    System.out.println();
//                    try
//                    {
//                        for (int i = 0; i < myPakudex.getSize(); i++)
//                        {
//                            if (myPakudex.pakudexArray[i].getSpecies().equals(species))
//                            {
//                                throw new RuntimeException();
//                            }
//                        }
//                        if (myPakudex.getSize() == myPakudex.getCapacity())
//                        {
//                            throw new NullPointerException();
//                        }
//                        myPakudex.addPakuri(species);
//                        System.out.println("Pakuri species " + species + " successfully added!\n");
//                    }
//                    catch (NullPointerException e)
//                    {
//                        System.out.println("Error: Pakudex is full!\n");
//                    }
//                    catch(RuntimeException e)
//                    {
//                        System.out.println("Error: Pakudex already contains this species!\n");
//                    }
//                    break;
//                case 4:
//                    try
//                    {
//                        System.out.print("\nEnter the name of the species to evolve: ");
//                        String speciesToEvolve = scnr.next();
//                        for (int i = 0; i < myPakudex.getSize(); i++)
//                        {
//                            if (myPakudex.pakudexArray[i].getSpecies().equals(speciesToEvolve))
//                            {
//                                myPakudex.pakudexArray[i].evolve();
//                                System.out.println("\n" + speciesToEvolve + " has evolved!\n");
//                            }
//                            if (i == myPakudex.getSize() - 1)
//                            {
//                                if (!myPakudex.pakudexArray[i].getSpecies().equals(speciesToEvolve))
//                                {
//                                    throw new Exception();
//                                }
//                            }
//                        }
//                    }
//                    catch(Exception e)
//                    {
//                        System.out.println("\nError: No such Pakuri!\n");
//                    }
//                    break;
//                case 5:
//                    myPakudex.sortPakuri();
//                    System.out.println("Pakuri have been sorted!");
//                    break;
//                case 6:
//                    System.out.println("Thanks for using Pakudex! Bye!");
//                    init = false;
//                    break;
//                default:
//                    System.out.println("Unrecognized menu selection!");
//                    break;
//            }
//        }
//    }
//
//    public static void displayMenu()
//    {
//        System.out.print("Pakudex Main Menu\n" +
//                "-----------------\n" +
//                "1. List Pakuri\n" +
//                "2. Show Pakuri\n" +
//                "3. Add Pakuri\n" +
//                "4. Evolve Pakuri\n" +
//                "5. Sort Pakuri\n" +
//                "6. Exit\n" +
//                "\n" +
//                "What would you like to do? ");
//    }
//}
////import java.util.Scanner;
////
////public class PakuriProgram
////{
////
////    public static void main(String[] args)
////    {
////        // variable dump
////        int pakudexCapacity = -1;
////        int menuInput;
////
////
////        // scanner
////        Scanner scanny = new Scanner(System.in);
////
////
////        // display welcome message
////        System.out.print("Welcome to Pakudex: Tracker Extraordinaire!\n");
////
////
////        // prompt for capacity
////        while (true)
////        {
////            System.out.print("Enter max capacity of the Pakudex: ");
////
////            if (scanny.hasNextInt())
////            {
////                pakudexCapacity = scanny.nextInt();
////            }
////            else
////            {
////                pakudexCapacity = -1;
////                scanny.next();
////            }
////
////            if (pakudexCapacity > 0)
////            {
////                break;
////            }
////            else
////            {
////                System.out.println("Please enter a valid size.");
////            }
////
////        }
////
////        System.out.println("The Pakudex can hold " + pakudexCapacity + " species of Pakuri.\n");
////
////
////        // IMPORTANT
////        Pakudex pakudex = new Pakudex(pakudexCapacity);
////
////
////        while(true)
////        {
////
////
////            System.out.print("Pakudex Main Menu\n" +
////                    "-----------------\n" +
////                    "1. List Pakuri\n" +
////                    "2. Show Pakuri\n" +
////                    "3. Add Pakuri\n" +
////                    "4. Evolve Pakuri\n" +
////                    "5. Sort Pakuri\n" +
////                    "6. Exit\n\n" +
////                    "What would you like to do? ");
////
////            try
////            {
////                menuInput = scanny.nextInt();
////            }
////            catch (Exception e)
////            {
////                menuInput = -1;
////                scanny.next();
////            }
////
////            switch (menuInput)
////            {
////
////                default:
////                    System.out.println("Unrecognized menu selection!\n");
////                    break;
////
////                case 1: // List Pakuri
////
////                    String[] currentCollection = pakudex.getSpeciesArray();
////
////                    if (currentCollection == null)
////                    {
////                        System.out.println("No Pakuri in Pakudex yet!\n");
////                    }
////                    else
////                    {
////                        System.out.println("Pakuri In Pakudex:");
////
////                        for (int i = 0; i < currentCollection.length; i++)
////                        {
////                            System.out.println((i + 1) + ". " + currentCollection[i]);
////                        }
////
////                        System.out.println("");
////                    }
////
////                    break;
////
////                case 2: // Show Pakuri
////
////                    System.out.print("Enter the name of the species to display: ");
////                    String pakuriName = scanny.next();
////
////                    int[] currentStats = pakudex.getStats(pakuriName);
////
////                    if (currentStats == null)
////                    {
////                        System.out.println("Error: No such Pakuri!\n");
////                        break;
////                    }
////
////                    System.out.println("\nSpecies: " + pakuriName + "\n" +
////                            "Attack: " + currentStats[0] + "\n" +
////                            "Defense: " + currentStats[1] + "\n" +
////                            "Speed: " + currentStats[2] + "\n");
////                    break;
////
////                case 3: // Add Pakuri
////
////                    if (pakudex.getCapacity() == pakudex.getSize())
////                    {
////                        System.out.println("Error: Pakudex is full!\n");
////                        break;
////                    }
////
////                    System.out.print("Enter the name of the species to add: ");
////                    String addedPakuri = scanny.next();
////
////                    if (pakudex.addPakuri(addedPakuri))
////                    {
////                        System.out.println("Pakuri species " + addedPakuri + " successfully added!\n");
////                    }
////                    else
////                    {
////                        System.out.println("Error: Pakudex already contains this species!\n");
////                    }
////
////                    break;
////
////                case 4: // Evolve Pakuri
////
////                    System.out.print("Enter the name of the species to evolve: ");
////                    String speciesToEvolve = scanny.next();
////
////
////                    if (pakudex.evolveSpecies(speciesToEvolve))
////                    {
////                        System.out.println(speciesToEvolve + " has evolved!\n");
////                    }
////                    else
////                    {
////                        System.out.println("Error: No such Pakuri!\n");
////                    }
////
////                    break;
////
////                case 5: // Sort Pakuri
////
////                    pakudex.sortPakuri();
////                    System.out.println("Pakuri have been sorted!\n");
////
////                    break;
////
////                case 6:
////                    System.out.print("Thanks for using Pakudex! Bye!");
////                    return;
////            }
////
////
////        }
////
////
////
////
////
////
////
////
////
////
////
////
////
////    }
////
////
////
////
////
////
////}
////
//////import java.sql.SQLOutput;
//////import java.util.InputMismatchException;
//////import java.util.Scanner;
//////import java.util.Arrays;
//////
//////public class PakuriProgram {
//////    public static void main(String args[]) {
//////        Scanner keyboard = new Scanner(System.in);
//////
//////        //this chunk of code is only printed one time as an introduction to the Pakudex Tracker game
//////        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
//////        System.out.print("Enter max capacity of the Pakudex: ");
//////        int capacityofArray;
//////
//////        //this try catch will test the input that the user enters to create the size of the pakudex
//////        while (true) {
//////            try {
//////                //if it is an interger, it must be positive so this if statement checks if the integer is greater than 0
//////                capacityofArray = keyboard.nextInt();
//////                //if it is a negative, the user is prompted to enter a valid size
//////                if (capacityofArray <= 0) {
//////                    System.out.println("Please enter a valid size.");
//////                    System.out.print("Enter max capacity of the Pakudex: ");
//////                    capacityofArray = keyboard.nextInt();
//////                }
//////                break;
//////            }
//////            //this will catch any input that is not an integer and prompt the user to enter a valid size.
//////            catch (Exception e){
//////                System.out.println("Please enter a valid size.");
//////                System.out.print("Enter max capacity of the Pakudex: ");
//////                keyboard.next();
//////            }
//////        }
//////
//////        //this establishes the Pakudex that I will use throughout the rest of the project
//////        Pakudex pakudex1 = new Pakudex(capacityofArray);
//////        System.out.println("The Pakudex can hold " + pakudex1.getCapacity() + " species of Pakuri.");
//////
//////        int RunGame = 0;
//////        //this while loop will continue to run the game until the user chooses to exit the program
//////        while (RunGame == 0) {
//////            System.out.println(" ");
//////            System.out.println("Pakudex Main Menu");
//////            System.out.println("-----------------");
//////            System.out.println("1. List Pakuri");
//////            System.out.println("2. Show Pakuri");
//////            System.out.println("3. Add Pakuri");
//////            System.out.println("4. Evolve Pakuri");
//////            System.out.println("5. Sort Pakuri");
//////            System.out.println("6. Exit");
//////
//////            System.out.print("What would you like to do? ");
//////            int personChoice = 0;
//////
//////            //this try catch tests if the person's menu choice is a valid integer (between 1 and 6)
//////            try {
//////                personChoice = keyboard.nextInt();
//////            }
//////            catch (Exception e) {
//////                personChoice = 10;
//////                keyboard.next();
//////            }
//////
//////            String [] pakudexArray = new String[capacityofArray];
//////
//////            //this if statement will list the pakuri in the Pakudex
//////            if (personChoice == 1) {
//////                pakudexArray = pakudex1.getSpeciesArray();
//////                //if the array is null or empty, the code will tell the user that there are no pakuri in the pakudex yet
//////                if (pakudexArray == null || pakudexArray.length == 0 ) {
//////                    System.out.println("No Pakuri in Pakudex yet!");
//////                    continue;
//////                }
//////
//////                //this if statement goes through each item in the array and prints out the list of pakuri
//////                System.out.println("Pakuri In Pakudex:");
//////                for (int i = 0; i < pakudexArray.length; i++) {
//////                    if (pakudexArray[i] == null) {
//////                        continue;
//////                    }
//////                    System.out.println((i+1) + ". " + pakudexArray[i]);
//////                }
//////            }
//////
//////            //this if statement will list show the name, speed, defense, and attack for the chose pakuri
//////            else if (personChoice == 2) {
//////                pakudexArray = pakudex1.getSpeciesArray();
//////                System.out.print("Enter the name of the species to display: ");
//////                String speciesToDisplay = keyboard.next();
//////
//////                //if the array is null or empty then the program will tell the user that there is no such pakuri
//////                if (pakudexArray == null) {
//////                    System.out.println("Error: No such Pakuri!");
//////                    continue;
//////                }
//////                if (pakudex1.getSize() == 0) {
//////                    System.out.println("Error: No such Pakuri!");
//////                    continue;
//////                }
//////
//////                //this new array holds the speed, defense, and attack values for the pakuri that the user has chosen
//////                int [] pakuriStats = pakudex1.getStats(speciesToDisplay);
//////                int count4 = 0;
//////                //this for loop is used to try to find the pakuri in the pakudex
//////                for (int j = 0; j < pakudexArray.length; j++) {
//////                    //if it is found, the stats will be printed for the pakuri with this if statement
//////                    if (speciesToDisplay.equals(pakudexArray[j])) {
//////                        System.out.println(" ");
//////                        System.out.println("Species: " + speciesToDisplay);
//////                        System.out.println("Attack: " + pakuriStats[0]);
//////                        System.out.println("Defense: " + pakuriStats[1]);
//////                        System.out.println("Speed: " + pakuriStats[2]);
//////                        break;
//////                    }
//////                }
//////            }
//////
//////            //this if statement is used ot create a new pakuri
//////            else if (personChoice == 3) {
//////                //if the current size of the array of pakuri is equal to the capacity, then it is full and the user will be give an error message
//////                if (pakudex1.getSize() == pakudex1.getCapacity()) {
//////                    System.out.println("Error: Pakudex is full!");
//////                    continue;
//////                }
//////
//////                //if the array is not full then the user can create a pakuri here
//////                System.out.print("Enter the name of the species to add: ");
//////                String pakuriName = keyboard.next();
//////                pakudex1.addPakuri(pakuriName);
//////            }
//////
//////            //this if statement is used to evolve a pakuri (update their stats)
//////            else if (personChoice == 4) {
//////                pakudexArray = pakudex1.getSpeciesArray();
//////                System.out.print("Enter the name of the species to evolve: ");
//////                String species = keyboard.next();
//////                int count5 = 0;
//////
//////                //if the array is null/empty then the user will be shown an error message
//////                if (pakudexArray == null) {
//////                    System.out.println("Error: No such Pakuri!");
//////                    continue;
//////                }
//////
//////                //if the array has pakuri, then this for loop will go through each one to find the pakuri that the user wants to evolve
//////                for (int l = 0; l < pakudexArray.length; l++) {
//////                    //if it is found, then this if statement will evolve the pakuri's stats
//////                    if (pakudexArray[l].equals(species)) {
//////                        pakudex1.evolveSpecies(species);
//////                        System.out.println(species + " has evolved!");
//////                        break;
//////                    }
//////                    //if the end of the array is reached and the pakuri has not been found then the user will be given and error message
//////                    if (count5 == pakudexArray.length-1) {
//////                        System.out.println("Error: No such Pakuri!");
//////                        break;
//////                    }
//////                    count5++;
//////                }
//////            }
//////
//////            //this if statement will sort the pakuri in alphabetical order
//////            else if (personChoice == 5) {
//////                pakudex1.sortPakuri();
//////                System.out.println("Pakuri have been sorted!");
//////            }
//////
//////            //this if statement will exit the game
//////            else if (personChoice == 6) {
//////                System.out.println("Thanks for using Pakudex! Bye!");
//////                RunGame = 1;
//////            }
//////            //this if statement will handle and menu choice that is not 1 through 6
//////            else {
//////                System.out.println("Unrecognized menu selection!");
//////            }
//////        }
//////    }
//////}
//////
////////import java.util.*;
////////
////////public class PakuriProgram {
////////    public static void main(String[] args) {
////////        //Variable and Object declaration
////////        Scanner in = new Scanner(System.in);
////////        String max, ans;
////////        int cap = 0, op=-1;
////////
////////        //Introduction
////////        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
////////        while(cap <= 0) {
////////            try {
////////                System.out.print("Enter max capacity of the Pakudex: ");
////////                max = in.next();
////////                cap = Integer.parseInt(max);
////////                if (cap < 0) {
////////                    throw new Exception();
////////                }
////////            } catch (Exception a) {
////////                System.out.print("Please enter a valid size.");
////////            }
////////        }
////////
////////        Pakudex pakudex = new Pakudex(cap);
////////        System.out.println("The Pakudex can hold " + cap + " species of Pakuri.");
////////        boolean cont = true;
////////        while(cont) { //loop to navigate the pakudex
////////            System.out.print("Pakudex Main Menu\n" +
////////                    "-----------------\n" +
////////                    "1. List Pakuri\n" +
////////                    "2. Show Pakuri\n" +
////////                    "3. Add Pakuri\n" +
////////                    "4. Evolve Pakuri\n" +
////////                    "5. Sort Pakuri\n" +
////////                    "6. Exit\n");
////////            System.out.print("What would you like to do?");
////////            ans = in.next();
////////
////////            try {
////////                op = Integer.parseInt(ans);
////////            } catch (Exception a) {
////////
////////            }
////////
////////            //Complete task from menu selection
////////            if (op == 1) {
////////                if (pakudex.getSize() == 0) {
////////                    System.out.println("No Pakuri in Pakudex yet!");
////////                }
////////                else {
////////                    System.out.println("Pakuri In Pakudex:");
////////                    String[] speciesList = pakudex.getSpeciesArray();
////////                    for (int i = 0; i < pakudex.getSize(); i++) {
////////                        System.out.println((i+1) + ". " + speciesList[i]);
////////                    }
////////                }
////////            }
////////            else if (op == 2) {
////////                System.out.print("Enter the name of the species to display: ");
////////                String species = in.next();
////////                String[] speciesList = pakudex.getSpeciesArray();
////////                for (int i = 0; i < speciesList.length; i++) {
////////                    if (speciesList[i].equals(species)) {
////////                        int [] stats = pakudex.getStats(species);
////////                        System.out.print("Species: " + species + "\n" +
////////                                "Attack: " + stats[0] + "'\n" +
////////                                "Defense: " + stats[1] + "\n" +
////////                                "Speed: " + stats[2]);
////////                    }
////////                    else {
////////                        System.out.print("Error: No such Pakuri!");
////////                    }
////////                }
////////            }
////////            else if (op == 3) {
////////                System.out.print("Enter the name of the species to add: ");
////////                String species = in.next();
////////                String[] speciesList = pakudex.getSpeciesArray();
////////                boolean check = pakudex.addPakuri(species);
////////                if (!check) {
////////                    for (int i = 0; i < speciesList.length; i++) {
////////                        if (speciesList[i].equals(species)) {
////////                            System.out.print("Error: Pakudex already contains this species!");
////////                            break;
////////                        } else if (pakudex.getSize() == pakudex.getCapacity()) {
////////                            System.out.print("Error: Pakudex is full!");
////////                            break;
////////                        }
////////                    }
////////                }
////////                else if (check) {
////////                    System.out.print("Pakuri species " + species + " successfully added!");
////////                }
////////            }
////////            else if (op == 4) {
////////                System.out.print("Enter the name of the species to evolve: ");
////////                String species = in.next();
////////                boolean check = pakudex.evolveSpecies(species);
////////                if (!check) {
////////                    System.out.println("Error: No such Pakuri!");
////////                }
////////                else if (check) {
////////                    System.out.println(species + " has evolved!");
////////                }
////////            }
////////            else if (op == 5) {
////////                pakudex.sortPakuri();
////////                System.out.println("Pakuri have been sorted!");
////////            }
////////            else if (op == 6) {
////////                System.out.println("Thanks for using Pakudex! Bye!");
////////                cont = false;
////////            }
////////            else {
////////                System.out.print("Unrecognized menu selection!");
////////            }
////////        }
////////
////////    }
////////}
////////
////////
//////////import java.util.*;
//////////
//////////public class PakuriProgram {
//////////    public static void main(String[] args) {
//////////        //Variable and Object declaration
//////////        Scanner in = new Scanner(System.in);
//////////        String max, ans;
//////////        int cap = 0, op=-1;
//////////
//////////        //Introduction
//////////        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
//////////        while(cap <= 0) {
//////////            try {
//////////                System.out.print("Enter max capacity of the Pakudex: ");
//////////                max = in.next();
//////////                cap = Integer.parseInt(max);
//////////                if (cap < 0) {
//////////                    throw new Exception();
//////////                }
//////////            } catch (Exception a) {
//////////                System.out.println("Please enter a valid size.");
//////////            }
//////////        }
//////////
//////////        Pakudex pakudex = new Pakudex(cap);
//////////        System.out.println("The Pakudex can hold " + cap + " species of Pakuri.\n");
//////////        boolean cont = true;
//////////        while(cont) { //loop to navigate the pakudex
//////////            System.out.print("Pakudex Main Menu\n" +
//////////                    "-----------------\n" +
//////////                    "1. List Pakuri\n" +
//////////                    "2. Show Pakuri\n" +
//////////                    "3. Add Pakuri\n" +
//////////                    "4. Evolve Pakuri\n" +
//////////                    "5. Sort Pakuri\n" +
//////////                    "6. Exit\n");
//////////            System.out.println();
//////////            System.out.print("What would you like to do? ");
//////////            ans = in.next();
//////////
//////////            try {
//////////                op = Integer.parseInt(ans);
//////////            } catch (Exception a){
//////////            }
//////////
//////////            //Complete task from menu selection
//////////            if (op == 1) {
//////////                if (pakudex.getSize() == 0) {
//////////                    System.out.println("No Pakuri in Pakudex yet!\n");
//////////                }
//////////                else {
//////////                    System.out.println("Pakuri In Pakudex:");
//////////                    String[] speciesList = pakudex.getSpeciesArray();
//////////                    for (int i = 0; i < pakudex.getSize(); i++) {
//////////                        System.out.println((i+1) + ". " + speciesList[i]);
//////////                    }
//////////                }
//////////            }
//////////            else if (op == 2) {
//////////                System.out.print("Enter the name of the species to display: ");
//////////                    String name = in.next();
//////////                    int[] stats = pakudex.getStats(name);
//////////                    break;
//////////            }
//////////            else if (op == 3) {
//////////                System.out.print("Enter the name of the species to add: ");
//////////                String species = in.next();
//////////                String[] speciesList = pakudex.getSpeciesArray();
//////////                boolean check = pakudex.addPakuri(species);
//////////                if (!check) {
//////////                    for (int i = 0; i < speciesList.length; i++) {
//////////                        if (speciesList[i].equals(species)) {
//////////                            System.out.print("Error: Pakudex already contains this species!");
//////////                            break;
//////////                        } else if (pakudex.getSize() == pakudex.getCapacity()) {
//////////                            System.out.print("Error: Pakudex is full!");
//////////                            break;
//////////                        }
//////////                    }
//////////                }
//////////                else if (check) {
//////////                    System.out.print("Pakuri species " + species + " successfully added!");
//////////                }
//////////            }
//////////            else if (op == 4) {
//////////                System.out.print("Enter the name of the species to evolve: ");
//////////                String species = in.next();
//////////                boolean check = pakudex.evolveSpecies(species);
//////////                if (!check) {
//////////                    System.out.println("Error: No such Pakuri!");
//////////                }
//////////                else if (check) {
//////////                    System.out.println(species + " has evolved!");
//////////                }
//////////            }
//////////            else if (op == 5) {
//////////                pakudex.sortPakuri();
//////////                System.out.println("Pakuri have been sorted!");
//////////            }
//////////            else if (op == 6) {
//////////                System.out.println("Thanks for using Pakudex! Bye!");
//////////                cont = false;
//////////            }
//////////            else {
//////////                System.out.print("Unrecognized menu selection!");
//////////            }
//////////        }
//////////
//////////    }
//////////}
//////////
////////////import java.util.Scanner;
////////////
////////////public class PakuriProgram{
////////////    private static void printMenu(){ //method to print menu
////////////        System.out.println("Pakudex Main Menu"); //displays menu prompt and menu options
////////////        System.out.println("-----------------");
////////////        System.out.println("1. List Pakuri");
////////////        System.out.println("2. Show Pakuri");
////////////        System.out.println("3. Add Pakuri");
////////////        System.out.println("4. Evolve Pakuri");
////////////        System.out.println("5. Sort Pakuri");
////////////        System.out.println("6. Exit\n");
////////////        System.out.print("What would you like to do? ");
////////////    }
////////////
////////////    public static void main(String[] args){
////////////        Scanner scnr = new Scanner(System.in);
////////////        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!"); //welcome message
////////////        System.out.print("Enter max capacity of the Pakudex: ");         //for user inputted Pakudex size
////////////        int pakudexSize = 0;
////////////        boolean size = false;
////////////        while (!size){ //continue looping until a correct input is given
////////////            try{ //try/catch invalid inputs
////////////                pakudexSize = scnr.nextInt();
////////////                while (pakudexSize < 0){
////////////                    System.out.println("Please enter a valid size."); //error prompt
////////////                    System.out.print("Enter max capacity of the Pakudex: ");
////////////                    pakudexSize = scnr.nextInt();
////////////                }
////////////                size = true; //Can only break out of the loop when a correct input is given
////////////            }
////////////            catch (Exception e){ //catches exception
////////////                System.out.println("Please enter a valid size.");
////////////                System.out.print("Enter max capacity of the Pakudex: ");
////////////                scnr.next();
////////////            }
////////////        }
////////////        Pakudex Paku = new Pakudex(pakudexSize);
////////////        System.out.println("The Pakudex can hold " + Paku.getCapacity() + " species of Pakuri.\n"); //displays capacity of Pakudex
////////////        printMenu();
////////////        String selection = scnr.next();
////////////        int i = 0;
////////////        while (selection != "6"){ //loops until the exit option is inputted
////////////            switch (selection){  //switch for the various menu options
////////////                case "1": //lists the Pakuri in the Pakudex with its number in order
////////////                    if (Paku.getSize() == 0){ //if there is no Pakuri in the Pakudex yet
////////////                        System.out.println("No Pakuri in Pakudex yet!\n");
////////////                        break;
////////////                    }
////////////                    System.out.println("Pakuri In Pakudex:");
////////////                    String[] speciesList = Paku.getSpeciesArray();
////////////                    for (int Z = 0; Z < Paku.getSize(); Z++){
////////////                        System.out.println((Z + 1) + ". " + speciesList[Z]); //displays list of Pakuri in the Pakudex w/ number
////////////                    }
////////////                    System.out.println();
////////////                    break;
////////////                case "2": //prompts for a species, collects species info, then displays it
////////////                    System.out.print("Enter the name of the species to display: ");
////////////                    String name = scnr.next();
////////////                    int[] stats = Paku.getStats(name);
////////////                    break;
////////////                case "3": //adds a Pakuri by reading the species name and giving a confirmation
////////////                    String species;
////////////                    try{
////////////                        if (Paku.getSize() == Paku.getCapacity()){ //if the Pakudex is at capacity
////////////                            System.out.println("Error: Pakudex is full!\n");
////////////                            break;
////////////                        }
////////////                        System.out.print("Enter the name of the species to add: ");
////////////                        species = scnr.next();
////////////                        Paku.addPakuri(species); //adds Pakuri to the Pakudex
////////////                        System.out.println("Pakuri species " + species + " successfully added!\n");
////////////                        break;
////////////                    }
////////////                    catch (Exception e){
////////////                        System.out.println("Error: Pakudex is full!"); //aka at capacity
////////////                    }
////////////                    i++;
////////////                    break;
////////////                case "4": //evolves inputted Pakuri if it exists
////////////                    System.out.println("Enter the name of the species to evolve: ");
////////////                    species = scnr.next();
////////////                    Paku.evolveSpecies(species);
////////////                    break;
////////////                case "5": //sorts Pakuri into lexicographical order
////////////                    Paku.sortPakuri();
////////////                    System.out.println("Pakuri have been sorted!\n");
////////////                    break;
////////////                case "6": //Quits the program
////////////                    System.out.println("Thanks for using Pakudex! Bye!");
////////////                    System.exit(0);
////////////                default:  //default error message, prompting for a valid input
////////////                    System.out.println("Unrecognized menu selection!\n");
////////////            }
////////////            printMenu();
////////////            selection = scnr.next();
////////////        }
////////////    }
////////////}