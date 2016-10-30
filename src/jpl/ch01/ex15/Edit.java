package jpl.ch01.ex15;

public interface Edit extends  Lookup {
	/**
	 * nameと関連付けされた値を追加します。
	 * nameが既に存在する場合、又は登録数が最大の場合は追加されません。
	 */
	public void add(String name, Object value);
	/**
	 * nameと関連付けされた値を削除します。
	 */
	public void remove(String name);

}
