package players;

import java.util.Random;

import board.MainBoard;
import board.PositionBoard;
import embarkation.Fleet;

public abstract class Player {
	private String name = "";
	private Fleet fleet;
	private MainBoard mainBoard;
	private PositionBoard positionBoard;

	public Player() {
		this.fleet = new Fleet();
		this.mainBoard = new MainBoard();
		this.positionBoard = new PositionBoard();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
	
	public void shot() {
		Random rand = new Random();
		int x = rand.nextInt(10);
		int y = rand.nextInt(10);

	}

	public Fleet getFleet() {
		return fleet;
	}

	public void setFleet(Fleet fleet) {
		this.fleet = fleet;
	}

	public MainBoard getMainBorad() {
		return mainBoard;
	}

	public void setMainBorad(MainBoard mainBorad) {
		this.mainBoard = mainBorad;
	}

	public PositionBoard getPositionBoard() {
		return positionBoard;
	}

	public void setPositionBoard(PositionBoard positionBoard) {
		this.positionBoard = positionBoard;
	}
}
