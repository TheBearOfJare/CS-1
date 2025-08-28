public class Fish {
    private int id;
    private int weight;
    private int maxWeight;
    private boolean alive;

    private static int idCount;
    private static int numFishAlive;

    public Fish (int weight) {
        this.weight = weight;
        this.maxWeight = weight*2;
        this.alive = true;
        
        ++idCount;

        this.id = idCount;

        numFishAlive++;

    }

    private int getWeight() {
        return weight;
    }

    public void kill() {
        alive = false;
        System.out.println("Fish with id: " + id + " has been slain.");
        numFishAlive--;
        numFishAlive = Math.max(0, numFishAlive);
    }

    public void eat(Fish victem) {

        if (alive) {
    
            System.out.println("Fish with id: " + id + " is eating another fish with id: " + victem.id);
            victem.kill();
            weight+=victem.weight;
            if (weight > maxWeight) {
                kill();
            }
        }
        else {
            System.out.println("Fish with id: " + id + " was supposed to eat fish with id: " + victem.id + " but it's dead so it can't.");
        }
    }

    public String toString() {
        String status = "dead";
        if (alive) {
            status = "alive";
        }
        return "I am a fish, my id is " + id + " I weigh " + weight + " and I am " + status + ".";
    }

    public static int getNumFishAlive() {
        return numFishAlive;
    }

}
