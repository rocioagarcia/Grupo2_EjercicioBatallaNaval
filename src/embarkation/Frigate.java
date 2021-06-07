package embarkation;

import board.PositionBoard;

public class Frigate extends Ship {

	public Frigate() {
		this.slotsUsed = 1;
	}
	
	public boolean canPositionMyself(Point p, String orientation, PositionBoard pb) {
		boolean ok = false;
		if (!(pb.isBusyIn(p))) {
			pb.markPosition(p);
			this.addPoint(p);
			ok = true;
		}
		return (ok);
	}
    
}
