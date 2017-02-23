package jpl.ch14.ex04;

public class SynchronousAddition {
	private static long num = 0;

	/**
	 * 現在の値を表示して加算します。
	 * @param  addnum : 加算するlong値
	 */
	synchronized public static void display(long addnum) {
		num += addnum;
		System.out.println(num);
	}

}
