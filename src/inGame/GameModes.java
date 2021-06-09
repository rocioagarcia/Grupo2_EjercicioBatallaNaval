package inGame;

import java.util.Scanner;

import players.Computer;
import players.Person;
import players.Player;

public class GameModes {
	public static final String COMPUTER = "computer";
	private Player player1;
	private Player player2;

	public Player getPlayer1() {
		return player1;
	}

	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}

	public Player getPlayer2() {
		return player2;
	}

	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}

	public void chooseGameMode() {
		Scanner scan = new Scanner(System.in);
		System.out.println(
				"ELige el modo de juego : \n1 - CvC\n2 - PvC\n(Ingrese solamente el número de la opción a elegir.)");

		int answer = scan.nextInt();

		while (answer < 1 || answer > 2) {
			System.out.println("La opción elegida no es correcta. Ingrese: \n1 - CvC\n2 - PvC:");
			answer = scan.nextInt();
		}

		switch (answer) {
		case 1:
			System.out.println("Modo de juego 'CvC' elegido.");
			player1 = new Computer(COMPUTER,1);
			player2 = new Computer(COMPUTER,2);
			break;
		case 2:
			System.out.println("Modo de juego 'PvC' elegido.");
			System.out.println("Ingrese su nombre: ");
			String aName = scan.nextLine();
			player1 = new Person(aName,1);
			player2 = new Computer(COMPUTER,2);
			break;
		default:
			break;
		}
	}
	
	public void startGame() {
		this.player1.start();
		this.player2.start();
	}
}
