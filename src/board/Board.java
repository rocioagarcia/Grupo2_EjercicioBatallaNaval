package board;

public class Board {
	private char cells[][] = new char[10][10];

	public Board() {
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				cells[i][j] = ' ';
			}
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
			sb.append(c + "\t");
		}
		sb.append("\n");
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				if (j == 0)
					sb.append((i + 1) + ")\t " + cells[i][j] + ")");
				else
					sb.append("\t(" + cells[i][j] + ")");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
