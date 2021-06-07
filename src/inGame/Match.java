package inGame;

import board.Board;
import board.EnemyBoard;
import board.PositionBoard;
import players.Player;

public class Match {
	private Turn turn = Turn.getInstance();

	public Turn getTurn() {
		return this.turn;
	}

	public void setTurn(Turn turn) {
		this.turn = turn;
	}

	public void startMatch() {
		Player p;
		GameModes gm = new GameModes();
		gm.chooseGameMode();
		turnPlayerStart(gm);
		gm.startGame();
		p = turnPlayer();
		p.shot();//reever
		showBoard();
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

	public void turnPlayerStart(GameModes gm) {
		if (Math.random() > 0.5) {
			setTurnPlayer(gm.getPlayer1());
			System.out.println(String.format("El turno es de jugador 1"));
		} else {
			setTurnPlayer(gm.getPlayer2());
			System.out.println("El turno es del jugador 2");
		}
	}
    
	public void setTurnPlayer(Player player){
		   this.getTurn().setPlayer(player);
	}
	
	public Player turnPlayer() {
		return(this.turn.getPlayer());
	}
	public void shotValidator(int x, int y) {

	}
}