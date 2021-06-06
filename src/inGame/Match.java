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
	}

	public void showBoard() {
		Board bd = new Board();
		bd.printBoard();
	}

}