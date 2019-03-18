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
		super();
		if (Math.sqrt(iSize) != (int) Math.sqrt(iSize))
			throw new Exception();
		this.iSize = iSize;
		this.iSqrtSize = (int) Math.sqrt(iSize);
	}
	
	
	public Sudoku(int[][] latinsquare) throws Exception {
		
		super(latinsquare);
		this.iSize = latinsquare.length;
		if (Math.sqrt(latinsquare.length) != (int) Math.sqrt(latinsquare.length))
				throw new Exception();
		else
			this.iSqrtSize = (int) Math.sqrt(latinsquare.length);
	}
	
	protected int[][] getPuzzle()
	{
		return super.getLatinSquare();
	}
	
	protected int[] getRegion(int iRegionNbr) throws Exception{
		int idx = 0;
		int[] myRegion = new int[this.iSize];
		int iSize = this.iSize;
		int iSqrtSize = (int)Math.sqrt(iSize);
		
		if ((iRegionNbr+1) > iSize)
			throw new Exception("Bad Region Call");
		if (iRegionNbr<0)
			throw new Exception("Bad Region Call");
		
		int[][] sudoku = this.getPuzzle();
		
		for(int iRow = (iRegionNbr/iSqrtSize)*iSqrtSize; iRow<((iRegionNbr/iSqrtSize)*iSqrtSize)+iSqrtSize;iRow++) {
			for (int iCol = (iRegionNbr%iSqrtSize)*iSqrtSize; iCol<((iRegionNbr%iSqrtSize)*iSqrtSize+iSqrtSize); iCol++) {
				 {
					myRegion[idx] = sudoku[iRow][iCol];
					idx++;
				}
			}
		}
			
			
		return myRegion;
	}
	
	public int[] getRegion(int iCol, int iRow) throws Exception {
		int region = (iCol/this.iSqrtSize)+(iRow/this.iSqrtSize)*this.iSqrtSize;
		if (region < 0 || region >= this.iSqrtSize)
			throw new Exception("Row or Column out of bounds");
		else
			return getRegion(region);
	}
	
	@Override
	protected boolean hasDuplicates() throws Exception {
		if (super.hasDuplicates())
			return true;
		for (int iReg = 0; iReg < this.iSize; iReg++) {
			if (hasDuplicates(getRegion(iReg)))
					return true;
		}
		return false;
		
	}
	
	public boolean isPartialSudoku() throws Exception {
		boolean isPartial = true;
		if (!ContainsZero())
			isPartial = false;
		else if (!this.isLatinSquare())
			isPartial = false;
		else if (hasDuplicates())
			isPartial = false;
		for (int reg = 1; reg < iSize; reg++) {
			if (!hasAllValues(getRegion(0),getRegion(reg)))
				isPartial = false;
		}
		return isPartial;
	}
	
	public boolean isSudoku() throws Exception {
		boolean isSudoku = true;
		if (ContainsZero())
			isSudoku = false;
		if (!this.isLatinSquare())
			isSudoku = false;
		else if (hasDuplicates())
			isSudoku = false;
		for (int reg = 1; reg < iSize; reg++) {
			if (!hasAllValues(getRegion(0),getRegion(reg)))
				isSudoku = false;
		}
		return isSudoku;
	}
	
	public boolean isValidValue(int iCol, int iRow, int iValue) {
		boolean isValid = true;
		// Create new array of column with one extra slot
		int[] colArr = new int[getColumn(iCol).length+1];
		for (int i : colArr)
			colArr[i] = getColumn(iCol)[i];
		// Placing in test value
		colArr[colArr.length-1] = iValue;
		// Check to see if duplicate value
		if (hasDuplicates(colArr))
			isValid = false;
		// Create new array of given row with one extra slot
		int[] rowArr = new int[getRow(iRow).length+1];
		for (int j : rowArr)
			rowArr[j] = getRow(iRow)[j];
		// Placing in test value
		rowArr[rowArr.length-1] = iValue;
		if (hasDuplicates(rowArr))
			isValid = false;
		// return if the test value is valid
		return isValid;
			
	}
}
