package board;

public abstract class Board {
	protected char cells[][] = new char[10][10];

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
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells.length; j++) {
				if (j == 0)
					sb.append((i + 1) + ")\t(" + cells[i][j] + ")\t");
				else
					sb.append("(" + cells[i][j] + ")\t");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}	
}
