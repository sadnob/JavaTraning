package jpl.ch14.ex02;

import java.awt.PrintJob;


class PrintQueue {
	private SinglelinkQueue<PrintJob> queue = new SinglelinkQueue<PrintJob>();

	public synchronized void add(PrintJob j) {
		queue.add(j);
		notifyAll(); // 持っているスレッドに知らせる：プリントジョブが追加された
	}

	public synchronized PrintJob remove() throws InterruptedException {
		while (queue.size() == 0)
			wait();
		return queue.remove();
	}

}
