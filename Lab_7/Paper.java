public class Paper {
	private boolean cutThrough;
	private int cutLength;

	public Paper (int cl) {
		cutLength = cl;
		cutThrough = false;
	}

	public int getCutLength () {
		return cutLength;
	}

	public void setCutLength (int cl) {
		cutLength = cl;
	}

	public void setCutThrough (boolean ct) {
		cutThrough = ct;
	}

	public void printInformation () {
		System.out.println();
		System.out.println("I am a piece of paper.");
		System.out.println("The length that can still be cut is:  " + cutLength);

		if (cutThrough)
			System.out.println("I have been cut completely across.");
		else
			System.out.println("I have not been cut completely across.");
	}
}