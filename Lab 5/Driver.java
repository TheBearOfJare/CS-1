/*
 *
 * Name:  Jared Gleisner
 *
 * Instructor: Nicolaas tenBroek
 *
 */


 import java.io.*;

 public class Driver {
     public static final void main(String[] args) {
         try {
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             System.out.println("Please enter a line of text below:");
             String userInput = reader.readLine();
             System.out.println("\n");
             
             //
             //your code goes here
             //
 
             System.out.println("The character in position 3 is: " + userInput.substring(2,3));
             System.out.println("The length of your string is: " + userInput.length());
             System.out.println("Your string with 'z' in place of 'a' is: " + userInput.replace("a","z"));
             System.out.println("Your string in uppercase is: " + userInput.toUpperCase());
             System.out.println("Your string in lowercase is: " + userInput.toLowerCase());

             System.out.println("\nEnter a floating point number below: ");
             userInput = reader.readLine();

             System.out.println("\nThe largest integer less than " + userInput + " is " + Math.floor(Double.valueOf(userInput)));
             System.out.println("\nGood Bye.");
         } catch(IOException ioe) {
             //error with keyboard input, no fix available so just print the error and quit
             ioe.printStackTrace(System.err);
         }
     }
 }