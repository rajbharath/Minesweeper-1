/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import minesweeper.Grid;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * 
 * @author Prabhu
 */
public class GridTest {

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	/**
	 * Test of fill_Cells method, of class Grid.
	 */
	@Test
	public void test_Fill_Cells_PopulatesMinesAndOtherCells() {
		Grid instance = new Grid(10);
		System.out.println("Checks whether total no. mines is 10");
		assertEquals(10, instance.getTotalMinesCount());
		System.out
				.println("Checks 10 cells are mines & others no.of mines nearby");
		instance.fillCells();
		assertEquals(0, instance.getTotalMinesCount());
	}

	/**
	 * Test of check_For_Mine method, of class Grid.
	 */
	@Test
	public void testCheck_Mine_If_Not_Place_One() {
		System.out.println("Tests Check MineChecker If Not Place One");
		int row = 0;
		int col = 0;
		int total_mines = 0;
		int row_col;
		Grid instance = new Grid(10);
		while (total_mines > 0) {
			row_col = (int) (Math.random() * 99);
			row = (int) row_col / 10;
			col = row_col % 10;
			assertEquals(instance.getTotalMinesCount(),
					instance.checkMineIfNotPlaceOne(row, col, total_mines));
		}

	}

	/**
	 * Test of set_Mine_Count method, of class Grid.
	 */
	@Test
	public void test_Set_Mine_Count_IncrementsNeighbouringCellCountByOne() {
		System.out
				.println("Tests MineChecker Neighbouring cells are incremented");
		int row = 0;
		int col = 0;
		int mine_count = 0;
		Grid instance = new Grid(10);
		instance.setMineCount(row, col);
		assertEquals(mine_count + 1, instance.getCellAt(row, col).getValue());
	}

	@Test
	public void testGetUnopenedCellsCount() {
		Grid cells = new Grid(10);
		assertEquals(100, cells.getUnopenedCellsCount());
		cells.open(0, 0);
		cells.open(1, 1);
		cells.open(1, 2);
		assertEquals(97, cells.getUnopenedCellsCount());
	}
}