package inGame;

import java.util.Scanner;

import players.Computer;
import players.Person;
import players.Player;

public class GameModes {
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
			Player com1 = new Computer();
			Player com2 = new Computer();
			break;
		case 2:
			System.out.println("Modo de juego 'PvC' elegido.");
			Player player = new Person();
			System.out.println("Ingrese su nombre: ");
			player.setName(scan.nextLine());
			Player com = new Computer();
			break;
		default:
			break;
		}
	}
}
