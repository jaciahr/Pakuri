public class Pakudex{
    private Pakuri[] pakudex;
    private int pakudexSize = 0;

    public Pakudex(){ //default constructor containing 20 Pakuri
        pakudex = new Pakuri[20];
    }

    public Pakudex(int capacity){ //initializes the Pakudex to contain the indicated amount of Pakuri
        pakudex = new Pakuri[capacity];
    }

    public int getSize(){ //returns the current amount of Pakuri in the Pakudex
        return this.pakudexSize;
    }

    public int getCapacity(){ //returns the maximum amount of Pakuri that can fit in the Pakudex
        return pakudex.length;
    }

    public String[] getSpeciesArray(){ //returns a list of all of the Pakuri species currently in the Pakudex...
        String[] species = new String[pakudexSize]; //...in its current order, unless empty
        if (this.pakudexSize == 0){
            return null; //signifies an empty Pakudex
        }
        for (int i = 0; i < this.pakudexSize; i++){
            species[i] = pakudex[i].getSpecies(); //copies the Pakudex into a new array for output
        }
        return species;
    }

    public int[] getStats(String species) {                 //prints and returns an array of the specified Pakuri stats
        int[] stats = new int[3];
        if (getSize() > -1) {
            for (int j = 0; j < getSize(); j++) {
                if (pakudex[j].getSpecies() == species){
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
                    if (!(species.equals(pakudex[k].getSpecies()))) {
                        break;
                    }
                }
            }
            System.out.println("Error: No such Pakuri!\n");
            stats = null;
        }
        return stats;
    }
//    public int[] getStats(String species){ //prints and returns an array with the Pakuri stats at indices 0, 1, and 2...
//        int ind = -1;                      //...unless empty
//        int[] stats = new int[3];
//        for (int i = 0; i < pakudexSize; i++){
//            if (pakudex[i].getSpecies() == species){
//                ind = i;
//            }
//        }
//        if (ind == -1){
//            return null; //signifies an empty Pakudex
//        }
//        stats[0] = pakudex[ind].getAttack();
//        stats[1] = pakudex[ind].getDefense();
//        stats[2] = pakudex[ind].getSpeed();
//        return stats;
//    }

    public void sortPakuri(){ //sorts the Pakuri in the Pakudex by lexicographical order
        Pakuri temp;
        for (int i = 1; i < pakudexSize; i++){
            if(pakudex[i] != null) {
                if (pakudex[i-1].getSpecies().compareTo(pakudex[i].getSpecies()) > 0){
                    temp = pakudex[i-1];
                    pakudex[i-1] = pakudex[i];
                    pakudex[i] = temp;
                }
            }
        }
    }

    public boolean addPakuri(String species){  //adds a species to the Pakudex, returning true if successful...
        for (int i = 0; i < pakudexSize; i++){ //...and false if failed
            if (pakudex[i] != null) {
                String spec = pakudex[i].getSpecies();
                if (spec.equals(species)){
                    return false; //no empty space; can't be added
                }
            }
        }
        if (pakudexSize != getCapacity()){ //if the Pakudex is not full
            pakudex[pakudexSize] = new Pakuri(species);
            pakudexSize++;
            return true; //Pakuri can be added
        }
        else {
            return false; //if not, addition fails
        }


    }

    public boolean evolveSpecies(String species){ //attempts to evolve a species in the Pakudex, reporting success or failure
        if (pakudexSize == 0){ //if there is no Pakuri in the Pakudex thus far
            return false;
        }
        for (int i = 0; i < pakudexSize; i++){ //evolve species
            if (pakudex[i].getSpecies().equals(species)){
                pakudex[i].evolve();
                return true;
            }
            else{
                return false;
            }
        }
        return false;
    }
}
