/*
 * Name: Jared Gleisner, and Sam Torline
 *
 * Date: 3/21/25
 * 
 * Lab Number: 11
 * 
 * Instructor: Dcn. TenBroek
 * 
 *
 */

class PartC {
	public static void main(String [] args) {
		long loopControl = 100;
	
		do {
			if ((loopControl % 3) == 0)
				System.out.println(loopControl);
			
			loopControl--;
		} while (loopControl > 0);
	}
}