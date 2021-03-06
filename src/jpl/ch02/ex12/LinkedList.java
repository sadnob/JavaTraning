package jpl.ch02.ex12;


public class LinkedList {

	/*
	 * リストの要素の中から複数指定したObjectのうち１つでも当てはまるObjectを持つLinkedList要素の数を得る等
	 * のメソッドを実装する際には必要である。
	 */
	public Object obj;
	public LinkedList nextLinkedList;

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

}
