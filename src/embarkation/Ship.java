package embarkation;

import java.util.ArrayList;
import java.util.Collection;

import board.PositionBoard;

public abstract class Ship {
	protected int slotsUsed;
	private Collection<Point> points;
	
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
    	Collection<Point> arrayPoints = new ArrayList<Point>();
		int pos = 1;
		boolean ok = true;	
	    while (!(pb.isBusyIn(p)) & (pos <= this.getSlotsUsed()) & ok) {
			          arrayPoints.add(p);			
			          if(p.getY()+ 1 > 9)
				            ok = false;
					  else {
						     int x = p.getX();
						     int y = p.getY() + 1;
						     p = new Point(x,y);
						     pos++;
						    
						}

		}
		if (ok & (!(pb.isBusyIn(p)))) {
			//pb.markPointsPositionBoard(arrayPoints);
		    this.setPoints(arrayPoints);
		    this.markPoints(pb);
		    return(true);
		}
		else  
		    return (false);
	}
	
	public boolean horizontalPosition(Point p, PositionBoard pb) {
		Collection<Point> arrayPoints = new ArrayList<Point>();
		int pos = 1;
		boolean ok = true;
		while(!(pb.isBusyIn(p)) & (pos <= this.getSlotsUsed()) & ok) {
			          arrayPoints.add(p);			
			          if(p.getX() + 1 > 9)
				            ok = false;
					  else {
						     int x = p.getX() + 1;
						     int y = p.getY();
						     p = new Point(x,y);
						     pos++;
						    
						}
		}
		if (ok & (!(pb.isBusyIn(p)))) {
			//pb.markPointsPositionBoard(arrayPoints);
		    this.setPoints(arrayPoints);
		    this.markPoints(pb);
		    return(true);
		}
		else  
		    return (false);
	}

	public Collection<Point> getPoints() {
		return points;
	}

	public void setPoints(Collection<Point> points) {
		this.points = points;
	}
	
	public abstract void markPoints(PositionBoard pb);
	
}
