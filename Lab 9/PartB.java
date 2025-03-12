public class PartB {
	public static void main(String args[]) {
		int i = -16;
        // i = 1001 0000

		i >>= 1;
        // i = 1000 1000
		System.out.println("i:  " + i);

		i = -16;
        // i = 1001 0000
		i = (i >>> 1);
        // i = 0100 1000
		System.out.println("i:  " + i);
	}
}