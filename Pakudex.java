import java.util.*;

public class Pakudex {
    private int capacity;
    private int numCritters = 0;
    private ArrayList<Pakuri> pakuris = new ArrayList<>();


    public Pakudex() { //default constructor containing 20 Pakuri
        capacity = 20;
    }

    public Pakudex(int capacity) { //initializes the Pakudex to contain the indicated amount of Pakuri
        this.capacity = capacity;
    }

    public int getSize() { //returns the current amount of Pakuri in the Pakudex
        return numCritters;
    }

    public int getCapacity() { //returns the maximum amount of Pakuri that can fit in the Pakudex
        return capacity - numCritters;
    }

    public String[] getSpeciesArray() { //returns a list of all of the Pakuri species currently in the Pakudex...
        String[] dex = new String[getSize()]; //...in its current order, unless empty
        if (dex.length == 0) {
            return null; //signifies an empty Pakudex
        } else {
            for (int i = 0; i < dex.length; i++) {
                dex[i] = pakuris.get(i).getSpecies(); //copies the Pakudex into a new array for output
            }
        }
        return dex;
    }

    public int[] getStats(String species) { //prints and returns an array with the Pakuri stats at indices 0, 1, and 2...
        int[] stats = new int[3];           //...unless empty

        for (Pakuri pakuri : pakuris) {
            if (pakuri.getSpecies().equals(species)) {
                stats[0] = pakuri.getAttack();
                stats[1] = pakuri.getDefense();
                stats[2] = pakuri.getSpeed();
            }
        }

        if (stats[2] == 0) { //signifies an empty Pakudex
            return null;
        }

        return stats;
    }

    public void sortPakuri() { //sorts the Pakuri in the Pakudex by lexicographical order
        Comparator<Pakuri> compareBySpeciesName = Comparator.comparing(Pakuri::getSpecies);
        pakuris.sort(compareBySpeciesName); //(as recommended by Knack tutor)
    }

    public boolean addPakuri(String species) { //adds a species to the Pakudex, returning true if successful...
        for (Pakuri pakuri : pakuris) {        //...and false if failed
            if (pakuri.getSpecies().equals(species)) {
                return false;
            }
        }
        if (pakuris.size() < capacity) {
            pakuris.add(new Pakuri(species));
            numCritters++;
            return true;  //if there is room
        } else {
            return false; //if there is not room
        }
    }

    public boolean evolveSpecies(String species) { //attempts to evolve a species in the Pakudex, reporting success or failure
        for (Pakuri pakuri : pakuris) {
            if (pakuri.getSpecies().equals(species)) {
                pakuri.evolve();
                return true;
            }
        }
        return false;
    }
}
