package minesweeper;

public class NeighbourColumnsCalculator {
	private int size;

	public NeighbourColumnsCalculator(int size) {
		this.size = size;
	}

	public int getSize() {
		return size;
	}

	private int columnMin, columnMax;

	public int getColumnMin() {
		return columnMin;
	}

	public void setColumnMinAndMax(int column) {
		if (column > 0 && column < getSize() - 1) {
			columnMin = column - 1;
			columnMax = column + 1;
		}
		checkFirstColumn(column);
		checkLastColumn(column);
	}

	public int getColumnMax() {
		return columnMax;
	}

	private void checkFirstColumn(int column) {
		if (column == 0) {
			columnMin = column;
			columnMax = column + 1;
		}
	}

	private void checkLastColumn(int column) {
		if (column == getSize() - 1) {
			columnMin = column - 1;
			columnMax = column;
		}
	}
}