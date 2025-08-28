// code by Jared Gleisner and Mary Arensberg

/*
Answer to question 1:

The code says that there are -1 fish left alive in the "Zombies Ahead" part becuase kill gets called more times than there are actual living fish, since fish 4 is forced to eat other fish even after it has died.

To fix this, we fixed the number of fish alive at a minimum of 0 and prevented fish from eating once dead.
*/ 

public class Driver {
    public static void main(String[] args) {
        System.out.println("Let's set up your fish.");

        int[] weights = new int[4];
        Fish[] tank = new Fish[4];

        for (int i = 0; i < weights.length; i++) {
            weights[i] = KeyboardReader.readInt("Pick a weight for fish " + (i+1) + ".");
            tank[i] = new Fish(weights[i]);

        }

        System.out.println("There are " + Fish.getNumFishAlive() + " fish alive, currently.\n");

        // tank[0].eat(tank[1]);
        // System.out.println("There are " + Fish.getNumFishAlive() + " fish alive, currently.\n");
        // tank[2].eat(tank[3]);
        // System.out.println("There are " + Fish.getNumFishAlive() + " fish alive, currently.\n");
        // tank[2].eat(tank[0]);
        // System.out.println("There are " + Fish.getNumFishAlive() + " fish alive, currently.\n");

        // fish 4 eat all the other fish
        for (int i = 0; i < 3; i++) {
            tank[3].eat(tank[i]);
            System.out.println("There are " + Fish.getNumFishAlive() + " fish alive, currently.\n");
        }

        for (int i = 0; i < tank.length; i++) {
            System.out.println(tank[i].toString());
        }
        

        
        
    }
}
