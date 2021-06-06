package embarkation;

public class Battleship extends Embarkation {
	@Override
	public int usedSlotsModifier() {
		int slotsUsed = 3;

		return slotsUsed;
	}
}
