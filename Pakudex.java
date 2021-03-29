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
        String[] arr = new String[getSize()]; //...in its current order, unless empty
        if (arr.length == 0) {
            return null; //signifies an empty Pakudex
        } else {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = pakuris.get(i).getSpecies(); //copies the Pakudex into a new array for output
            }
        }
        return arr;
    }

    public int[] getStats(String species) { //prints and returns an array with the Pakuri stats at indices 0, 1, and 2...
        int[] arr = new int[3];              //...unless empty

        for (Pakuri pakuri : pakuris) {
            if (pakuri.getSpecies().equals(species)) {
                arr[0] = pakuri.getAttack();
                arr[1] = pakuri.getDefense();
                arr[2] = pakuri.getSpeed();
            }
        }

        if (arr[2] == 0) { ////signifies an empty Pakudex
            return null;
        }

        return arr;
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
            return true; //if there is room
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

//import java.util.Arrays;
//import java.util.Comparator;
//
//public class Pakudex
//{
//    public Pakuri[] pakudexArray;
//
//    private int size;
//    private int capacity;
//
//    public Pakudex()
//    {
//        this.capacity = 20;
//        this.size = 0;
//    }
//
//    public Pakudex(int capacity)
//    {
//        this.capacity = capacity;
//        this.size = 0;
//        pakudexArray = new Pakuri[capacity];
//    }
//
//    public int getSize()
//    {
//        return this.size;
//    }
//
//    public int getCapacity()
//    {
//        return  this.capacity;
//    }
//
//    public String[] getSpeciesArray()
//    {
//        if (size != 0)
//        {
//            String[] speciesArray = new String[size];
//            for (int i = 0; i < size; i++)
//            {
//                speciesArray[i] = pakudexArray[i].getSpecies();
//            }
//            return speciesArray;
//        }
//        else
//        {
//            return null;
//        }
//    }
//    public int[] getStats(String species)
//    {
//        int[] statsArray = new int[3];
//        for(int i = 0; i < pakudexArray.length; i++)
//        {
//            if (pakudexArray[i].equals(species))
//            {
//                Pakuri myPakuri = new Pakuri(species);
//                statsArray[0] = myPakuri.getAttack();
//                statsArray[1] = myPakuri.getDefense();
//                statsArray[2] = myPakuri.getSpeed();
//            }
//        }
//        if (statsArray[0] != -0)
//        {
//            return statsArray;
//        }
//        else
//        {
//            return null;
//        }
//    }
//    public void sortPakuri()
//    {
//        //how can I sort the pakudexArray using comparator without having nullPointerException errors?
//        Arrays.sort(pakudexArray, new Comparator<Pakuri>() {
//            @Override
//            public int compare(Pakuri o1, Pakuri o2)
//            {
//                return o1.getSpecies().compareTo(o2.getSpecies());
//            }
//        });
//    /*for (int i = 1; i < pakudexArray.length; i++)
//        {
//            if (pakudexArray[i] != null)
//            {
//                if (pakudexArray[i - 1].getSpecies().compareTo(pakudexArray[i].getSpecies()) > 0)
//                {
//                    Pakuri placeholder = pakudexArray[i - 1];
//                    pakudexArray[i] = pakudexArray[i - 1];
//                    pakudexArray[i - 1] = placeholder;
//                }
//            }
//        }*/
//    }
//
//    public boolean addPakuri(String species)
//    {
//        try{
//            pakudexArray[size] = new Pakuri(species);
//            size++;
//            return true;
//        }
//        catch(Exception e)
//        {
//            return false;
//        }
//    }
//    public boolean evolveSpecies(String species)
//    {
//        try
//        {
//            for (int i = 0; i < pakudexArray.length; i++)
//            {
//                if(pakudexArray[i].equals(species))
//                {
//                    pakudexArray[i].evolve();
//                }
//            }
//        }
//        catch(Exception e)
//        {
//            return false;
//        }
//        return true;
//    }
//}
////import java.util.Arrays;
////
////public class Pakudex
////{
////    // variable dump
////    private int capacity;
////    private int size;
////    private Pakuri[] collection;
////
////
////
////    public Pakudex()
////    {
////        this(20);
////    }
////
////    public Pakudex(int capacity)
////    {
////        this.capacity = capacity;
////        collection = new Pakuri[capacity];
////    }
////
////    public int getSize()
////    {
////        return size;
////    }
////
////    public int getCapacity()
////    {
////        return capacity;
////    }
////
////    public String[] getSpeciesArray()
////    {
////        if (size == 0)
////        {
////            return null;
////        }
////
////        String[] pakuriList = new String[size];
////
////        for(int i = 0; i < size; i++)
////        {
////            pakuriList[i] = collection[i].getSpecies();
////        }
////
////        return pakuriList;
////    }
////
////    public int[] getStats(String species)
////    {
////        for (int i = 0; i < size; i++)
////        {
////            if (collection[i].getSpecies().equals(species))
////            {
////                return new int[] {collection[i].getAttack(), collection[i].getDefense(), collection[i].getSpeed()};
////            }
////        }
////
////        return null;
////    }
////
////
////    public void sortPakuri()
////    {
////        Arrays.sort(collection, 0, size);
////    }
////
////
////    public boolean addPakuri(String species)
////    {
////        if (size == capacity)
////        {
////            return false;
////        }
////        if (getStats(species) == null)
////        {
////            collection[size] = new Pakuri(species);
////            size ++;
////            return true;
////        }
////        else
////        {
////            return false;
////        }
////
////
////    }
////
////    public boolean evolveSpecies(String species)
////    {
////        for (int i = 0; i < size; i++)
////        {
////            if (collection[i].getSpecies().equals(species))
////            {
////                collection[i].evolve();
////                return true;
////            }
////        }
////
////        return false;
////    }
////}
////
//////import java.util.Arrays;
//////
//////public class Pakudex {
//////    private int sizeofPakudex;
//////    private Pakuri [] pakudexArray;
//////    private String [] pakuriString = null;
//////    private int countofPakuri = 0;
//////    private int attack, defense, speed;
//////    private int [] pakuriStats;
//////    private String [] pakuriStringNoNulls = null;
//////
//////    public Pakudex() {
//////        // this is a default constructor that will create a default array with a capacity of 20 if there is no capacity given
//////        sizeofPakudex = 20;
//////        pakudexArray = new Pakuri [20];
//////        pakuriString = new String [20];
//////    }
//////
//////    public Pakudex(int capacity) {
//////        //this initializes the array of pakuri to have a capacity that the user entered at the beginning of the program
//////        sizeofPakudex = capacity;
//////        pakudexArray = new Pakuri [sizeofPakudex];
//////        pakuriString = new String [sizeofPakudex];
//////    }
//////
//////    public int getSize() {
//////        //this returns the number of pakuri currently being stored in the Pakudex
//////        return countofPakuri;
//////    }
//////
//////    public int getCapacity() {
//////        //this returns the number of pakuri that the Pakudex has the capacity to hold at most
//////        return sizeofPakudex;
//////    }
//////
//////    public String[] getSpeciesArray() {
//////        // this returns a String array containing the species of the critters as ordered in the Pakudex
//////        //it will return null if there are no pakuri in the pkudex yet
//////        if (pakuriString[0] == null) {
//////            return null;
//////        }
//////
//////        //this creates a string of pakuri names with no null values
//////        pakuriStringNoNulls = new String [countofPakuri];
//////        for (int d = 0; d <= countofPakuri; d++) {
//////            if (pakuriString[d] == null) {
//////                break;
//////            }
//////            pakuriStringNoNulls[d] = pakuriString[d];
//////        }
//////        return pakuriStringNoNulls;
//////    }
//////
//////    public int[] getStats(String species) {
//////        //this returns an integer array containing the attack, defense, and speed statistics of pakuri at indices 0, 1, and 2
//////        int count = 0;
//////        if (pakudexArray == null) {
//////            System.out.println("Error: No such Pakuri!");
//////            return null;
//////        }
//////        //this for loop looks for the pakuri in the array
//////        for (int i = 0; i < pakudexArray.length; i++) {
//////            //if the pakuri is found, then the correct stats will be returned in an integer array
//////            if (pakudexArray[i].getSpecies().equals(species)) {
//////                attack = pakudexArray[count].getAttack();
//////                defense = pakudexArray[count].getDefense();
//////                speed = pakudexArray[count].getSpeed();
//////                pakuriStats = new int[]{attack, defense, speed};
//////                return pakuriStats;
//////            }
//////            //if the end of the array is reached and no pakuri has been found, then the code will break out of the loop and return a null array
//////            if (count == pakudexArray.length-1) {
//////                break;
//////            }
//////            count++;
//////            if (pakudexArray[count] == null) {
//////                System.out.println("Error: No such Pakuri!");
//////                break;
//////            }
//////        }
//////        //if there are no pakuri in the Pakudex, then it returns null
//////        return null;
//////    }
//////
//////    public void sortPakuri() {
//////        //this sorts the Pakuri objects in this Pakudex according to Java standard lexicographical ordering of species name
//////        Arrays.sort(pakuriString,0, countofPakuri);
//////    }
//////
//////    public boolean addPakuri(String species) {
//////        //this adds a pakuri to the Pakudex
//////        Pakuri newPakuri = new Pakuri(species);
//////        //this for loop and if statement look to see if there is already another pakuri in the array with the same name
//////        //if so, the user is given an error message and the value of false is returned
//////        for (int j = 0; j < pakudexArray.length; j++) {
//////            if (species.equals(pakuriString[j])) {
//////                System.out.println("Error: Pakudex already contains this species!");
//////                return false;
//////            }
//////        }
//////        //this puts the pakuri in the array
//////        pakudexArray[countofPakuri] = newPakuri;
//////        pakuriString[countofPakuri] = species;
//////        countofPakuri ++;
//////        System.out.println("Pakuri species " + species + " successfully added!");
//////        return true;
//////    }
//////
//////    public boolean evolveSpecies(String species) {
//////        //this evolves pakuri within the Pakudex
//////        int count2 = 0;
//////        //if the array is null/empty then the user will be shown an error message
//////        if (pakudexArray == null) {
//////            System.out.println("Error: No such Pakuri!");
//////            return false;
//////        }
//////        //this foor loop goes through each pakuri in the pakudex
//////        for (int i = 0; i < pakuriString.length; i++) {
//////            //if the species they are looking for is found, then the Pakuri's stats will be updated in the array and the value of true is returned
//////            if (pakuriStringNoNulls[i].equals(species)) {
//////                pakudexArray[count2].evolve();
//////                pakuriStats = new int[]{attack, defense, speed};
//////                return true;
//////            }
//////            count2++;
//////            if (pakudexArray[count2] == null) {
//////                System.out.println("Error: No such Pakuri!");
//////                return false;
//////            }
//////            //if the end of the array is reached and the program has not found the Pakuri that the user is searching for, then the code will return an
//////            //error message and a value of false
//////            if (pakuriStringNoNulls.length == count2) {
//////                System.out.println("Error: No such Pakuri!");
//////                return false;
//////            }
//////        }
//////        System.out.println("Error: No such Pakuri!");
//////        return false;
//////    }
//////
//////}
//////
////////public class Pakudex {
////////
////////    private Pakuri[] pakudex;
////////    private int pakudexSize = 0;
////////    public Pakudex() {
////////        pakudex = new Pakuri[20];
////////    }
////////    public Pakudex(int capacity) {
////////        pakudex = new Pakuri[capacity];
////////    }
////////    public int getSize() {
////////        return this.pakudexSize;
////////    }
////////    public int getCapacity() {
////////        return pakudex.length;
////////    }
////////    public String[] getSpeciesArray() {
////////        String[] species = new String[pakudexSize];
////////        if (this.pakudexSize == 0) {
////////            return null;
////////        }
////////        for (int i = 0; i < this.pakudexSize; i++) {
////////            species[i] = pakudex[i].getSpecies();
////////        }
////////        return species;
////////    }
////////    public int[] getStats(String species) {
////////        int ind = -1;
////////        int[] stats = new int[3];
////////        for (int i = 0; i < pakudexSize; i++) {
////////            if (pakudex[i].getSpecies() == species) {
////////                ind = i;
////////            }
////////        }
////////        if (ind == -1) {
////////            return null;
////////        }
////////        stats[0] = pakudex[ind].getAttack();
////////        stats[1] = pakudex[ind].getDefense();
////////        stats[2] = pakudex[ind].getSpeed();
////////        return stats;
////////    }
////////    public void sortPakuri() {
////////        Pakuri temp;
////////        for (int i = 1; i < pakudexSize; i++) {
////////            if(pakudex[i] != null) {
////////                if (pakudex[i-1].getSpecies().compareTo(pakudex[i].getSpecies()) > 0) {
////////                    temp = pakudex[i-1];
////////                    pakudex[i-1] = pakudex[i];
////////                    pakudex[i] = temp;
////////                }
////////            }
////////        }
////////    }
////////    public boolean addPakuri(String species) {
////////        for (int i = 0; i < pakudexSize; i++) {
////////            if (pakudex[i] != null) {
////////                String spec = pakudex[i].getSpecies();
////////                if (spec.equals(species)) {
////////                    return false;
////////                }
////////            }
////////        }
////////        if (pakudexSize != getCapacity()) {
////////            pakudex[pakudexSize] = new Pakuri(species);
////////            pakudexSize++;
////////            return true;
////////        }
////////        else {
////////            return false;
////////        }
////////
////////
////////    }
////////    public boolean evolveSpecies(String species) {
////////        if (pakudexSize == 0) {
////////            return false;
////////        }
////////        for (int i = 0; i < pakudexSize; i++) {
////////            if (pakudex[i].getSpecies().equals(species)) {
////////                pakudex[i].evolve();
////////                return true;
////////            }
////////            else {
////////                return false;
////////            }
////////        }
////////        return false;
////////    }
////////}
////////
//////////public class Pakudex{
//////////    private Pakuri[] pakudex;
//////////    private int pakudexSize = 0;
//////////
//////////    public Pakudex(){ //default constructor containing 20 Pakuri
//////////        pakudex = new Pakuri[20];
//////////    }
//////////
//////////    public Pakudex(int capacity){ //initializes the Pakudex to contain the indicated amount of Pakuri
//////////        pakudex = new Pakuri[capacity];
//////////    }
//////////
//////////    public int getSize(){ //returns the current amount of Pakuri in the Pakudex
//////////        return this.pakudexSize;
//////////    }
//////////
//////////    public int getCapacity(){ //returns the maximum amount of Pakuri that can fit in the Pakudex
//////////        return pakudex.length;
//////////    }
//////////
//////////    public String[] getSpeciesArray(){ //returns a list of all of the Pakuri species currently in the Pakudex...
//////////        String[] species = new String[pakudexSize]; //...in its current order, unless empty
//////////        if (this.pakudexSize == 0){
//////////            return null; //signifies an empty Pakudex
//////////        }
//////////        for (int i = 0; i < this.pakudexSize; i++){
//////////            species[i] = pakudex[i].getSpecies(); //copies the Pakudex into a new array for output
//////////        }
//////////        return species;
//////////    }
//////////
//////////    public int[] getStats(String species) { //prints and returns an array with the Pakuri stats at indices 0, 1, and 2...
//////////        int[] stats = new int[3];           //...unless empty
//////////        if (getSize() > -1) {
//////////            for (int j = 0; j < getSize(); j++) {
//////////                if (pakudex[j].getSpecies() == species){
//////////                    System.out.println("Species: " + pakudex[j].getSpecies());
//////////                    System.out.println("Attack: " + pakudex[j].getAttack());
//////////                    System.out.println("Defense: " + pakudex[j].getDefense());
//////////                    System.out.println("Speed: " + pakudex[j].getSpeed() + "\n");
//////////                    stats[0] = pakudex[j].getAttack();
//////////                    stats[1] = pakudex[j].getDefense();
//////////                    stats[2] = pakudex[j].getSpeed();
//////////                    return stats;
//////////                }
//////////                for (int k = 0; k < getSize(); k++) {
//////////                    if (!(species.equals(pakudex[k].getSpecies()))) {
//////////                        break;
//////////                    }
//////////                }
//////////            }
//////////            System.out.println("Error: No such Pakuri!\n");
//////////            stats = null;
//////////        }
//////////        return stats;
//////////    }
//////////
//////////    public void sortPakuri(){ //sorts the Pakuri in the Pakudex by lexicographical order
//////////        Pakuri temp;
//////////        for (int i = 1; i < pakudexSize; i++){
//////////            if(pakudex[i] != null) {
//////////                if (pakudex[i-1].getSpecies().compareTo(pakudex[i].getSpecies()) > 0){
//////////                    temp = pakudex[i-1];
//////////                    pakudex[i-1] = pakudex[i];
//////////                    pakudex[i] = temp;
//////////                }
//////////            }
//////////        }
//////////    }
//////////
//////////    public boolean addPakuri(String species){  //adds a species to the Pakudex, returning true if successful...
//////////        for (int i = 0; i < pakudexSize; i++){ //...and false if failed
//////////            if (pakudex[i] != null) {
//////////                String spec = pakudex[i].getSpecies();
//////////                if (spec.equals(species)){
//////////                    return false; //no empty space; can't be added
//////////                }
//////////            }
//////////        }
//////////        if (pakudexSize != getCapacity()){ //if the Pakudex is not full
//////////            pakudex[pakudexSize] = new Pakuri(species);
//////////            pakudexSize++;
//////////            return true; //Pakuri can be added
//////////        }
//////////        else {
//////////            return false; //if not, addition fails
//////////        }
//////////
//////////
//////////    }
//////////
//////////    public boolean evolveSpecies(String species){ //attempts to evolve a species in the Pakudex, reporting success or failure
//////////        if (pakudexSize == 0){ //if there is no Pakuri in the Pakudex thus far
//////////            return false;
//////////        }
//////////        for (int i = 0; i < pakudexSize; i++){ //evolve species
//////////            if (pakudex[i].getSpecies().equals(species)){
//////////                pakudex[i].evolve();
//////////                return true;
//////////            }
//////////            else{
//////////                return false;
//////////            }
//////////        }
//////////        return false;
//////////    }
//////////}
