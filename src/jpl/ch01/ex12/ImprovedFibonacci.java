package jpl.ch01.ex12;

public class ImprovedFibonacci {

	static final int MAX_INDEX = 9;
	/**
	 * フィボナッチ数列の
	 * 最初の方の要素を配列に格納する
	 */
	public static void main(String[] args) {
        int lo = 1;
        int hi = 1;
        String[] fibonacci = new String[MAX_INDEX];
        String mark = " * ";
        fibonacci[0] = 1 + ": " + lo;
        fibonacci[1] = 2 + ": " + hi;

        for (int i = 2; i < MAX_INDEX; i++) {
        	hi = lo + hi;
        	lo = hi - lo;

        	if (hi % 2 == 0) {
        		fibonacci[i] = i+1 + ": " + hi + mark;
        	} else {
        		fibonacci[i] = i+1 + ": " +  hi;
        	}
        }
        for(int i=0; i<MAX_INDEX; i++) {
        	System.out.println(fibonacci[i]);
        }
	}
}
