package jpl.ch01.ex15;

public interface AddRemove extends  Lookup {
	/**
	 * nameと関連付けされた値を追加します。
	 * 戻り値：成功(true)、失敗(false)
	 */
	public boolean add(String name, Object value);
	/**
	 * nameと関連付けされた値を削除します。
	 * 戻り値：成功(true)、失敗(false)
	 */
	public boolean remove(String name);

}
