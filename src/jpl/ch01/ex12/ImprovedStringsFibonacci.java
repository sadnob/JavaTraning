package jpl.ch01.ex12;

public class ImprovedStringsFibonacci {

	static final int MAX_INDEX = 9;
	/**
	 * 偶数要素に'*'を付けて、フィボナッチ数列の
	 * 最初の方の要素を表示する
	 */
	public static void main(String[] args) {
        int lo = 1;
        int hi = 1;
        String fibonacci;

        System.out.println( "1: " + lo);
        for (int i = 2; i <= MAX_INDEX; i++) {
        	if (hi % 2 == 0)
        		fibonacci = i + ": " + hi + " *";
        	 else
        		fibonacci = i + ": " + hi;
        	System.out.println(fibonacci);
        	hi = lo + hi;
        	lo = hi - lo;
        }
	}

}
