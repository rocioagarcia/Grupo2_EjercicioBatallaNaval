package inGame;

import board.Board;
import board.EnemyBoard;
import board.PositionBoard;
import players.Player;

public class Match {
	private Turn nextTurn;
   
	public Match() {
		this.nextTurn = new Turn();
	}
	public Turn getNextTurn() {
		return this.nextTurn;
	}

	public void setPlayerNextTurn(Player aPlayer) {
		this.nextTurn.setPlayer(aPlayer);
	}
	
	public Player getPlayerNextTurn() {
		return(this.nextTurn.getPlayer());
	}

	public void startMatch() {
		GameModes gm = new GameModes();
		gm.chooseGameMode();
        gm.startGame();
        PositionBoard pb = gm.getPlayer1().getPositionBoard();
        pb.printBoard();
		System.out.println(gm.getPlayer1());
		System.out.println(getPlayerNextTurn());
		turnPlayerStart(gm);
	}

	public void showBoard() {
		System.out.println("Position board:");
		Board positionBoard = new PositionBoard();
		positionBoard.printBoard();
		System.out.println("Main board:");
		Board enemyBoard = new EnemyBoard();
		enemyBoard.printBoard();
	}

	public void turnPlayerStart(GameModes gm) {
		if (Math.random() > 0.5) {
			setPlayerNextTurn(gm.getPlayer1());
			System.out.println(String.format("El turno es de jugador 1")+this.getPlayerNextTurn());
		} else {
			setPlayerNextTurn(gm.getPlayer2());
			System.out.println("El turno es del jugador 2" +this.getPlayerNextTurn());
		}
	}
   
	public void shotValidator(int x, int y) {

	}
}