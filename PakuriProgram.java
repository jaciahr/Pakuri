import java.util.Scanner;

public class PakuriProgram {
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String menuChoice = "0";
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!"); //welcome prompt
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
            }
            catch (NumberFormatException e) {
                System.out.println("Please enter a valid size."); //if the inputted string is not a valid number
            }
        }

        Pakudex dex = new Pakudex(capacity); //Pakudex object
        System.out.println("The Pakudex can hold " + capacity + " species of Pakuri."); //capacity confirmation

        while (!menuChoice.equals("6")) { //Pakudex menu loop so long as the program is not exited
            printMenu(); //always prints menu if the Pakudex is not exited
            menuChoice = scnr.next();
            switch (menuChoice) {

                case "1": //lists the Pakuri in the Pakudex with its number in order
                    if (dex.getSize() == 0) { //if there is no Pakuri in the Pakudex yet, state it
                        System.out.println("No Pakuri in Pakudex yet!");
                    } else { //otherwise, list the current Pakuri in the Pakudex
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
                        System.out.println("\nSpecies: " + name + //stats
                                "\nAttack: " + stats[0] +
                                "\nDefense: " + stats[1] +
                                "\nSpeed: " + stats[2]);
                    }
                    break;

                case "3": //adds a Pakuri by reading the species name and giving a confirmation
                    if (dex.getCapacity() == 0) { //aka at capacity; cannot add
                        System.out.println("Error: Pakudex is full!");
                    } else { //adds species to the Pakudex
                        System.out.print("Enter the name of the species to add: ");
                        String name1 = scnr.next();
                        boolean added = dex.addPakuri(name1);
                        if (added) {
                            System.out.println("Pakuri species " + name1 + " successfully added!"); //if add succeeds
                        } else {
                            System.out.println("Error: Pakudex already contains this species!"); //if add fails
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
}
