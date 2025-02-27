public class Scissors {
	private int sharpness;
	boolean usable;

	public Scissors (int s) {
		sharpness = s;

		usable = (sharpness > 0) ? true : false;
	}

	public void cutPaper (Paper p, int amountToCut) {
		if (usable) {
			if (p.getCutLength() < amountToCut) {
				p.setCutThrough(true);
				p.setCutLength(0);
			}

			else
				p.setCutLength(p.getCutLength() - amountToCut);
		}

		dullScissor();
	}

	public void dullScissor() {
		sharpness--;

		usable = (sharpness > 0) ? true : false;
	}

	public void sharpenScissor() {
			sharpness++;

			usable = (sharpness > 0) ? true : false;
	}
}