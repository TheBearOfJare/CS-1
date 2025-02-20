import java.io.*;

public class Driver {
    public static final void main(String[] args) {
        int volume = Driver.readInt("Please enter the duck's volume value.");
        int height = Driver.readInt("Please enter the duck's height value.");
        int weight = Driver.readInt("Please enter the duck's weight value.");
        String colour = Driver.readLine("Please enter the duck's colour value.");
        Duck ie = new Duck(volume, height, weight, colour, name);
        System.out.println("Here's your duck:");
        System.out.println(ie);
    }

    private static String readLine(String prompt) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            return in.readLine().toString();
        } catch(IOException ioe) {
            System.err.println("serious failure");
        }
    }

    private static int readInt(String prompt) {
        try {
            BufferedReader in  = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                try {
                    System.out.println(prompt);
                    return Integer.parseInt(in.readLine());
                }
                catch(NumberFormatException nfe) {
                    System.err.println("You didn't submit a number");
                }
            }
        } catch(IOException ioe) {
            System.err.println("You did an oopsie woopsie");
            return 0;
        }
    }
}