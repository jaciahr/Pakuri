public class Pakudex {
    private Pakuri[] pakudex;
    private int numPakuri = 0;

    public Pakudex(){                                                       //Default constructor, contains 20 Pakuri.
        pakudex = new Pakuri[20];
    }

    public Pakudex(int capacity){                          //initializes Pakudex to contain specified amount of Pakuri
        pakudex = new Pakuri[capacity];
    }

    public int getSize(){                                      //returnss the current amount of Pakuri in the Pakudex
        int count = 0;
        for (int i = 0; i < omgomg.length; i++) {
            if (omgomg[i] != null) {
                count++;
            }
        }
        return count;
    }

    public int getCapacity() {                            //returns the total amount of possible pakuri for the pakudex
        int pakudexSize = omgomg.length;
        return pakudexSize;
    }

    public String[] getSpeciesArray() {                   //returns a list of the current Pakuri species in the pakudex
        String[] list = new String[getSize()];
        if (getSize() == 0) {
            list = null;
            return list;
        }
        for (int i = 0; i < getSize(); i++) {
            list[i] = omgomg[i].species;
        }
        return list;
    }

    public int[] getStats(String species) {                 //prints and returns an array of the specified Pakuri stats
        int[] stats = new int[3];
        if (getSize() > -1) {
            for (int j = 0; j < getSize(); j++) {
                if (species.equals(omgomg[j].species)) {
                    System.out.println("Species: " + omgomg[j].getSpecies());
                    System.out.println("Attack: " + omgomg[j].getAttack());
                    System.out.println("Defense: " + omgomg[j].getDefense());
                    System.out.println("Speed: " + omgomg[j].getSpeed() + "\n");
                    stats[0] = omgomg[j].getAttack();
                    stats[1] = omgomg[j].getDefense();
                    stats[2] = omgomg[j].getSpeed();
                    return stats;
                }
                for (int k = 0; k < getSize(); k++) {

                    if (!(species.equals(omgomg[k].species))) {
                        break;
                    }
                }
            }
            System.out.println("Error: No such Pakuri!\n");
            stats = null;
        }
        return stats;
    }

    public void sortPakuri() {                                                 //alphabetizes the Pakuri in the Pakudex
        for (int i = 0; i < getSize() - 1; i++) {
            for (int j = i + 1; j < getSize(); j++) {
                if (omgomg[i].species.compareTo(omgomg[j].species) > 0) {
                    Pakuri temp = omgomg[i];
                    omgomg[i] = omgomg[j];
                    omgomg[j] = temp;
                }
            }
        }
    }

    public boolean addPakuri(String species) {       //determines if added Pakuri is duplicate, if not, adds new pakuri

        if (getSize() > 0) {
            for (int i = 0; i < getSize(); i++) {
                if (species.equals(omgomg[i].species)) {
                    System.out.println("Error: Pakudex already contains this species!\n");
                    return false;
                }
            }
        }
        omgomg[numberOfPakuri] = new Pakuri(species);
        numberOfPakuri++;
        System.out.println("Pakuri species " + species + " successfully added!\n");

        return true;
    }

    public boolean evolveSpecies(String species) {                           //evolves a specific pakuri in the pakudex
        if (getSize() == 0) {
            System.out.println("Error: No such Pakuri!\n");
            return false;
        } else if (getSize() > 0) {
            for (int i = 0; i < getSize(); i++) {
                if (species.equals(omgomg[i].species)) {
                    omgomg[i].evolve();
                    System.out.println(species + " has evolved!\n");
                    return true;
                }
            }
            for (int i = 0; i < getSize(); i++) {
                if (!(species.equals(omgomg[i].species))) {
                    System.out.println("Error: No such Pakuri!\n");
                    return true;
                }
            }
        }
        return true;
    }
}