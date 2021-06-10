package embarkation;

import board.PositionBoard;

public class Submarine extends Ship {

	public Submarine() {
		this.slotsUsed = 3;
	}
	
	public void markPoints(PositionBoard pb) {
		//marca con una S en cada posicion que ocupa en el tablero
		pb.markPointsBoard(this.getPoints(), 'S');
	}
}
