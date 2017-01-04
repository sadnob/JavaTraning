package jpl.ch03.ex02;

class Y extends X {

	protected int yMask = 0xff00;

	{
		System.out.printf("Yクラス初期化ブロック\n");
		display();
	}

	public Y() {
		System.out.printf("Yクラスコンストラクタ\n");
		fullMask |= yMask;
		display();
	}

	public void display() {
		System.out.printf("xMask：%x, fullMask：%x, yMask：%x\n",xMask,fullMask,yMask);
	}

	public static void main(String[] args) {
		Y y = new Y();

	}

}
