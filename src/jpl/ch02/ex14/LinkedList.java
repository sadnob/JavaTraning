package jpl.ch02.ex14;


public class LinkedList {

	private Object obj; // 変更されることが考えられるため、変更を許すメソッドを持つべきである。
	private LinkedList nextLink;  // 変更されることが考えられるため、変更を許すメソッドを持つべきである。

	LinkedList(Object obj) {
		this.obj = obj;
	}
	LinkedList(Object obj, LinkedList nextLink) {
		this.obj = obj;
		this.nextLink = nextLink;
	}

	/**
	 * リストの要素をすべて表示します。
	 * @return String desc
	 */
	public String toString() {
		String desc = obj.toString();
		if (nextLink != null) {
			desc += ", " + nextLink.toString();
		}
		return desc;
	}

	public Object getObj() {
		return obj;
	}
	public LinkedList getNextLink() {
		return nextLink;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public void setNextLinkedList(LinkedList nextLink) {
		this.nextLink = nextLink;
	}

}
