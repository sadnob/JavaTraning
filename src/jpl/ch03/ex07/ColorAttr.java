package jpl.ch03.ex07;

public class ColorAttr extends Attr {
	private ScreenColor myColor;  //変換された色

	public ColorAttr(String name, Object value) {
		super(name, value);
		decodeColor();
	}

	public ColorAttr(String name) {
		this(name, "transparent");
	}

	public ColorAttr(String name, ScreenColor value) {
		super(name, value.toString());
		myColor = value;
	}

	public Object setValue(Object newValue) {
		// スーパークラスのsetValueを最初に行う
		Object retval = super.setValue(newValue);
		decodeColor();
		return retval;
	}

	/** 値を記述ではなくScreenColorに設定する。**/
	public ScreenColor setValue(ScreenColor newValue) {
		// スーパークラスのsetValueを最初に行う
		super.setValue(newValue.toString());
		ScreenColor oldValue = myColor;
		myColor = newValue;
		return oldValue;
	}

	/** 変換されたScreenColorオブジェクトを返す */
	public ScreenColor  getColor() {
		return myColor;
	}

	/** getValue() で得られる記述からScreenColorを記述する */
	protected void decodeColor() {
		if (getValue() == null)
			myColor = null;
		else
			myColor = new ScreenColor(getValue());
	}

	@Override
	/** 同じScreenColorオブジェクトを持っている場合　true*/
	public boolean equals(Object obj) {
		ColorAttr otherObj = (ColorAttr)obj;
		return this.myColor.equals(otherObj.getColor());
	}
	@Override
	public int hashCode() {

		return super.hashCode();
	}

}
