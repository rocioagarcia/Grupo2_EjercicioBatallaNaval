package embarkation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import board.PositionBoard;

public class Fleet {
	private Collection<Ship> ships;
	private PositionBoard positionBoard;
    
	public Fleet () {
		this.ships = new ArrayList<Ship>(9);
		this.positionBoard = new PositionBoard();
	}
	
	public Collection<Ship> getShips() {
		return ships;
	}
	public void addShip(Ship ship) {
		this.ships.add(ship);
	}
	public PositionBoard getPositionBoard() {
		return positionBoard;
	}
	public void setPositionBoard(PositionBoard positionBoard) {
		this.positionBoard = positionBoard;
	}
	
	public void createFleet() {
		addShip(new Frigate());
		addShip(new Frigate());
		addShip(new Destructor());
		addShip(new Destructor());
		addShip(new Destructor());
		addShip(new Battleship());
		addShip(new Submarine());
		addShip(new Submarine());
		addShip(new AircraftCarrier());
	}
	
	public Ship shipIncludePoint(Point p) {
		Iterator<Ship> it = ships.iterator();
		Ship s = null;
		boolean ok = false;		
		while (it.hasNext() & !(ok)) {
			s =  it.next();
			if (s.includePoint(p))
				ok = true;		
	    }
		return (s);
	}
	
}
