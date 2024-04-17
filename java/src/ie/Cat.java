package ie;

public class Cat {
    private int numLives;
    private String name;

    // Constructor
    public Cat(String name) {
        this.name = name;
        this.numLives = 9;
    }

    // Public accessor for numLives
    public int getNumLives() {
        return numLives;
    }

    // Public accessor for name
    public String getName() {
        return name;
    }

    // Method to decrement numLives and print messages
    public void kill() {
        if (numLives > 0) {
            numLives--;
            System.out.println("Ouch! " + name + " has " + numLives + " lives left.");
        } else {
            System.out.println(name + " is Dead");
        }
    }

    public static void main(String[] args) {
        // Creating a Cat object
        Cat ginger = new Cat("Ginger");

        // Accessing and printing initial information
        System.out.println(ginger.getName() + " has " + ginger.getNumLives() + " lives.");

        // Performing kills until Ginger is dead
        while (ginger.getNumLives() > 0) {
            ginger.kill();
        }
    }
}

