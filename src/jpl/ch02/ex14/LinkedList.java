package jpl.ch02.ex14;


public class LinkedList {

	private Object obj; // 変更されることが考えられるため、変更を許すメソッドを持つべきである。
	private LinkedList nextLinkedList;  // 変更されることが考えられるため、変更を許すメソッドを持つべきである。

	LinkedList(Object obj) {
		this.obj = obj;
	}
	LinkedList(Object obj, LinkedList linkedList) {
		this.obj = obj;
		this.nextLinkedList = linkedList;
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
