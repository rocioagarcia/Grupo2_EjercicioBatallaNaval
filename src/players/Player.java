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

	public void shot(int x, int y) {
		Random rand = new Random();
		x = rand.nextInt(10);
		y = rand.nextInt(10);

	}
}
