public class Pakuri {
    private String species; //initialize variables
    private int attack;
    private int defense;
    private int speed;

    public Pakuri(String species){ //creates the Pakuri object
        this.species = species;    //initializes stats as per instructions
        this.attack = (species.length() * 7) + 9;
        this.defense = (species.length() * 5) + 17;
        this.speed = (species.length() * 6) + 13;
    }

    public String getSpecies(){  //returns the Pakuri species
        return species;
    }

    public int getAttack(){      //returns the Pakuri attack
        return attack;
    }

    public int getDefense(){     //returns the Pakuri defense
        return defense;
    }

    public int getSpeed(){       //returns the Pakuri speed
        return speed;
    }

    public void setAttack(int newAttack){  //sets the field attack to the new attack for the Pakuri
        this.attack = newAttack;
    }

    public void evolve(){            //"evolves" the Pakuri, increasing its stats
        this.attack = attack * 2;    //doubles the Pakuri's attack
        this.defense = defense * 4;  //quadruples the Pakuri's defense
        this.speed = speed * 3;      //triples the Pakuri's speed
    }
}