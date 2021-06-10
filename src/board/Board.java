package board;

import java.util.Collection;

import embarkation.Point;

public abstract class Board {	
	public static final int MAX = 10;
    protected char cells[][] = new char[10][10];
    
	public Board() {// contructor que inicializa cad posicion del tablero con ' '
		this.cells = new char [MAX][MAX];
		for(int i = 0; i < MAX; i++ ) {
			for(int j = 0; j < MAX;j++ )
		        this.cells[i][j] = ' ';	
		}
	}
	public char[][] getCells() {
		return cells;
	}

	public void setCells(char[][] cells) {
		this.cells = cells;
	}

	public void printBoard() {
		StringBuilder sb = new StringBuilder();
		sb.append("   ");
		String str = "ABCDEFGHIJ";
		char[] ch = str.toCharArray();
		for (char c : ch) {
			sb.append("\t " + c);
		}
		sb.append("\n");
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < MAX; j++) {
				if (j == 0)
					sb.append((i + 1) + ")\t(" + cells[i][j] + ")\t");
				else
					sb.append("(" + cells[i][j] + ")\t");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}	
	
	public int generatePosition() {
		return ((int) (Math.random()*(9-0)) + 0);
	}

	public boolean isBusyIn(Point p) {
		//retorna true o false si la celda esta ocupada o no
		return((this.cells[p.getX()][p.getY()]) != ' ');
	}
	
	public void markPointsBoard(Collection<Point>arrayPoints, char c) {
		//itera en la coleccion de puntos enviandose, al tablero la coordenada a marcar
		arrayPoints.forEach(p->{markPosition(p, c);});
	}
	
	public void markPosition(Point p, char c) {
		//realiza la marca correspondiente a una posicion del tablero
		this.cells[p.getX()][p.getY()] = c;
	}

}
