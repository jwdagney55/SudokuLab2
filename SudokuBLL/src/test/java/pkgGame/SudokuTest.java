package pkgGame;

import static org.junit.Assert.*;

import org.junit.Test;
import pkgGame.Sudoku;

public class SudokuTest {
	private int[][] sudoku = {{1,2,3,4},{3,4,2,1},{2,1,4,3},{4,3,1,2}};
	private int[][] partS = {{1,2,3,4},{3,0,2,1},{2,1,4,3},{4,3,1,2}};
	final int[][] part_sudoku={{1,2,0,4},{3,0,2,1},{0,1,4,0},{4,0,1,0}};
	@Test
	public void TestRegionNbr() throws Exception {
		int[][] puzzle= {{1,2,3,4},{2,3,4,1},{3,4,1,2},{4,1,2,3}};
		Sudoku myS=new Sudoku(puzzle);
		int[] expected= {3,4,4,1};
		int[] actual=myS.getRegion(2, 1);
		assertArrayEquals(expected, actual);
	}
	
	@Test (expected=Exception.class)
	public void TestRegionNbr_Test2() throws Exception {
		int[][] puzzle= {{1,2,3,4},{2,3,4,1},{3,4,1,2},{4,1,2,3}};
		Sudoku myS=new Sudoku(puzzle);
		int[] arr=myS.getRegion(5,10);
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
	
	@Test
	public void TestHasDuplicatesF() throws Exception {
		int[][] puzzle= {{1,2,3,4},{2,3,4,1},{3,4,1,2},{4,1,2,3}};
		Sudoku myS = new Sudoku(puzzle);
		assertTrue(myS.hasDuplicates());
	}
	
	public void TestIsValidValue() throws Exception {
		Sudoku myS = new Sudoku(partS);
		assertTrue(myS.isValidValue(1, 1, 4));
	}
	
	public void TestIsValidValueF() throws Exception {
		Sudoku myS = new Sudoku(partS);
		assertFalse(myS.isValidValue(1, 1, 2));
		
	}
	@Test
	public void TestGetPuzzle() throws Exception {
		int[][] puzzle= {{1,2,3,4},{2,3,4,1},{3,4,1,2},{4,1,2,3}};
		Sudoku s2 = new Sudoku(puzzle);
		assertEquals(s2.getPuzzle(), puzzle);
	}
	
	@Test
	public void TestIsSudoku() throws Exception {
		Sudoku s3 = new Sudoku(sudoku);
		assertTrue(s3.isSudoku());
		
	}
	
	@Test
	public void TestIsSudoku2() throws Exception {
		int [][] puzzle = {{1,2,3,4},{2,3,4,1},{3,4,1,2},{4,1,2,4}};
		Sudoku s3 = new Sudoku(puzzle);
		assertFalse(s3.isSudoku());
		
	}
	@Test
	public void isPartialSudoku_test1() throws Exception {
		Sudoku mySu=new Sudoku(part_sudoku);
		boolean expected=true;
		boolean actual=mySu.isPartialSudoku();
		assertEquals(expected,actual);
	}
	
	@Test
	public void isPartialSudoku_test2() throws Exception {
		Sudoku mySu=new Sudoku(sudoku);
		boolean expected=false;
		boolean actual=mySu.isPartialSudoku();
		assertEquals(expected,actual);
	}
	
}
