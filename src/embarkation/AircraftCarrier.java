package embarkation;

import board.PositionBoard;

public class AircraftCarrier extends Ship {

	public AircraftCarrier() {
		this.slotsUsed = 4;
	}
	
	public void markPoints(PositionBoard pb) {
		pb.markPointsBoard(this.getPoints(), 'C');
	}
}
