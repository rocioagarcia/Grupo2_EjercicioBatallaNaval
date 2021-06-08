package players;

import java.util.Random;

import board.EnemyBoard;
import board.PositionBoard;
import embarkation.Fleet;

public abstract class Player {
	private String name = "";
	private Fleet fleet;
	private EnemyBoard mainBorad;
	private PositionBoard positionBoard;

	public Player() {
		this.fleet = new Fleet();
		this.mainBorad = new EnemyBoard();
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
		//this.positionBoard.positionFleet();
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

	public EnemyBoard getMainBorad() {
		return mainBorad;
	}

	public void setMainBorad(EnemyBoard mainBorad) {
		this.mainBorad = mainBorad;
	}

	public PositionBoard getPositionBoard() {
		return positionBoard;
	}

	public void setPositionBoard(PositionBoard positionBoard) {
		this.positionBoard = positionBoard;
	}
}
