package embarkation;

import board.PositionBoard;

public class Submarine extends Ship {

	public Submarine() {
		this.slotsUsed = 3;
	}
	
	public void markPoints(PositionBoard pb) {
		pb.markPointsBoard(this.getPoints(), 'S');
	}
}
