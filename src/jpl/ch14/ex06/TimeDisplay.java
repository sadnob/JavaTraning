package jpl.ch14.ex06;

public class TimeDisplay implements Runnable {
	private String word; // 表示する文字列
	private final int interval = 15; // 表示する時間間隔

	public TimeDisplay(String word) {
		this.word = word;
	}

	@Override
	public void run() {
		int count = 0;
			try {
				for (;;) {
					wait(); // 15秒待つ
					System.out.println(word);
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			}
		}

}
