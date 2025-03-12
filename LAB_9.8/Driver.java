/*
 * Author:       Nicolaas tenBroek
 *
 * Student Name: Jared Gleisner
 *
 * Description:   The Driver class is part of a minimal
 *                application that allows the user to enter
 *                data and work with a Rectangle
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Driver {

	private static String readLine(String prompt) {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            System.out.println(prompt);
            return in.readLine();
        } catch(IOException ioe) {
            System.err.println("Your keyboard seems to have broken.");
            return "";
        }
    }

	private static double readDouble(String prompt) {
        while(true) {
            try {
                return Double.parseDouble(Driver.readLine(prompt));
            } catch(NumberFormatException nfe) {
                System.out.println("Please enter only an integer value.");
            }
        }
    }

	public static void main(String args[]) throws IOException {

		Person user;
		Rectangle r;
		Circle c;
		double len;
		double wid;
		double rad;

		user = new Person(readLine("What is your name?"));

		System.out.println("\nHello " + user.getName() + ",");
		System.out.println("You can enter the dimensions of a rectangle.");
		System.out.println("The area of the rectangle will then be calculated");
		System.out.println("and displayed.");

		len = readDouble("\nEnter the length of the rectangle:");

		wid = readDouble("\nEnter the width of the rectangle:");

		r = new Rectangle(len, wid);

		System.out.println("\nThe area of the rectangle is:  " + r.getArea());


		System.out.println("You can also enter the radius of a circle.");
		System.out.println("The area of the circle will then be calculated");
		System.out.println("and displayed.");

		rad = readDouble("\nEnter the radius of the circle:");

		c = new Circle(rad);

		System.out.println("\nThe area of the circle is:  " + c.getArea(rad));
	}
}