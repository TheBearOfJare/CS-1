class feline {
    static String animalType = "Feline";
    public void pet() {
        System.out.println("purr");
    }
}

class Cat extends feline {

    
    public static void main(String[] args) {
        Cat myCat = new Cat();

        myCat.pet();
        final String name = "mittens";

    
        System.out.println(name+"\n"+animalType);
    }
        
    
}



