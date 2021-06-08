package players;

import java.util.Random;

public abstract class Player {
	private String name = "";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String shot(String shot, int[][] cells) {
		Random rand = new Random();
		int x = (int) rand.nextInt();
		int y = (int) rand.nextInt();

		if (cells[x][y] == 0)
			shot = "Agua";
		else if (cells[x][y] != 0)
			shot = "Averiado";
		else
			shot = "Hundido";
		return shot;
	}

}
