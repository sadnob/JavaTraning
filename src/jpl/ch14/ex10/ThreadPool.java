/*
 * Copyright (C) 2012, 2013, 2016 RICOH Co., Ltd. All rights reserved.
 */
package jpl.ch14.ex10;

//	 * ※先輩のコードを参考にしました。すみません
import java.util.LinkedList;

/**
 * Simple Thread Pool class.
 *
 * This class can be used to dispatch an Runnable object to be exectued by a
 * thread.
 *
 * [Instruction] Implement one constructor and three methods. Don't forget to
 * write a Test program to test this class. Pay attention to @throws tags in the
 * javadoc. If needed, you can put "synchronized" keyword to methods. All
 * classes for implementation must be private inside this class. Don't use
 * java.util.concurrent package.
 */
public class ThreadPool {

	private Thread[] threads;
	private LinkedList<Runnable> queue;
	private int queueSize;
	private boolean threadFlag = false;

	public ThreadPool(int queueSize, int numberOfThreads) {
		if (queueSize < 1 || numberOfThreads < 1) {
			throw new IllegalArgumentException();
		}
		this.queue     = new LinkedList<Runnable>();
		this.threads   = new Thread[numberOfThreads];
		this.queueSize = queueSize;

	}

	/**
	 * Starts threads.
	 *
	 * @throws IllegalStateException
	 *             if threads has been already started.
	 */
	public void start() {
		if (threadFlag)
			throw new IllegalStateException();
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new WorkerThread());
			threadFlag = true;
			threads[i].start();
		}
	}

	/**
	 * Stop all threads and wait for their terminations.
	 *
	 * @throws IllegalStateException
	 *             if threads has not been started.
	 */

	public void stop() {
		if (!threadFlag)
			throw new IllegalStateException();
		threadFlag = false;
		for (int i = 0; i < threads.length; i++) {
			while (threads[i].isAlive()) {
				synchronized (this) {
					notifyAll();
				}
			}
		}
	}



	/**
	 * Executes the specified Runnable object, using a thread in the pool. run()
	 * method will be invoked in the thread. If the queue is full, then this
	 * method invocation will be blocked until the queue is not full.
	 *
	 * @param runnable
	 *            Runnable object whose run() method will be invoked.
	 *
	 * @throws NullPointerException
	 *             if runnable is null.
	 * @throws IllegalStateException
	 *             if this pool has not been started yet.
	 */

	public synchronized void dispatch(Runnable runnable) {
		if (!threadFlag) {
			throw new IllegalStateException();
		}
		if (runnable == null) {
			throw new NullPointerException();
		}
		queue.add(runnable);
		notifyAll();

	}

	private class WorkerThread implements Runnable {

		@Override
		public void run() {
			for (;;) {
				Runnable run;
				synchronized (ThreadPool.this) {
					while (queue.isEmpty()) {
						try {
							ThreadPool.this.wait();
							if (!threadFlag)
								return;
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					run = queue.remove();
					ThreadPool.this.notifyAll();
				}
				run.run();
			}
		}
	}
}