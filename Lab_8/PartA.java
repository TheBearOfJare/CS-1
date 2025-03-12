import java.io.*;

public class PartA {
	public static void main(String args[]) {
		Sphere s;
		double rad = 0;

		System.out.println("Enter the radius of a sphere in cm:  ");
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			rad = Double.parseDouble(reader.readLine());
		} catch(Exception e) {
			e.printStackTrace(System.err);
		}

		s = new Sphere(rad);

		System.out.println("There volume of your sphere is:  " + s.getVolume());
	}
}