package embarkation;

public class AircraftCarrier extends Embarkation {
	@Override
	public int usedSlotsModifier() {
		int slotsUsed = 4;

		return slotsUsed;
	}
}
