package jpl.ch14.ex02;

import java.awt.PrintJob;

public class PrintServer implements Runnable {
	private final PrintQueue requests = new PrintQueue();
	private final Thread mainthread;

	public PrintServer() {
		mainthread = new Thread(this);
		mainthread.start();
	}

	public void print(PrintJob job) {
		requests.add(job);
	}

	public void run() {
		// コンストラクタで生成されたスレッドのみが実行可能
		if (Thread.currentThread() != mainthread) {
			return;
		}
		try {
			for (;;)
				realPrint(requests.remove());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void realPrint(PrintJob job) {
		// 印刷の実際の処理を行う
	}

}
