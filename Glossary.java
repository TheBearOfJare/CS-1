/*
 *
 * Name:  Jare Gleisner
 *
 * Instructor: Nicolaas tenBroek
 *
 */


 import java.text.*;
 import java.util.*;
 import java.io.*;
 
 public class Glossary {
     private String firstName;
     private int age;
     private char expectedGrade;
 
     public Glossary() {
         firstName = "unknown person";
     }
 
     public Glossary(String firstName, int age) {
         setFirstName(firstName);
         setAge(age);
     }
 
     public final void setFirstName(String firstName) {
         this.firstName = firstName;
     }
     
     public void setAge(int age) {
         this.age = age;
     }
     
     public void setExpectedGrade(char expectedGrade) {
         this.expectedGrade = expectedGrade;
     }
 
     public final void greetPerson() {
         System.out.print("Hello there " + firstName);
         System.out.println(". Today is " + DateFormat.getDateInstance(
                 DateFormat.LONG).format(new Date(System.currentTimeMillis())));
 
     }
 
     public static final void main(String[] args) {
         try {
             BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             //get person's name and greet them.
             System.out.println("Please enter your first name.");
             String firstName = reader.readLine();
             
             System.out.println("What is your age in years?");
             int age = -1;
             while(true) {
                 try {
                     age = Integer.parseInt(reader.readLine());
                     break;
                 } catch(NumberFormatException nfe) {
                     System.out.println();
                     System.out.println("Please enter an integer value");
                 }
             }
 
             Glossary demo = new Glossary(firstName, age);
             
             char expectedGrade = Glossary.readChar("What grade do you think you will get in this class?", reader);
             demo.setExpectedGrade(Character.toUpperCase(expectedGrade));
             
             demo.greetPerson();
             //offer a chance to run again with a new name.
             char changeName = Glossary.readChar("Would you like to change your name (Y/N)?", reader);
             if(Character.toLowerCase(changeName) == 'y') {
                 System.out.println("Please enter another name.");
                 demo.setFirstName(reader.readLine());
                 demo.greetPerson();
             }
             //time to go
             System.out.println();
             System.out.println("Good Bye.");
         } catch(IOException ioe) {
             //error with keyboard input, no fix available so just print the error and quit
             ioe.printStackTrace(System.err);
         }
     }
 
     private static char readChar(String prompt, BufferedReader reader) throws IOException {
             String input = null;
             do {
                 System.out.println();
                 System.out.println(prompt);
                 input = reader.readLine();
             } while(input == null || input.length() <= 0);
             return input.charAt(0);
     }
 }