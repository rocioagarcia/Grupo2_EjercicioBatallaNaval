package board;

import java.util.Collection;

import embarkation.Fleet;
import embarkation.Point;
import embarkation.Ship;

public class PositionBoard extends Board {
   public static final String VERTICAL = "vertical";
   public static final String HORIZONTAL = "horizontal";
   private Fleet fleet;
   
public Fleet getFleet() {
	return fleet;
}

public void setFleet(Fleet fleet) {
	this.fleet = fleet;
}

public Collection<Ship> getFleetShips(){
	// solicita a la flota su coleccion de barcos
	return(this.fleet.getShips());
}

public void positionFleet() {
	//posicionamiento de la flota en el tablero
	Collection<Ship> ships = this.getFleetShips();	// la variable ship almacenará los barcos de la flota
	// se itera en cada uno de los barcos pidiendoles q se posicionen
	ships.forEach(s->{boolean ok = false; // esta variable indicará si el barco pudo posicionarse para continuar con el siguiente
	                  while(!ok) {
	                	  Point p = new Point(generatePosition(),generatePosition());//se genera el punto incial para el posicionamiento
	                	  String orientation = defineOrientation(); // se define la orientacion
	                	  // se verifica que el barco pudo posicionarse, en caso de no solicitará otro punto
	                	  if(s.canPositionMyself(p,orientation,this)) 
	                			  ok = true;	                	  
	                  }
	});
} 

public String defineOrientation() {
	// se define la orientacion
      if (Math.random() > 0.5) 
	      return(VERTICAL);
      else 
	      return(HORIZONTAL);
}

}
