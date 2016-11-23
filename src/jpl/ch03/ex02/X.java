package jpl.ch03.ex02;

public class X {
	protected int xMask = 0x00ff;
	protected int fullMask;

	public X() {
		System.out.printf("[Xコンストラクタ処理開始]");
		System.out.println("xMask, fullMask");
		fullMask = xMask;
		System.out.printf("[Xコンストラクタ処理終了]：xMask = %d", xMask);
	}

	public int mask(int orig) {
		return (orig & fullMask);
	}
}

class Y extends X {
	protected int yMask = 0xff00;

	public Y() {
		fullMask |= yMask;
	}
}

class MainClass {
	public static void main(String[] args) {
		System.out.println("xMask, fullMask, yMask = %d, %d, %d", xMask, fullMask, yMask);

	}
}
