package embarkation;

import board.PositionBoard;

public class Battleship extends Ship {

	public Battleship() {
		this.slotsUsed = 3;
	}
	
	public void markPoints(PositionBoard pb) {
		//marca con una B en cada posicion que ocupa en el tablero
		pb.markPointsBoard(this.getPoints(), 'B');
	}
}
