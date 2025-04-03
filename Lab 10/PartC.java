
/*
* Name: Jared Gleisner
*
* Date: 3/19/2025
*
* Assignment Number: 10
*
* Instructor: Dcn. TenBroek
*
*
*/
import java.io.*;

public class PartC {
public static void main(String [] args) {
System.out.println("This program will determine if a particular year is a leap year.");
//Calendar c = new Calendar(readLong("Enter the year you want tested: "));
for (int i = 0; i < 8000; i ++ ) {
    Calendar c = new Calendar(i);
    if (c.isLeapYear == false) {
        System.out.println("not the same \r");
    }
}

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
