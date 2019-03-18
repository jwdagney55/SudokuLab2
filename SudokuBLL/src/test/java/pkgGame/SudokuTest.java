package pkgGame;

import static org.junit.Assert.*;

import org.junit.Test;
import pkgGame.Sudoku;

public class SudokuTest {
	private int[][] sudoku = {{1,2,3,4},{3,4,2,1},{2,1,4,3},{4,3,1,2}};
	private int[][] partS = {{1,2,3,4},{3,0,2,1},{2,1,4,3},{4,3,1,2}};
	@Test
	public void TestRegionNbr() throws Exception {
		int[][] puzzle= {{1,2,3,4},{2,3,4,1},{3,4,1,2},{4,1,2,3}};
		Sudoku myS=new Sudoku(puzzle);
		int[] expected= {3,4,4,1};
		int[] actual=myS.getRegion(2, 1);
		assertArrayEquals(expected, actual);
	}

	@Test (expected = Exception.class)
	public void TestSudoku() throws Exception {
		int size = 26;
		Sudoku s = new Sudoku(size);
	}
	
	@Test
	public void TestHasDuplicates() throws Exception {
		Sudoku myS = new Sudoku(sudoku);
		assertFalse(myS.hasDuplicates());
	}
	
	public void TestIsValidValue() throws Exception {
		Sudoku myS = new Sudoku(sudoku);
		assertTrue(myS.isValidValue(1, 1, 4));
	}
}
