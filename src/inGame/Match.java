package inGame;

import board.Board;
import board.EnemyBoard;
import board.PositionBoard;

public class Match {
	private boolean turn = false;

	public boolean getTurn() {
		return turn;
	}

	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	public void startMatch() {
		GameModes gm = new GameModes();
		gm.chooseGameMode();
		showBoard();
		setTurn(randomTurn());
		System.out.println(gm.getPlayer1().getName());
	}

	public void showBoard() {
		System.out.println("Position board:");
		Board positionBoard = new PositionBoard();
		positionBoard.printBoard();
		System.out.println("Main board:");
		Board enemyBoard = new EnemyBoard();
		enemyBoard.printBoard();
	}

	public boolean randomTurn() {
		boolean rTurn = false;
		if (Math.random() > 0.5) {
			rTurn = true;
			System.out.println(String.format("El turno es de jugador 1"));
		} else {
			rTurn = false;
			System.out.println("El turno es del jugador 2");
		}

		return rTurn;
	}

	public void shotValidator(int x, int y) {

	}
}