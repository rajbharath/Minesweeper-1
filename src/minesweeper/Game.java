package minesweeper;

import java.io.*;

class Game {
	// total mine count should be determined by the Game
	private static final int totalMineCount = 10;
	boolean allMinesIdentified = false;
	boolean openedMine = false;

	public Game() throws IOException {
		// TODO Auto-generated constructor stub
		int row, col;

		Grid grid = new Grid(10, new RandomGridFiller());
		// Board board = new Board();
		// MineChecker bomb = new MineChecker(); // deleted the class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// grid.fill();
		grid.test();
		// board.fillBoard();
		grid.display();
		do {
			System.out.println("Enter the Row No:(From 0 to 9)");
			row = getUserVal(br);
			System.out.println("Enter the Col No:(From 0 to 9)");
			col = getUserVal(br);

			// checking a cell is mine or not Game resp. checking a cell is mine
			// is a resp of Cell.
			// and finding a cell using Row,Column is a resp of cells.
			// cells are a data of Grid class. it should not be accessed in
			// MineChecker. Mine checker is not needed.

			if (grid.open(row, col)) {
				grid.display();
				if (grid.getUnopenedCellsCount() == totalMineCount) {

					allMinesIdentified = true;
					// System.exit(0);
				}
			} else {

				openedMine = true;
				// System.exit(0);
			}
			// bomb.checkMine(row, col, cells);
			/*
			 * Board opens a Cell in cells. for this Grid can access its
			 * members.
			 * 
			 * This step makes the Board unused Class. remove Board
			 */
			// grid.open(row, col);

			// Board should not decide winning of Game. It should be in Game

		} while (!allMinesIdentified && !openedMine);

		decideGameStatus();

	}

	public static void main(String arg[]) throws IOException {
		new Game();
	}

	private void decideGameStatus() {
		if (allMinesIdentified) {
			System.out.println("Congratulations\n You Won");
		} else if (openedMine) {
			System.out
					.println("Sorry..You stepped on a MineChecker...\nGame Over");
		}
	}

	int getUserVal(BufferedReader br) throws IOException {
		int value = 0;
		while (true) {
			try {
				value = Integer.parseInt(br.readLine());
			} catch (NumberFormatException nfe) {
				System.out.println("Please Enter a Number");
				continue;
			}
			if (value < 0 || value > 9) {
				System.out.println("Value should be in the range of 0 - 9");
				continue;
			}
			return value;
		}
	}
}