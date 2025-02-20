public class Driver {
	public static void main(String args[]) {
		int a = 3, b = 17, c = 4;
		float d = (float) 35.3;
		double e = 35.3;
		double f = 0;

		f = (double) b / (double) a;
		System.out.println("f:  " + f);

		a++;
		System.out.println("a:  " + a);

		a = a + 42;
		System.out.println("a:  " + a);

		a = b + c * 2;
		System.out.println("a:  " + a);

		a = (b + c) * 2;
		System.out.println("a:  " + a);

		a = b % c;
		System.out.println("a:  " + a);
	}
}