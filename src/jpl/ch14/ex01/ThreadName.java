package jpl.ch14.ex01;

public class ThreadName {

	public static void main(String[] args) {
		Thread thread = Thread.currentThread(); // mainを実行しているスレッド

		System.out.println(thread.getName());

	}

}
