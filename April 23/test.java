public class test {

    static KeyboardReader reader = new KeyboardReader();

    public static void main(String[] args) {
        char character = reader.readChar("Test");

        System.out.println(character);
    }
}
