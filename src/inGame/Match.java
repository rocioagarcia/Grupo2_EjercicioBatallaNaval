package inGame;

import java.util.Collection;

import board.Board;
import board.MainBoard;
import board.PositionBoard;
import embarkation.Fleet;
import embarkation.Point;
import embarkation.Ship;
import players.Player;

public class Match {
	public static final char DAMAGED = '*';
	public static final char SUNKEN = 'X';
	public static final char WATER = 'A';
	private Turn nextTurn;//esta variable juardará el jugador q tiene el turno.
   
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
        gm.startGame();// este metodo inicializa el juego, una vez ejecutado este metodo las flotas de cada jugador estaran creadas y posicionadas.
        turnPlayerStart(gm);//setea en nextTurn el jugador que inicia la partida
        /*----- PRUEBA-------*/
        Player p = getPlayerNextTurn();//obtengo el jugador q tiene la partida
        showPositionBoardOf(p); // muestro el TABLERO DE POSICION del jugador q tiene la partida
        Player o = determineOpponent(p,gm);// obtengo el oponente del jugador q tiene la partida
        showPositionBoardOf(o); // muestro el TABLERO DE POSICION del oponenente, para conocer como esta distribuida su flota       
        for(int i = 1; i <= 30; i++) {  // realizo una prueba del 30 disparos del jugador q tiene la partida      	
	        Point shot = p.shot(); //me guardo en la variable shot, el disparo realizado por el jugador q tiene la partida
	        System.out.println("Disparo en: X-> "+(shot.getX()+1)+" Y-> "+(shot.getY()+1));//imprimo el disparo que se realizo
	        if(resultShot(shot, p, gm)) {//determino si el disparo se pudo efectuar
	        	System.out.println("Disparo exitoso");
	        	showMainBoardOf(p);//muestro el TABLERO PRINCIPAL del jugador q disparo
	        	showPositionBoardOf(o);//muestro el TABLERO DE POSICION DEL OPONENTE.
	        	//realizo esto para saber si ejecutó bien el disparo, comparando ambos tableros
	        }
	        else
	        	System.out.println("No se pudo realizar el disparo");// muestro el msj que el disparo no tuvo efecto, ya que se disparó en esa posicion
        }
        /*---------FIN PRUEBA--------*/
	
	}
	
	public void turnPlayerStart(GameModes gm) {
		//determina el jugador que inicia el juego 
		//guarda el jugador que inicia en la variable nextTurn
		if (Math.random() > 0.5) {
			setPlayerNextTurn(gm.getPlayer1());
			System.out.println(String.format("El turno es de jugador 1")+this.getPlayerNextTurn());
		} else {
			setPlayerNextTurn(gm.getPlayer2());
			System.out.println("El turno es del jugador 2" +this.getPlayerNextTurn());
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

    public boolean resultShot(Point shot, Player player,  GameModes gm) {
        boolean ok = false;
    	Player opponent = determineOpponent(player, gm);
    	if(!(opponent.getPositionBoard().isBusyIn(shot))) {
    		mark(WATER,shot, player.getMainBoard());
    		mark(WATER,shot, opponent.getPositionBoard());
    		ok = true;
    	}
    	else if(ShipInPosition(shot, opponent.getFleet()) != null){
    		Ship s = ShipInPosition(shot, opponent.getFleet());
    		ok = markImpact(s.recieveShot(shot),s,shot, player.getMainBoard(), opponent.getPositionBoard());
    	}
    	else
    		ok = false;
        return (ok);
    }
    
    public Ship ShipInPosition(Point p, Fleet f) {
    	return(f.shipIncludePoint(p));
    }
	
    public void mark(char mark, Point shot, Board b) {
    	b.markPosition(shot, mark);
    }
    
    public void markSunken(char mark, Collection<Point>points, Board b) {
    	b.markPointsBoard(points,mark);
    }
    
   public boolean  markImpact(char res,Ship s, Point shot, MainBoard mb, PositionBoard pb){
       boolean ok = true;
	   switch (res) {
    	case DAMAGED:{
    		         mark(DAMAGED, shot, pb);
    		         mark(DAMAGED, shot, mb);
    	             break;}
    	case SUNKEN:{
    		        markSunken(	SUNKEN, s.getPoints(),pb);
    		        markSunken(	SUNKEN, s.getPoints(),mb);
                    break;
                    }
    	
	   default:
		         ok = false;
       }
	   return ok;
   }
    
	public Player determineOpponent(Player player, GameModes gm) {
		if(player.getPlayerNumber() == 1)
			return gm.getPlayer2();
		else
			return gm.getPlayer1();
	}
	
}