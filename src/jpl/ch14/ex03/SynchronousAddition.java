package jpl.ch14.ex03;

public class SynchronousAddition {
	private long num = 0;

	/**
	 * 現在の値を表示して加算します。
	 */
	synchronized public void display(long addnum) {
		num += addnum;
		System.out.println(num);
	}

}
