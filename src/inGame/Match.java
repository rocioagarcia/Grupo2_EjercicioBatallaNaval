package inGame;

import board.Board;
import board.MainBoard;
import board.PositionBoard;
import embarkation.Fleet;
import embarkation.Point;
import embarkation.Ship;
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
        for(int i = 1; i <= 10; i++) {
	        Point shot = p.shot();
	        System.out.println("Disparo en: X-> "+(shot.getX()+1)+" Y-> "+(shot.getY()+1));
	        if(resultShot(shot, p, gm)) {
	        	System.out.println("Disparo exitoso");
	        	showMainBoardOf(p);
	        }
	        else
	        	System.out.println("No se pudo realizar el disparo");
        }
	
	}
    public void showPositionBoardOf(Player p) {
    	System.out.println("\t\tTABLERO DE POSICION DEL JUGADOR: "+p);
    	p.showPositionBoard();
    }
    
    public void showMainBoardOf(Player p) {
    	System.out.println("\t\tTABLERO PRINCIPAL: "+p);
    	p.showMainBoard();
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
   
    public boolean resultShot(Point shot, Player player,  GameModes gm) {
        boolean ok = false;
    	Player opponent = determineOpponent(player, gm);
    	if(!(opponent.getPositionBoard().isBusyIn(shot))) {
    		markWater(shot, player.getMainBoard());
    		markWater(shot, opponent.getPositionBoard());
    		ok = true;
    	}
    	else if(ShipInPosition(shot, opponent.getFleet()) != null){
    		Ship s = ShipInPosition(shot, opponent.getFleet());
    		if(s.recieveShot(shot, opponent.getPositionBoard(), player.getMainBoard()))
    		     ok = true;
    		else
    		      ok=false;
    	}
    	else
    		ok=false;
        return (ok);
    }
    
    public Ship ShipInPosition(Point p, Fleet f) {
    	return(f.shipIncludePoint(p));
    }
	
    public void markWater(Point shot, Board b) {
    	b.markPosition(shot,'A');
    }
    
	public Player determineOpponent(Player player, GameModes gm) {
		if(player.getPlayerNumber() == 1)
			return gm.getPlayer2();
		else
			return gm.getPlayer1();
	}
	
}