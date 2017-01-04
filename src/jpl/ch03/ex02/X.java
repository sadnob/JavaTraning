package jpl.ch03.ex02;

public abstract class X {
	protected int xMask = 0x00ff;
	protected int fullMask;

	{
		System.out.printf("X初期化ブロック\n");
		display();
	}

	public X() {
		System.out.printf("Xクラスコンストラクタ\n");
		fullMask = xMask;
		display();
	}
	 public abstract void display () ;

	public int mask(int orig) {
		return (orig & fullMask);
	}
}


