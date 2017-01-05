package jpl.ch04.ex03;


public class LinkedListImple implements Cloneable, LinkedList {

	private Object obj;
	private LinkedListImple nextLink;


	LinkedListImple(Object obj) {
		this.obj = obj;
	}

	LinkedListImple(Object obj, LinkedListImple linkedList) {
		this.obj = obj;
		this.nextLink = linkedList;
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
	 * リストの要素をすべて表示すします。
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
	public LinkedListImple getNextLink() {
		return nextLink;
	}
	/** setter：nextLink */
	public void setNextLink(LinkedListImple nextLink) {
		this.nextLink = nextLink;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		LinkedListImple cloneList = (LinkedListImple) super.clone();
		cloneList.setObj(getObj());
		cloneList.setNextLink(getNextLink());
		return cloneList;
	}

	// mainメソッド
	public static void main(String[] args) {

		LinkedListImple linkedListA = new LinkedListImple("ObjectA");
		LinkedListImple linkedListB = new LinkedListImple("ObjectB");
		LinkedListImple linkedListC = new LinkedListImple("ObjectC");

		linkedListA.setNextLink(linkedListB);
		linkedListB.setNextLink(linkedListC);

		System.out.println(linkedListA);
		try {
			System.out.println(linkedListA.clone());
			System.out.println(linkedListB.clone());
			System.out.println(linkedListC.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
