package jpl.ch03.ex03;

public class X {
	protected int xMask = 0x00ff;
	protected int fullMask;

	{
		System.out.printf("【X初期化ブロック】\n");
		System.out.printf("xMask：%x, fullMask：%x\n", xMask, fullMask);
	}

//**************************************************************
// Q3-3
// A．サブクラスYのフィールドをstaticとすることで、
//      サブクラスYのフィールドを初期化の処理の中で使用することができる。
//**************************************************************
	public X() {
		System.out.printf("【Xクラスコンストラクタ】\n");
		fullMask = xMask;
		System.out.printf("xMask：%x, fullMask：%x\n", xMask, fullMask);
		System.out.printf("【xMaskをyMaskに変更】\n");
		fullMask = Y.yMask;
		System.out.printf("xMask：%x, fullMask：%x\n", xMask, fullMask);

	}

	public int mask(int orig) {
		return (orig & fullMask);
	}
}


