public class Zoo {
    private Cat cat;
    private Dog dog;
    private Alligator gator;

    public Zoo() {
        this.cat = new Cat();
        this.dog = new Dog();
        this.gator = new Alligator();
    }

    public Zoo(int age, int weight, String disposition, String color) {
        this.cat = new Cat();
        this.dog = new Dog();
        this.gator = new Alligator(color,age,weight,disposition);

    }

    public Cat getCat() {
        return cat;
    }
    public Dog getDog() {
        return dog;
    }
    public Alligator getGator() {
        return gator;
    }
    

    public void printInventory () {
        cat.printCharacteristics();
        dog.printCharacteristics();
        gator.printCharacteristics();
    }




}
