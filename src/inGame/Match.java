package inGame;

import board.Board;

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
	}

	public void showBoard() {
		Board bd = new Board();
		bd.printBoard();
	}

	public boolean randomTurn() {
		boolean rTurn = false;
		if (Math.random() > 0.5) {
			rTurn = true;
			System.out.println(String.format("El turno es de %s"));
		} else {
			rTurn = false;
			System.out.println("El turno es del jugador 2.");
		}

		return rTurn;
	}
}