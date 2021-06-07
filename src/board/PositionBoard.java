package board;

import java.util.ArrayList;

import embarkation.Fleet;
import embarkation.Point;
import embarkation.Ship;

public class PositionBoard extends Board {
   private Fleet fleet;

public Fleet getFleet() {
	return fleet;
}

public void setFleet(Fleet fleet) {
	this.fleet = fleet;
}

public void positionFleet() {
	ArrayList<Ship> ships = this.fleet.getShips();	
	//ships.forEach(s->{);
   // });
}

public String defineOrientation() {
	String o;
      if (Math.random() > 0.5) 
	       o = "verical";
      else 
	      o = "horizontal";
      return (o);
}

public int generatePosition() {
	return ((int) (Math.random()*(10-1)) + 1);
}

/*public Point initialPosition (int cantSlotsUsed) {
	Point p = new Point(this.generatePosition(),this.generatePosition());
	if (cantSlotsUsed == 1)
		 return((!(busy(p)))? p : initialPosition(cantSlotsUsed));
		
	String orientation = defineOrientation();
   
}*/

public boolean busy(Point p) {
	return((this.cells[p.getX()][p.getY()]) != ' ');
}

}
