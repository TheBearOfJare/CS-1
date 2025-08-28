public class Cat {
	private String color;
	private int age;
	private int weight;
	private String disposition;

	public Cat () {
		color = "Tortoise shell";
		age = 1;
		weight = 10;
		disposition = "Aloof";
	}

	public Cat (String c, int a, int w, String d) {
		color = c;
		age = a;
		weight = w;
		disposition = d;
	}

	public void grow () {
		age++;
	}

	public void grow (int w) {
		age++;
		weight += w;
	}

	public void grow (int a, int w) {
			age += a;
			weight += w;
	}

	public void setColor (String c) {
		color = c;
	}

	public void setDisposition (String d) {
		disposition = d;
	}

	public void eat (String s) {
		System.out.println("I like " + s);
	}

    public int getWeight() {
        return weight;
    }

	public void printCharacteristics () {
		System.out.println();
		System.out.println("I am a cat");
		System.out.println("My classification is: Feline");
		System.out.println("My color is:  " + color);
		System.out.println("My age is:  " + age);
		System.out.println("My weight is:  " + weight);
		System.out.println("My disposition is:  " + disposition);
	}
}
