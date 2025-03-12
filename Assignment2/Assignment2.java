    /*
    * Name: Jared Gleisner
    *
    * Date: 3/11/25
    * 
    * Assignment Number: 2
    * 
    * Instructor: Nicolaas tenBroek
    * 
    *
    */

import java.io.*;
import java.util.concurrent.atomic.LongAdder;

public class Assignment2 {

    static long total;
    static int count;

    
    public Assignment2() {
        count = 0;
    }
        
    public final void addToTotal(int val) {
        total += val;
        count++;
    }
    
    public static final void printSummary() {
        System.out.println("So far you have entered " + count + " values.\n" + "The sum of those values is " + total + ", and the average is " + (Double.valueOf(total) / Double.valueOf(count)) + "\n");
    }
    
    public static final void main(String[] args) {

        Assignment2 dataCollector = new Assignment2();

        while (count < 5) {
            dataCollector.addToTotal(readInt("\nEnter an integer value"));

            if (count > 1) {
                printSummary();
            }
        }

        
    }

    private static int readInt(String prompt) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            while(true) {
                try {
                    System.out.println(prompt);
                    return Integer.parseInt(in.readLine());
                } catch(NumberFormatException nfe) {
                    System.out.println("Please enter only an integer value.");
                }
            }
        } catch(IOException ioe) {
            System.err.println("Your keyboard seems to have broken.");
            return 0;
        }
    }
}