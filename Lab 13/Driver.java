/* 
    Code by Jared Gleisner, Xzavier Woods, Brody Joachims

    Question Answers:

    1. Classes like zoo implement composition because they hold instances of cats dogs and aligators. Lines 6 and 12 in Zoo.java create Cat type, Dog type and Alligator type objects.

    2. Aligator's Eat Method is overloaded to accept both Dogs and Cats.

    3. Alligator grow and Dog grow both use primatives.

    4. Alligator eat and zoo's constructor both use references.


*/
public class Driver {

    public static void main(String[] args) {

        int age = KeyboardReader.readInt("How old would you like your aligator to be");
        int weight = KeyboardReader.readInt("How heavy would you like your aligator to be");
        String disposition = KeyboardReader.readLine("What kind of disposition do you want your aligator to have");
        String color = KeyboardReader.readLine("What color would you like your aligator");

        Zoo zoo = new Zoo(age, weight, disposition, color);

        zoo.getCat().printCharacteristics();

        String choice = KeyboardReader.readLine("\nWould you like to change your dog's color (y/n)?").toLowerCase();

        
        if (choice.equals("y") || choice.equals("yes")) {
            String newColor = KeyboardReader.readLine("\nWhat color?");

            zoo.getDog().setColor(newColor);
        }

        zoo.getDog().printCharacteristics();
        zoo.getGator().eat(zoo.getCat());
        zoo.getGator().eat(zoo.getDog());

        zoo.getGator().printCharacteristics();

    }
    
    
}
