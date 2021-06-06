package embarkation;

public class Submarine extends Embarkation {
	@Override
	public int usedSlotsModifier() {
		int slotsUsed = 3;

		return slotsUsed;
	}
}
