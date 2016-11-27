package jpl.ch03.ex02;

public class X {
	protected int xMask = 0x00ff;
	protected int fullMask;

	public X() {
		System.out.printf("Xコンストラクタ処理前\n");
		System.out.printf("xMask：%x, fullMask：%x\n",xMask,fullMask);
		fullMask = xMask;
		System.out.printf("Xコンストラクタ処理後\n");
		System.out.printf("xMask：%x, fullMask：%x\n",xMask,fullMask);

	}

	public int mask(int orig) {
		return (orig & fullMask);
	}
}

class Y extends X {

	protected int yMask = 0xff00;

	public Y() {
		System.out.printf("Yコンストラクタ処理前\n");
		System.out.printf("xMask：%x, fullMask：%x, yMask：%x\n",xMask,fullMask,yMask);
		fullMask |= yMask;
		System.out.printf("Yコンストラクタ処理後\n");
		System.out.printf("xMask：%x, fullMask：%x, yMask：%x\n",xMask,fullMask,yMask);

	}

}
