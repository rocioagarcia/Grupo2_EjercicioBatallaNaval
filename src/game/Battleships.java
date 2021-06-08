package game;

import java.util.Scanner;
import inGame.Match;

public class Battleships {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String opt = "";
		System.out.println("¿Quiere comenzar una partida? S/N");
		opt = scan.nextLine();
		while (opt.equalsIgnoreCase("s")) {
			Match m1 = new Match();
			m1.startMatch();
			System.out.println("Partida finalizada! Ganó: \n ¿Quiere jugar otra partida? S/N");
			opt = scan.nextLine();
		}
		System.out.println("Programa finalizado");
	}
}
