package jpl.ch14.ex04;

public class TestThread {

	public TestThread(long num) {
		Runnable service = new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<10; i++)
					SynchronousAddition.display(num);
			}
		};
		new Thread(service).start();
	}

	/**
	 * 確認用mainメソッド
	 * @param args
	 */
	public static void main(String[] args) {
		// SynchronousAddition testsa = new SynchronousAddition();
		new TestThread(1);
		new TestThread(2);
		new TestThread(5);

	}

}
