import java.io.*;

public class PartB {
	public static void main(String args[]) {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			byte b1 = 0, b2 = 0;
            Long product;

			System.out.print("Enter a value for b1:  ");
			b1 = Byte.parseByte(reader.readLine());

			System.out.print("Enter a value for b2:  ");
			b2 = Byte.parseByte(reader.readLine());

			product = Long.parseLong((b1 * b2)+"");

			System.out.println("The product of the 2 numbers entered is:  " + product);
		} catch(Exception e) {
			e.printStackTrace(System.err);
		}
	}
}