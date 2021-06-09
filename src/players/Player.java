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

	public Player(String aName, int number) {
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
	
	public void start() {
		this.fleet.createFleet();
		this.positionBoard.setFleet(this.getFleet());
		this.fleet.setPositionBoard(this.getPositionBoard());
	    definePositionFleet();
	}
	
	public void definePositionFleet() {
		positionBoard.positionFleet();
	}
	
	public void showPositionBoard() {
		positionBoard.printBoard();
	}
	
	public void showMainBoard() {
		mainBoard.printBoard();
	}
	
	public abstract Point shot();
	
	public int generateShot() {
		return ((int) (Math.random()*(9-0)) + 0);
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
}
