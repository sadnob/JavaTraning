package jpl.ch02.ex16;



public class LinkedList {

	private Object obj;
	private LinkedList nextLink;

	LinkedList(Object obj) {
		this.obj = obj;
	}
	LinkedList(Object obj, LinkedList nextLink) {
		this.obj = obj;
		this.nextLink = nextLink;
	}

	/**
	 * リスト内の要素の数を返します。
	 * @return int count：リストの要素の数
	 */
	public  int getlistCount() {
		int count = 0;
		if (nextLink != null) {
			count += 1;
			count += nextLink.getlistCount();
		}
		return count;
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

	/** getter：obj */
	public Object getObj() {
		return obj;
	}
	/** setter：obj */
	public void setObj(Object obj) {
		this.obj = obj;
	}
	/** getter：nextLink */
	public LinkedList getNextLink() {
		return nextLink;
	}
	/** setter：nextLink */
	public void setNextLink(LinkedList nextLink) {
		this.nextLink = nextLink;
	}

	// mainメソッド
	public static void main(String[] args) {

		LinkedList linkedListA = new LinkedList("ObjectA");
		LinkedList linkedListB = new LinkedList("ObjectB");
		LinkedList linkedListC = new LinkedList("ObjectC");

		linkedListA.setNextLink(linkedListB);
		linkedListB.setNextLink(linkedListC);

		System.out.println(linkedListA);
	}

}
