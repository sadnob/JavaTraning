package jpl.ch14.ex06;

public class TimeDisplayMain implements Runnable {

	@Override
	public void run() {
		try {
			for (int i = 0; i < 360; i++) {
				notify();
				System.out.println(i);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			return;
		}
	}

	/**
	 * 確認用mainメソッド
	 *
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
