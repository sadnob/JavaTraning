package jpl.ch01.ex09;

public class FibonacciArray {

	static final int MAX = 50;
	static final String TITLE = "◆フィボナッチ数列◆";

	public static void main(String[] args) {
		int[] fibonacci = new int[MAX];

        fibonacci[0] = 1;
        fibonacci[1] = 1;
        for (int i= 2; fibonacci[i-1] < MAX; i++) {
        	fibonacci[i] = fibonacci[i-2] + fibonacci[i-1];
       }
        System.out.println(TITLE);
        for (int i=0; fibonacci[i] < MAX; i++) {
        	System.out.println(fibonacci[i]);
        }
	}
}
