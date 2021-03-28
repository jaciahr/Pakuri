public class Pakudex {
    private Pakuri[] pakudex;
    private int numPakuri = 0;

    public Pakudex(){             //default constructor containing 20 Pakuri
        pakudex = new Pakuri[20];
    }

    public Pakudex(int capacity){ //initializes the Pakudex to contain the indicated amount of Pakuri
        pakudex = new Pakuri[capacity];
    }

    public int getSize(){         //returns the current amount of Pakuri in the Pakudex
        int count = 0;
        for (int i = 0; i < pakudex.length; i++) {
            if (pakudex[i] != null) {
                count++;
            }
        }
        return count;
    }

    public int getCapacity(){    //returns the maximum amount of Pakuri in the Pakudex
        int pakudexSize = pakudex.length;
        return pakudexSize;
    }

    public String[] getSpeciesArray(){   //returns a list of all of the Pakuri species currently in the Pakudex...
        String[] list = new String[getSize()]; //...in its current order unless empty
        if (getSize() == 0) {
            return null;
        }
        for (int i = 0; i < getSize(); i++) {
            list[i] = pakudex[i].species;
        }
        return list;
    }

    public int[] getStats(String species){  //prints and returns an array with the Pakuri stats at indices 0, 1, and 2...
        int[] stats = new int[3];           //...unless empty
        if (getSize() > -1) {
            for (int j = 0; j < getSize(); j++) {
                if (species.equals(pakudex[j].species)) {
                    System.out.println("Species: " + pakudex[j].getSpecies());
                    System.out.println("Attack: " + pakudex[j].getAttack());
                    System.out.println("Defense: " + pakudex[j].getDefense());
                    System.out.println("Speed: " + pakudex[j].getSpeed() + "\n");
                    stats[0] = pakudex[j].getAttack();
                    stats[1] = pakudex[j].getDefense();
                    stats[2] = pakudex[j].getSpeed();
                    return stats;
                }
                for (int k = 0; k < getSize(); k++) {
                    if (!(species.equals(pakudex[k].species))) {
                        break;
                    }
                }
            }
            System.out.println("Error: No such Pakuri!\n");
            stats = null;
        }
        return stats;
    }

    public void sortPakuri(){  //sorts the Pakuri in the Pakudex by lexicographical order
        for (int i = 0; i < getSize() - 1; i++) {
            for (int j = i + 1; j < getSize(); j++) {
                if (pakudex[i].species.compareTo(pakudex[j].species) > 0) {
                    Pakuri temp = pakudex[i];
                    pakudex[i] = pakudex[j];
                    pakudex[j] = temp;
                }
            }
        }
    }

    public boolean addPakuri(String species){   //adds a species to the Pakudex, returning true if successful...
        if (getSize() > 0) {                    //...and false if failed
            for (int i = 0; i < getSize(); i++) {
                if (species.equals(pakudex[i].species)) {
                    System.out.println("Error: Pakudex already contains this species!\n");
                    return false;
                }
            }
        }
        pakudex[numPakuri] = new Pakuri(species);
        numPakuri++;
        System.out.println("Pakuri species " + species + " successfully added!\n");

        return true;
    }

    public boolean evolveSpecies(String species){  //attempts to evolve a species in the Pakudex...
        if (getSize() == 0) {                      //...reporting its success or failure
            System.out.println("Error: No such Pakuri!\n");
            return false;
        } else if (getSize() > 0) {
            for (int i = 0; i < getSize(); i++) {
                if (species.equals(pakudex[i].species)) {
                    pakudex[i].evolve();
                    System.out.println(species + " has evolved!\n");
                    return true;
                }
            }
            for (int i = 0; i < getSize(); i++) {
                if (!(species.equals(pakudex[i].species))) {
                    System.out.println("Error: No such Pakuri!\n");
                    return true;
                }
            }
        }
        return true;
    }
}