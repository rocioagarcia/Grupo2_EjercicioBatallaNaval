package inGame;

import players.Player;

public final class Turn {
	 private static Turn instance;
	 private Player player;

	public static Turn getInstance() {
	    if (instance == null) {
	        instance = new Turn();
	    }
	    return instance;
	}
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	}
