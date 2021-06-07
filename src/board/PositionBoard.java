package board;

import java.util.ArrayList;

import embarkation.Fleet;
import embarkation.Point;
import embarkation.Ship;

public class PositionBoard extends Board {
   private Fleet fleet;
   public static final String VERTICAL = "vertical";
   public static final String HORIZONTAL = "horizontal";
   
public Fleet getFleet() {
	return fleet;
}

public void setFleet(Fleet fleet) {
	this.fleet = fleet;
}

public ArrayList<Ship> getFleetShips(){
	return(this.fleet.getShips());
}

public void positionFleet() {
	ArrayList<Ship> ships = this.getFleetShips();	
	ships.forEach(s->{boolean ok = false;
	                  while(!ok) {
	                	  Point p = new Point(generatePosition(),generatePosition());
	                	  String orientation = defineOrientation();
	                	  if(s.canPositionMyself(p,orientation,this))
	                			  ok = true;	                	  
	                  }
	});
   // });
} 

public String defineOrientation() {
	String o;
      if (Math.random() > 0.5) 
	       o = VERTICAL;
      else 
	      o = HORIZONTAL;
      return (o);
}

}
