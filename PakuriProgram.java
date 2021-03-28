import java.util.Scanner;

public class PakuriProgram {
    private static void printMenu() {                                   //method to print out the menu
        System.out.println("Pakudex Main Menu");
        System.out.println("-----------------");
        System.out.println("1. List Pakuri");
        System.out.println("2. Show Pakuri");
        System.out.println("3. Add Pakuri");
        System.out.println("4. Evolve Pakuri");
        System.out.println("5. Sort Pakuri");
        System.out.println("6. Exit\n");
        System.out.print("What would you like to do? ");
    }

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Welcome to Pakudex: Tracker Extraordinaire!");
        System.out.println("Enter max capacity of the Pakudex: ");                 //gives user option for Pakudex size
        int pakudexSize = 0;
        boolean size = false;
        while (size == false) {
            try {                                                                   //try/catch for invalid input type
                pakudexSize = scnr.nextInt();
                while (pakudexSize < 0) {
                    System.out.println("Please enter a valid size.");
                    System.out.println("Enter max capacity of the Pakudex: ");
                    pakudexSize = scnr.nextInt();
                }
                size = true;
            } catch (Exception e) {
                System.out.println("Please enter a valid size.");
                System.out.println("Enter max capacity of the Pakudex: ");
                String flush = scnr.next();
            }
        }
        Pakudex Paku = new Pakudex(pakudexSize);
        System.out.println("The Pakudex can hold " + Paku.getCapacity() + " species of Pakuri.\n");
        printMenu();
        String selection = scnr.next();
        int i = 0;
        while (selection != "6") {                             //while loop keeps the menu going until it is exited
            switch (selection) {                                //switch performs the various menu options
                case "1":
                    if (Paku.getSize() == 0) {
                        System.out.println("No Pakuri in Pakudex yet!\n");
                        break;
                    }                                                                //case one lists pakuri in pakudex
                    System.out.println("Pakuri In Pakudex:");
                    String[] speciesList = Paku.getSpeciesArray();
                    for (int Z = 0; Z < Paku.getSize(); Z++) {
                        System.out.println((Z + 1) + ". " + speciesList[Z]);
                    }
                    System.out.println("");
                    break;
                case "2":                                                          //case two displays specified pakuri
                    System.out.println("Enter the name of the species to display: ");
                    String name = scnr.next();
                    int[] stats = Paku.getStats(name);
                    break;
                case "3":                                                           //case 3 adds pakuri if possible
                    String species = null;
                    try {
                        if (Paku.getSize() == Paku.getCapacity()) {
                            System.out.println("Error: Pakudex is full!\n");
                            break;
                        }
                        System.out.println("Enter the name of the species to add: ");
                        species = scnr.next();
                        Paku.addPakuri(species);
                        break;
                    } catch (Exception e) {
                        System.out.println("Error: Pakudex is full!");
                    }
                    i++;
                    break;
                case "4":                                                        //case 4 evolves pakuri if found
                    System.out.println("Enter the name of the species to evolve: ");
                    species = scnr.next();
                    Paku.evolveSpecies(species);
                    break;
                case "5":                                                       //case 5 sorts pakuri alphabetically
                    Paku.sortPakuri();
                    System.out.println("Pakuri have been sorted!\n");
                    break;
                case "6":                                                       //case 6 evolves pakuri
                    System.out.println("Thanks for using Pakudex! Bye!");
                    System.exit(0);
                default:                                     //default prints error message and prompts for valid input
                    System.out.println("Unrecognized menu selection!\n");
            }
            printMenu();

            selection = scnr.next();
        }
    }
}