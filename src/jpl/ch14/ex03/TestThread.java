package jpl.ch14.ex03;

public class TestThread {

	public TestThread(SynchronousAddition sa, long num) {
		Runnable service = new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<10; i++)
					sa.display(num);
			}
		};
		new Thread(service).start();
	}

	public static void main(String[] args) {
		SynchronousAddition testsa = new SynchronousAddition();
		new TestThread(testsa, 1);
		new TestThread(testsa, 2);
		new TestThread(testsa, 5);

	}

}
