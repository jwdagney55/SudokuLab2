package pkgGame;

import java.util.Arrays;

import pkgHelper.LatinSquare;

public class Sudoku extends LatinSquare {
	
	private int iSize;
	private int iSqrtSize;

	public Sudoku() {
		super();
	}
	public Sudoku(int iSize) throws Exception {
		if (Math.sqrt(iSize) % 1 !=0)
			throw new Exception();
		this.iSize = iSize;
		this.iSqrtSize = (int) Math.sqrt(iSize);
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
