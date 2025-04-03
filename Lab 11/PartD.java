import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PartD {
    
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws IOException {


        System.out.println("Enter a character (A, M, or S): ");
        String input = reader.readLine();

        while (!input.equals("A") && !input.equals("M") && !input.equals("S")) {
            
            System.out.println("Invalid data entry. (" + input + ")  Please enter A, M, or S");
            input = reader.readLine();

        }

        System.out.println("You entered the character: " + input);


    }
}
