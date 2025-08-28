public class Driver {
    public static final void main(String[] args) {
        Person[] people = new Person[KeyboardReader.readInt("How many peoples")];

        for (int i = 0; i < people.length; i++) {
            String firstName = KeyboardReader.readLine("First name ?");
            String lastName = KeyboardReader.readLine("Last name ?");
            int age = KeyboardReader.readInt("Age ?");
            people[i] = new Person(firstName, lastName, age);
        }

        for(int i = 0; i < people.length; i++) {
            System.out.println(people[i] + ", ");
        }
        System.out.println();
    }
}
