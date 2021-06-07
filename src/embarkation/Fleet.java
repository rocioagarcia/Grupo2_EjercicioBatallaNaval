package embarkation;

import java.util.ArrayList;

import board.PositionBoard;

public class Fleet {
	private ArrayList<Ship> ships;
	private PositionBoard positionBoard;

	public ArrayList<Ship> getShips() {
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
	public Fleet () {
		this.ships = new ArrayList<Ship>(9);
	}
	public void createFleet() {
		this.addShip(new Frigate());
		this.addShip(new Frigate());
		this.addShip(new Destructor());
		this.addShip(new Destructor());
		this.addShip(new Destructor());
		this.addShip(new Battleship());
		this.addShip(new Submarine());
		this.addShip(new Submarine());
		this.addShip(new AircraftCarrier());
	}
	
}
