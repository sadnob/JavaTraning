package jpl.ch03.ex10;


public class LinkedList implements Cloneable{

	private Object obj;
	private LinkedList nextLinkedList;

	LinkedList(Object obj) {
		this.obj = obj;
	}
	LinkedList(Object obj, LinkedList linkedList) {
		this.obj = obj;
		this.nextLinkedList = linkedList;
	}

	/**
	 * 引数で渡されたリスト内の要素の数を得ます。
	 */
	public static int getlistCount(LinkedList linkedList) {
        int count = 0;

		if (linkedList.getNextLinkedList() != null) {
			count += 1;
			count += getlistCount(linkedList.getNextLinkedList());
		}
		return count;
	}
	public String toString() {
		String desc = obj.toString();
		if (nextLinkedList != null) {
			desc += ", nextLinkedObj： " + nextLinkedList.toString();
		}
		return desc;
	}
	/**
	 * オブジェクを取得します。
	 */
	public Object getObj() {
		return obj;
	}
	/**
	 * オブジェクトを設定します。
	 */
	public void setObj(Object obj) {
		this.obj = obj;
	}
	/**
	 * 次の要素を取得します。
	 */
	public LinkedList getNextLinkedList() {
		return nextLinkedList;
	}
	/**
	 * 次の要素を設定します。
	 */
	public void setNextLinkedList(LinkedList nextLinkedList) {
		this.nextLinkedList = nextLinkedList;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
	

}
