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

	/**
	 *  引数がColorAttrインスタンスでない場合 ⇒ false
	 *  引数のnameがカレントオブジェクトのnameと異なる場合 ⇒ false
	 *  引数のvalue.toString()がカレントオブジェクトのvalue.toString()と異なる場合 ⇒ false
	 *  @Override
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof ColorAttr)) {
			return false;
		}
		ColorAttr colorAttr = (ColorAttr) obj;
		if (!this.getName().equals(colorAttr.getName())) {
			return false;
		}
		if (!this.getValue().toString().equals(colorAttr.getValue().toString())) {
			return false;
		}
		return true;
	}
	@Override
	public int hashCode() {
		int result = 17;
		result *= 31;
		result += getName().hashCode();
		result += getValue().toString().hashCode();

		return result;
	}

}
