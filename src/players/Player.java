package players;

import java.util.Random;

import board.MainBoard;
import board.PositionBoard;
import embarkation.Fleet;
import embarkation.Point;

public abstract class Player {
	
	protected String name;
	protected int playerNumber;
	private Fleet fleet;
	private MainBoard mainBoard;
	private PositionBoard positionBoard;

	public Player(String aName, int number) {//constructor crea un jugador con un nombre y nro de jugador, y crea sus tableros y flota
		this.fleet = new Fleet();
		this.mainBoard = new MainBoard();
		this.positionBoard = new PositionBoard();
		name = aName;
        playerNumber = number;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
	
	public Fleet getFleet() {
		return fleet;
	}

	public void setFleet(Fleet fleet) {
		this.fleet = fleet;
	}

	public MainBoard getMainBoard() {
		return mainBoard;
	}

	public void setMainBoard(MainBoard mainBoard) {
		this.mainBoard = mainBoard;
	}

	public PositionBoard getPositionBoard() {
		return positionBoard;
	}

	public void setPositionBoard(PositionBoard positionBoard) {
		this.positionBoard = positionBoard;
	}
	
	public void start() {
		//crea la flota con sus 9 embarcaciones;
		this.fleet.createFleet();
		/* relacion bireccional*/
		//asigna la flota creada a su tablero de posicion
		this.positionBoard.setFleet(this.getFleet());
		//asigna el tablero de posicion a la flota
		this.fleet.setPositionBoard(this.getPositionBoard());
		/* fin */
		//se distribuye la flota en el tablero de posicion
	    definePositionFleet();
	}
	
	public void definePositionFleet() {
		//este metedo delega al tablero de posicion distribuir la flota
		positionBoard.positionFleet();
	}
	
	public void showPositionBoard() {
		//muestra en pantalla el tablero de posicion del jugador
		positionBoard.printBoard();
	}
	
	public void showMainBoard() {
		//muestra en pantalla el tablero principal del jugador
		mainBoard.printBoard();
	}
	
	
	public abstract Point shot(); //metodo abstracto del disparar, la implementacion depende del tipo de jugador	

}
