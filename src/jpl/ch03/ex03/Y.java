package jpl.ch03.ex03;

class Y extends X {

	protected static final int yMask = 0xff00;

	{
		System.out.printf("【Yクラス初期化ブロック】\n");
		System.out.printf("xMask：%x, fullMask：%x, yMask：%x\n",xMask,fullMask,yMask);
	}

	public Y() {
		System.out.printf("【Yクラスコンストラクタ】\n");
		fullMask |= yMask;
		System.out.printf("xMask：%x, fullMask：%x, yMask：%x\n",xMask,fullMask,yMask);

	}

	public static void main(String[] args) {
		Y y = new Y();

	}

}
