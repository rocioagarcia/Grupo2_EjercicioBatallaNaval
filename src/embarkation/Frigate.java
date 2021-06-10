package embarkation;

import java.util.Collection;

import board.PositionBoard;

public class Frigate extends Ship {

	public Frigate() {
		this.slotsUsed = 1;
	}
	
	public boolean canPositionMyself(Point p, String orientation, PositionBoard pb) {
		boolean ok = false;
		if (!(pb.isBusyIn(p))) {
			this.addPoint(p);
			markPoints(pb);
			ok = true;
		}
		return (ok);
	}
    
	public void markPoints(PositionBoard pb) {
		//marca con una F en cada posicion que ocupa en el tablero
		pb.markPointsBoard(this.getPoints(), 'F');
	}
}
