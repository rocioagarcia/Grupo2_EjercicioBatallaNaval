package embarkation;

import board.PositionBoard;

public class Battleship extends Ship {

	public Battleship() {
		this.slotsUsed = 3;
	}
	
	public void markPoints(PositionBoard pb) {
		pb.markPointsPositionBoard(this.getPoints(), 'B');
	}
}
