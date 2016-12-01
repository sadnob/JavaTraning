package jpl.ch02.ex11;

public class LinkedList {
	public Object value;
	public LinkedList nextLink;

	LinkedList(Object value) {
		this.value = value;
	}

	LinkedList(Object value, LinkedList linkedList) {
		this.value = value;
		this.nextLink = linkedList;
	}

	/**
	 * リストの要素をすべて表示します。
	 *
	 * @return String desc
	 */
	public String toString() {
		String desc = value.toString();
		if (nextLink != null) {
			desc += ", " + nextLink.toString();
		}
		return desc;
	}

}
