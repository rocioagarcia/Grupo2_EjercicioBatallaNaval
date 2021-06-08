package embarkation;

import board.PositionBoard;

public class Destructor extends Ship {

	public Destructor() {
		this.slotsUsed = 2;
	}
	
	public void markPoints(PositionBoard pb) {
		pb.markPointsPositionBoard(this.getPoints(), 'D');
	}
}
