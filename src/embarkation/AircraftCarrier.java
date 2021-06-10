package embarkation;

import board.PositionBoard;

public class AircraftCarrier extends Ship {

	public AircraftCarrier() {
		this.slotsUsed = 4;
	}
	
	public void markPoints(PositionBoard pb) {
		//marca con una C en cada posicion que ocupa en el tablero
		pb.markPointsBoard(this.getPoints(), 'C');
	}
}
