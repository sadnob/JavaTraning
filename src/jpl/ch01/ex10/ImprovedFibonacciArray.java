package jpl.ch01.ex10;

public class ImprovedFibonacciArray {

	static final int MAX_INDEX = 9;

	/**
	 * 偶数要素に'*'を付けて、フィボナッチ数列の
	 * 最初の方の要素を表示する
	 */
	public static void main(String[] args) {
        int lo = 1;
        int hi = 1;
        //String mark;
        SequenceElement[] fibonacci = new SequenceElement[MAX_INDEX];
        fibonacci[0] = new SequenceElement(lo);
        fibonacci[1] = new SequenceElement(hi);

        for (int i = 2; i < MAX_INDEX; i++) {
        	fibonacci[i] = new SequenceElement(hi+lo);
        /*	if (fibonacci[i-1].even_number_check)
        		mark = " *";
        	 else
        		mark = "";*/
        	hi = lo + hi;
        	lo = hi - lo;
        }
	}
}
