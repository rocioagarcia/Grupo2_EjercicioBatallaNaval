package embarkation;

import board.PositionBoard;

public abstract class Ship {
	protected int slotsUsed;

	public int getSlotsUsed() {
		return slotsUsed;
	}

	public void setSlotsUsed(int slotsUsed) {
		this.slotsUsed = slotsUsed;
	}

	public int usedSlotsModifier() {
		int slotsUsed = 0;

		return slotsUsed;
	}
	public abstract void position(PositionBoard pb, String orientation);
}
