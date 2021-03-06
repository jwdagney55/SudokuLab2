package pkgHelper;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;

import pkgEnum.ePuzzleViolation;

public class LatinSquareTest {
	
	@Test public void removeZerosTest() {
		// Code from LatinSquare.removeZeros
		int[] arr = {1,2,0,4,5,0,7};
		int[] copiedArray = Arrays.copyOf(arr, arr.length);
		while(ArrayUtils.contains(copiedArray, 0)) {
			copiedArray=ArrayUtils.removeElement(copiedArray, 0);
		}
		int[] expected = {1,2,4,5,7};
		assertTrue(Arrays.equals(expected,copiedArray));
	}

	@Test
	public void hasDuplicates_test1() {

		LatinSquare LS = new LatinSquare();
		int[] arr = { 1, 3, 5, 2, 4 };

		boolean bHasDuplicates = LS.hasDuplicates(arr);

		assertEquals(bHasDuplicates, false);

	}

	@Test
	public void hasDuplicates_test2() {

		LatinSquare LS = new LatinSquare();
		int[] arr = { 1, 3, 5, 2, 3 };

		boolean bHasDuplicates = LS.hasDuplicates(arr);

		assertEquals(bHasDuplicates, true);

	}
	
	@Test
	public void hasDuplicates_test3() throws Exception {
		int[][] Puzzle= {{1,2,3},{2,3,1},{3,1,2}};
		LatinSquare LS=new LatinSquare(Puzzle);
		assertFalse(LS.hasDuplicates());
	}
	
	@Test
	public void hasDuplicates_test4() throws Exception {
		int[][] Puzzle= {{1,3,2},{2,3,1},{3,1,2}};
		LatinSquare LS=new LatinSquare(Puzzle);
		assertTrue(LS.hasDuplicates());
	}

	@Test
	public void doesElementExist_Test1() {
		LatinSquare LS = new LatinSquare();
		int[] arr = { 1, 3, 5, 2, 4 };
		int iValue = 3;
		boolean bdoesElementExist = LS.doesElementExist(arr, iValue);

		assertEquals(bdoesElementExist, true);
	}

	@Test
	public void doesElementExist_Test2() {
		LatinSquare LS = new LatinSquare();
		int[] arr = { 1, 3, 5, 2, 4 };
		int iValue = 99;
		boolean bdoesElementExist = LS.doesElementExist(arr, iValue);

		assertEquals(bdoesElementExist, false);
	}

	@Test
	public void hasAllValues_Test1() {
		LatinSquare LS = new LatinSquare();
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 3, 2, 1 };

		boolean bhasAllValues = LS.hasAllValues(arr1, arr2);

		assertEquals(bhasAllValues, true);

	}

	@Test
	public void hasAllValues_Test2() {
		LatinSquare LS = new LatinSquare();
		int[] arr1 = { 1, 2, 3 };
		int[] arr2 = { 3, 2, 99 };

		boolean bhasAllValues = LS.hasAllValues(arr1, arr2);

		assertEquals(bhasAllValues, false);

	}

	@Test
	public void getColumn_Test1() {
		
		int[][] MySquare = { { 1, 2, 3 }, { 3, 1, 2 }, { 2, 3, 1 } };

		LatinSquare LS = new LatinSquare(MySquare);
		int [] ExpectedCol = {2,1,3};
		int [] Col = LS.getColumn(1);
		
		assertTrue(Arrays.equals(ExpectedCol, Col));
		System.out.println(Arrays.toString(Col));
	}
	
	@Test
	public void getRow_Test1() {
		
		int[][] MySquare = { { 1, 2, 3 }, { 3, 1, 2 }, { 2, 3, 1 } };

		LatinSquare LS = new LatinSquare(MySquare);
		int [] ExpectedRow = {3,1,2};
		int [] Row = LS.getRow(1);
		
		assertTrue(Arrays.equals(ExpectedRow, Row));
		System.out.println(Arrays.toString(Row));
	}
	
	@Test
	public void isLatinSquare_Test1() {
		
		int[][] MySquare = { { 1, 2, 3 }, { 3, 1, 2 }, { 2, 3, 1 } };

		LatinSquare LS = new LatinSquare(MySquare);
		
		assertTrue(LS.isLatinSquare());
	}
	
	@Test
	public void isLatinSquare_Test2() {
		
		int[][] MySquare = { { 1, 2, 3 }, { 3, 1, 2 }, { 4, 5, 6 } };

		LatinSquare LS = new LatinSquare(MySquare);
		
		assertFalse(LS.isLatinSquare());
	}
	
	@Test
	public void ePuzzleViolationTest() {
		ePuzzleViolation[] e=ePuzzleViolation.values();
		ePuzzleViolation expected=e[1];
		ePuzzleViolation actual=ePuzzleViolation.valueOf("DupCol");
		assertEquals(expected, actual);
	}
}
