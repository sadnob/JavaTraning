package jpl.ch03.ex02;

public class X {
	protected int xMask = 0x00ff;
	protected int fullMask;

	{
		System.out.printf("X初期化ブロック\n");
		System.out.printf("xMask：%x, fullMask：%x\n", xMask, fullMask);
	}

	public X() {
		System.out.printf("Xクラスコンストラクタ\n");
		fullMask = xMask;
		System.out.printf("xMask：%x, fullMask：%x\n", xMask, fullMask);

	}

	public int mask(int orig) {
		return (orig & fullMask);
	}
}


