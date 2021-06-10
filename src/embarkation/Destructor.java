package embarkation;

import board.PositionBoard;

public class Destructor extends Ship {

	public Destructor() {
		this.slotsUsed = 2;
	}
	
	public void markPoints(PositionBoard pb) {
		//marca con una D en cada posicion que ocupa en el tablero
		pb.markPointsBoard(this.getPoints(), 'D');
	}
}
