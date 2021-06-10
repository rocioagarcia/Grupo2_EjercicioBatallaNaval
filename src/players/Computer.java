package players;

import embarkation.Point;

public class Computer extends Player {

	public Computer(String aName, int number) {
		super(aName, number);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Point shot() {
		return (new Point(generateShot(),generateShot()));
	}
	
	public int generateShot() {
		return ((int) (Math.random()*(9-0)) + 0);
	}
}
