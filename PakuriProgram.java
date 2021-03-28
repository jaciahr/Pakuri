import java.util.Scanner;

public class PakuriProgram{
    private static void printMenu(){ //method to print menu
        System.out.println("Pakudex Main Menu"); //displays menu prompt and menu options
        System.out.println("-----------------");
        System.out.println("1. List Pakuri");
        System.out.println("2. Show Pakuri");
        System.out.println("3. Add Pakuri");
        System.out.println("4. Evolve Pakuri");
        System.out.println("5. Sort Pakuri");
        System.out.println("6. Exit\n");
        System.out.print("What would you like to do? ");
    }

    public static void main(String[] args){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!"); //welcome message
        System.out.println("Enter max capacity of the Pakudex: ");         //for user inputted Pakudex size
        int pakudexSize = 0;
        boolean size = false;
        while (size == false){ //continue looping until a correct input is given
            try{ //try/catch invalid inputs
                pakudexSize = scnr.nextInt();
                while (pakudexSize < 0){
                    System.out.println("Please enter a valid size."); //error prompt
                    System.out.println("Enter max capacity of the Pakudex: ");
                    pakudexSize = scnr.nextInt();
                }
                size = true; //Can only break out of the loop when a correct input is given
            } catch (Exception e){ //catches exception
                System.out.println("Please enter a valid size.");
                System.out.println("Enter max capacity of the Pakudex: ");
                scnr.next();
            }
        }
        Pakudex Paku = new Pakudex(pakudexSize);
        System.out.println("The Pakudex can hold " + Paku.getCapacity() + " species of Pakuri.\n"); //displays capacity of Pakudex
        printMenu();
        String selection = scnr.next();
        int i = 0;
        while (selection != "6"){ //loops until the exit option is inputted
            switch (selection){  //switch for the various menu options
                case "1": //lists the Pakuri in the Pakudex with its number in order
                    if (Paku.getSize() == 0){ //if there is no Pakuri in the Pakudex yet
                        System.out.println("No Pakuri in Pakudex yet!\n");
                        break;
                    }
                    System.out.println("Pakuri In Pakudex:");
                    String[] speciesList = Paku.getSpeciesArray();
                    for (int Z = 0; Z < Paku.getSize(); Z++) {
                        System.out.println((Z + 1) + ". " + speciesList[Z]); //displays list of Pakuri in the Pakudex w/ number
                    }
                    System.out.println("");
                    break;
                case "2": //promps for a species, collects species info, then displays it
                    System.out.println("Enter the name of the species to display: ");
                    String name = scnr.next(); //input Pakuri species
                    int[] stats = Paku.getStats(name);
                    break;
                case "3": //adds a Pakuri by reading the species name and giving a confirmation
                    String species = null;
                    try {
                        if (Paku.getSize() == Paku.getCapacity()){ //if the Pakudex is at capacity
                            System.out.println("Error: Pakudex is full!\n");
                            break;
                        }
                        System.out.println("Enter the name of the species to add: ");
                        species = scnr.next();
                        Paku.addPakuri(species); //adds Pakuri to the Pakudex
                        break;
                    } catch (Exception e){
                        System.out.println("Error: Pakudex is full!"); //aka at capacity
                    }
                    i++;
                    break;
                case "4": //evolves inputted Pakuri if it exists
                    System.out.println("Enter the name of the species to evolve: ");
                    species = scnr.next();
                    Paku.evolveSpecies(species);
                    break;
                case "5": //sorts Pakuri into lexicographical order
                    Paku.sortPakuri();
                    System.out.println("Pakuri have been sorted!\n");
                    break;
                case "6": //Quits the program
                    System.out.println("Thanks for using Pakudex! Bye!");
                    System.exit(0);
                default:  //default error message, prompting for a valid input
                    System.out.println("Unrecognized menu selection!\n");
            }
            printMenu();
            selection = scnr.next();
        }
    }
}