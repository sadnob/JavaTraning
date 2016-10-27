package jpl.ch01.ex03;

public class FibonacciAddTitle {

	public static void main(String[] args) {
            int lo = 1;
            int hi = 1;
            System.out.println("◆フィボナッチ数列◆");
            System.out.println(lo);
            while (hi < 50) {
            	System.out.println(hi);
            	hi = lo + hi;        // 新しいhi
            	lo = hi - lo;         /* 新しいloは、（合計 - 古いlo）
            	                             すなわち、古いhi */
            }
     }
}
