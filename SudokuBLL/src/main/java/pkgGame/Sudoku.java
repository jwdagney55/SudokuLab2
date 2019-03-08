package pkgGame;

import java.util.Arrays;

import pkgHelper.LatinSquare;

public class Sudoku extends LatinSquare {

	public Sudoku() {
		super();
	}
	
	public Sudoku(int[][] latinsquare) {
		super(latinsquare);
	}
	
	protected int[][] getPuzzle()
	{
		return super.getLatinSquare();
	}
	
	protected int[] getRegion(int iRegionNbr)
	{
		return null;
	}
	
	
}
