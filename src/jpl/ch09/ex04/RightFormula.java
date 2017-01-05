package jpl.ch09.ex04;

public class RightFormula {

/*
 	3 << 2L - 1　：int, 6
	(3L << 2) - 1 ：long, 11
	10 < 12 == 6 > 17 ：boolean, false
	10 << 12 == 6 >> 17：boolean, false
	13.5e-1 % Float.POSITIVE_INFINITY ：float, 13.5e-1
	FLOAT.POSITIVE_INFINITY + Double.NEGATIVE_INFINITY ：Double, NaN
	Double.POSITIVE_INFINITY - Float.NEGATIVE_INFINITY ：Double, POSITIVE_INFINITY
	0.0 / -0.0 == -0.0 / 0.0：boolean, false
	Integer.MAX_VALUE + Integer.MIN_VALUE ：int, -1
	Long.MAX_VALUE + 5 ：long, -9223372036854775804
	(short) 5 * (short) 10：int, 50
	(i < 15 ? 1.72e3f :0)：i<15ならばfloat, 1.72e3f　i<15でないならfloat,0.0
	i++ + i++ + --i // iは最初に3：int, 11
*/
}
