package pkgEnum;

import java.util.Arrays;
import java.util.ArrayList;
public enum ePuzzleViolation{
	ContainsZero,DupCol,DupRegion,DupRow,InvalidValue,MissingZero;
	
	private ePuzzleViolation() {
	}
	
	@Override
	public static ePuzzleViolation valueOf(String name) throws IllegalArgumentException, NullPointerException {
		for (ePuzzleViolation c : ePuzzleViolation.values()) {
			
			if (name == c.toString())
				return c;
			else if (name == null)
				throw new NullPointerException();
			else
				throw new IllegalArgumentException();
			
		}
		return ;
	}
	@Override
	public static ePuzzleViolation[] values() {
		ArrayList<ePuzzleViolation> e = new ArrayList<ePuzzleViolation>();
		for (ePuzzleViolation c : ePuzzleViolation.values()) {
			e.add(c);
		}
		return e;
	}
}
