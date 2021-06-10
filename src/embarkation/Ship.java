package embarkation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import board.PositionBoard;

public abstract class Ship {
	protected int slotsUsed;
	private Collection<Point> points;
	protected boolean sunken; //variable para identificar si el barco esta hundido
	
	public Ship() {//constructor crea una coleccion de puntos vacia e inicializa su estado de hundido en false
		 this.points = new ArrayList<Point>();
		 this.sunken = false;
	}
	
	public boolean isSunken() {
		return sunken;
	}

	public void setSunken(boolean sunken) {
		this.sunken = sunken;
	}

	public int getSlotsUsed() {
		return slotsUsed;
	}

	public void setSlotsUsed(int slotsUsed) {
		this.slotsUsed = slotsUsed;
	}
	
	public Collection<Point> getPoints() {
		return points;
	}

	public void setPoints(Collection<Point> points) {
		this.points = points;
	}

	public int usedSlotsModifier() {
		int slotsUsed = 0;

		return slotsUsed;
	}
	
	public void addPoint(Point p) {
		//agrega un punto de coordenadas x e y en la coleccion de puntos del barco
		this.points.add(p);
	}
	
	//este metodo marca en el tablero la inicial del barco, es abstracto, xq cada barco coloca su incial en la celda
	public abstract void markPoints(PositionBoard pb);
	
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
			          if(p.getY()+ 1 > 9)//se verifica que el punto a incrementar no supere la dimencion del eje Y del tablero
				            ok = false;
					  else {
						     int x = p.getX();
						     int y = p.getY() + 1;
						     p = new Point(x,y);
						     pos++;						    
						}
		}
		if (ok & (!(pb.isBusyIn(p)))) {//verifica que se haya podido posicionar el barco
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
			          if(p.getX() + 1 > 9)//se verifica que el punto a incrementar no supere la dimencion del eje X del tablero
				            ok = false;
					  else {
						     int x = p.getX() + 1;
						     int y = p.getY();
						     p = new Point(x,y);
						     pos++;						    
						}
		}
		if (ok & (!(pb.isBusyIn(p)))) {//verifica que se haya podido posicionar el barco
		    setPoints(arrayPoints);
		    markPoints(pb);
		    return(true);
		}
		else  
		    return (false);
	}
	
	public char recieveShot(Point p) {
		char result = '.'; //inicializo en cualquier caracter el resultado
		if(!(isSunken())) {
			if(getSlotsUsed() == 1) {//si la cantidad de casillas que tiene es  = 1 debe setear su variable sunken a true, xq significa q el disparo hundirá el barco
				setSunken(true);
				result = 'X';
			}
			else				
			   result = '*';
			setSlotsUsed(getSlotsUsed()-1);
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
