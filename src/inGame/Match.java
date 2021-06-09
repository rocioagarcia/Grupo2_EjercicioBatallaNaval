package inGame;

import board.Board;
import board.MainBoard;
import board.PositionBoard;
import embarkation.Point;
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
        turnPlayerStart(gm);
        Player p = getPlayerNextTurn();
        showPositionBoardOf(p);
        showMainBoardOf(p);
        Point point = p.shot();
        Player opponent = determineOpponent(p,gm);
        checkShot(point, p.getMainBoard(), opponent.getPositionBoard());
        
	
	}
    public void showPositionBoardOf(Player p) {
    	System.out.println("\t\tTABLERO DE POSICION DEL JUGADOR: "+p);
    	p.showPositionBoard();
    }
    
    public void showMainBoardOf(Player p) {
    	System.out.println("\t\tTABLERO PRINCIPAL: "+p);
    	p.showMainBoard();
    }
    
	/*public void showBoard() {
		System.out.println("Position board:");
		Board positionBoard = new PositionBoard();
		positionBoard.printBoard();
		System.out.println("Main board:");
		Board enemyBoard = new MainBoard();
		enemyBoard.printBoard();
	}*/

	public void turnPlayerStart(GameModes gm) {
		if (Math.random() > 0.5) {
			setPlayerNextTurn(gm.getPlayer1());
			System.out.println(String.format("El turno es de jugador 1")+this.getPlayerNextTurn());
		} else {
			setPlayerNextTurn(gm.getPlayer2());
			System.out.println("El turno es del jugador 2" +this.getPlayerNextTurn());
		}
	}
   
	/*public boolean checkShot(Point point, MainBoard mb, PositionBoard pb) {
          return((markShotMainBoard(point, mb, pb))?true:false);
	}
	*/
	public Player determineOpponent(Player player, GameModes gm) {
		if(player.getPlayerNumber() == 1)
			return gm.getPlayer2();
		else
			return gm.getPlayer1();
	}
	
/*	public boolean markShotMainBoard(Point point, MainBoard mb, PositionBoard pb) {

	}*/
}