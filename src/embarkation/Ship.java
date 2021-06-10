package embarkation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import board.MainBoard;
import board.PositionBoard;
import inGame.Match;

public abstract class Ship {
	protected int slotsUsed;
	private Collection<Point> points;
	protected boolean sunken;
	
	public boolean isSunken() {
		return sunken;
	}

	public void setSunken(boolean sunken) {
		this.sunken = sunken;
	}

	public Ship() {
		 this.points = new ArrayList<Point>();
		 this.sunken = false;
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
			return(verticalPosition(p, pb));
		else
			return(horizontalPosition(p, pb));
	}
	
    public boolean verticalPosition(Point p, PositionBoard pb) {
    	Collection<Point> arrayPoints = new ArrayList<Point>();
		int pos = 1;
		boolean ok = true;	
	    while (!(pb.isBusyIn(p)) & (pos <= getSlotsUsed()) & ok) {
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
		    setPoints(arrayPoints);
		    markPoints(pb);
		    return(true);
		}
		else  
		    return (false);
	}
	
	public boolean horizontalPosition(Point p, PositionBoard pb) {
		Collection<Point> arrayPoints = new ArrayList<Point>();
		int pos = 1;
		boolean ok = true;
		while(!(pb.isBusyIn(p)) & (pos <= getSlotsUsed()) & ok) {
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
		    setPoints(arrayPoints);
		    markPoints(pb);
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
	
	public char recieveShot(Point p) {
		char result = '.';
		if(!(isSunken())) {
			if(getSlotsUsed() == 1) {
				setSunken(true);
				result = 'X';
			}
			else {			
			setSlotsUsed(getSlotsUsed()-1);
			result = '*';
		    }
	     }
		return(result);
	}
	
	public boolean includePoint(Point point) {
		boolean ok = false;
		if(!(points.isEmpty())) {
			Iterator<Point> it = points.iterator();
			while (it.hasNext() & !(ok)) {
				Point p =  it.next();
				if ((p.getX() == point.getX()) & (p.getY() == point.getY()))
					ok = true;		
		    }
		}
		return(ok);
	}
}
