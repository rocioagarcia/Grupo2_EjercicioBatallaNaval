package embarkation;

import java.util.ArrayList;

import board.PositionBoard;

public abstract class Ship {
	protected int slotsUsed;
	private ArrayList<Point> points;
	
	public Ship() {
		 this.points = new ArrayList<Point>();
	}

	public int getSlotsUsed() {
		return slotsUsed;
	}

	public void setSlotsUsed(int slotsUsed) {
		this.slotsUsed = slotsUsed;
	}

	public int usedSlotsModifier() {
		int slotsUsed = 0;

		return slotsUsed;
	}
	
	public void addPoint(Point p) {
		this.points.add(p);
	}
	
	public boolean canPositionMyself(Point p, String orientation, PositionBoard pb) {
		if(orientation.equalsIgnoreCase("vertical")) 
			return(this.verticalPosition(p, pb));
		else
			return(this.horizontalPosition(p, pb));
	}
	
    public boolean verticalPosition(Point p, PositionBoard pb) {
    	ArrayList<Point> arrayPoints = new ArrayList<Point>();
		int pos = 1;
		boolean ok = false;
		while(!(pb.isBusyIn(p)) & (pos <= this.getSlotsUsed()) ) {
			arrayPoints.add(p);
			int x = p.getX();
			int y = p.getY() + 1;
			p = new Point(x,y);
			pos++;
			ok = true;			
		}
		if(ok) 
			pb.markPointsPositionBoard(arrayPoints);
		return (ok);
	}
	
	public boolean horizontalPosition(Point p, PositionBoard pb) {
		ArrayList<Point> arrayPoints = new ArrayList<Point>();
		int pos = 1;
		boolean ok = false;
		while(!(pb.isBusyIn(p)) & (pos <= this.getSlotsUsed()) ) {
			arrayPoints.add(p);
			int x = p.getX()+ 1;
			int y = p.getY();
			p = new Point(x,y);
			pos++;
			ok = true;			
		}
		if(ok) 
			pb.markPointsPositionBoard(arrayPoints);		
		return (ok);
	}
	
}
