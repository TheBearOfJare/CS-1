
/*
* Name: Jared Gleisner
*
* Date: 3/19/25
*
* Assignment Number: 10
*
* Instructor: Dcn. TenBroek
*
*
*/
import java.io.*;

public class PartA {
    public static void main(String[] args) {
        long number = readLong("Enter a number: ");
        if (number > 100000) {
            System.out.println("That is a big number!");
            System.out.println("Big numbers must have at least 6 digits");
        }
        else
            System.out.println("That is not a big number.");
    }

    private static String readLine(String prompt) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(prompt);
            return in.readLine();
        } catch (IOException ioe) {
            System.err.println("Your keyboard seems to have broken.");
            return "";
        }
    }

    private static long readLong(String prompt) {
        while (true) {
            try {
                return Long.parseLong(readLine(prompt));
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter only an integer value.");
            }
        }
    }
}
