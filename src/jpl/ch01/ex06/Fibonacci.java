package jpl.ch01.ex06;

public class Fibonacci {

	static final int MAX = 50;
	static final String TITLE = "◆フィボナッチ数列◆";

	public static void main(String[] args) {
        int lo = 1;
        int hi = 1;
        System.out.println(TITLE);
        System.out.println(lo);
        while (hi < MAX) {
        	System.out.println(hi);
        	hi = lo + hi;        // 新しいhi
        	lo = hi - lo;         /* 新しいloは、（合計 - 古いlo）
        	                             すなわち、古いhi */
        }
	}

}
