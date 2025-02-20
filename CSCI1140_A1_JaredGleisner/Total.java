/*
 * Name: Jared Gleisner
 *
 * Date: Feb 20, 2024
 * 
 * Assignment Number: 1
 * 
 * Instructor: TenBroek
 * 
 *
 */

import java.io.*;

public class Total {
	
    public long total;

	public Total() {
        total = 0;
	}
	
	public final void addToTotal(int val) {
        total += val;
	}
	
	public final void subtractFromTotal(int val) {
        total -= val;
	}
	
	public final void incrementTotal() {
        total++;
	}
	
	public final void decrementTotal() {
        --total;
	}
	
	public static final void main(String[] args) {
		Total running = new Total();
		
		running.addToTotal(readInt("Enter an initial value"));
		
		System.out.println();
		running.subtractFromTotal(readInt("Enter an amount to subtract from the initial value"));
		
		System.out.println("Current total is " + running.total);

        System.out.println("\nNow incrementing the total");
        running.incrementTotal();
        System.out.println("Current total is " + running.total);

        System.out.println("\nNow decrementing the total");
        running.decrementTotal();
        System.out.println("Current total is " + running.total);




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
