package jpl.ch02.ex16;


public class LinkedList {

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
	 * リスト内の要素の数を得ます。
	 */
	public int getlistCount(LinkedList linkedList) {
        int count = 1;

		if (linkedList.getNextLinkedList() != null) {
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
	public Object getObj() {
		return obj;
	}
	public LinkedList getNextLinkedList() {
		return nextLinkedList;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public void setNextLinkedList(LinkedList nextLinkedList) {
		this.nextLinkedList = nextLinkedList;
	}

}
