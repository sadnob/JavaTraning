package jpl.ch01.ex09;

public class FibonacciArray {

	static final int MAX = 50;
	static final String TITLE = "◆フィボナッチ数列◆";

	public static void main(String[] args) {
		int[] fibonacci = new int[MAX];
        int lo = 1;
        int hi = 1;
        fibonacci[0] = lo;
        fibonacci[1] = hi;
        for (int i= 2; hi < MAX; i++) {
        	hi = fibonacci[i-1] + fibonacci[i-1];  // 新しいhiを配列に格納
        	fibonacci[i] = hi;
       }
        System.out.println(TITLE);
        for (int i=0; fibonacci[i] < MAX; i++) {
        	System.out.println(fibonacci[i]);
        }
	}
}
