public class PartA {
	public static void main(String args[]) {
		byte b1 = 17, b2 = 45;

		b1 ^= b2;
        // b1 = 60 b2 = 45
		b2 ^= b1;
        // b1 = 60 b2 = 17
		b1 ^= b2;
        // b1 = 45 b2 = 17

		System.out.println("b1:  " + b1);
		System.out.println("b2:  " + b2);
	}
}