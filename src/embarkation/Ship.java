package embarkation;

public abstract class Ship {
	protected static int slotsUsed = 0;

	public static int getSlotsUsed() {
		return slotsUsed;
	}

	public void setSlotsUsed(int slotsUsed) {
		this.slotsUsed = slotsUsed;
	}

	public int usedSlotsModifier() {
		int slotsUsed = 0;

		return slotsUsed;
	}
}
