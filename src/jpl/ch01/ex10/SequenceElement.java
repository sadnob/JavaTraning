package jpl.ch01.ex10;

public class SequenceElement {
	public int element;
	public boolean even_number_check;

	// フィールドに値を設定するコンストラクタ
	SequenceElement (int element) {
		this.element = element;
		if (element%2 == 0)
			this.even_number_check = true;
		else
			this.even_number_check = false;
	}

}
