package gui.ex11;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

public class DigitalClock extends Frame implements Runnable {
	static int h; // 時を入れる変数を宣言
	static int m; // 分を入れる変数を宣言
	static int s; // 秒を入れる変数を宣言

	boolean a = true;

	// インスタンス化
	static DigitalClock f = new DigitalClock();
	static Thread th = new Thread(f);

	public static void main(String args[]) {

		// フレーム作成
		f.setSize(200, 100);
		f.setVisible(true);
		f.addWindowListener(new Ada());

		th.start(); // スレッドスタート
	}

	public void run() {
		while (a == true) {
			h = Calendar.getInstance().get(Calendar.HOUR_OF_DAY); // 時を代入
			m = Calendar.getInstance().get(Calendar.MINUTE); // 分を代入
			s = Calendar.getInstance().get(Calendar.SECOND); // 秒を代入
			repaint();

			try {
				Thread.sleep(1000); // スリープ１秒
			} catch (InterruptedException e) {
			}
		}
	}

	public void paint(Graphics g) {
		g.drawString(h + ":" + m + ":" + s, 50, 59);
	}

}

class Ada extends WindowAdapter {
	public void windowClosing(WindowEvent e) { // ×を押されたときの処理
		System.exit(0);
	}
}
