package jpl.ch03.ex10;


public class LinkedList implements Cloneable {

	private Object obj;
	private LinkedList nextLink;


	LinkedList(Object obj) {
		this.obj = obj;
	}

	LinkedList(Object obj, LinkedList linkedList) {
		this.obj = obj;
		this.nextLink = linkedList;
	}


	public  int getlistCount() {
		int count = 0;

		if (nextLink != null) {
			count += 1;
			count += nextLink.getlistCount();
		}
		return count;
	}

	public String toString() {
		String desc = obj.toString();
		if (nextLink != null) {
			desc += ", " + nextLink.toString();
		}
		return desc;
	}

	// getter：obj
	public Object getObj() {
		return obj;
	}
	// setter：obj
	public void setObj(Object obj) {
		this.obj = obj;
	}
	// getter：nextLink
	public LinkedList getNextLink() {
		return nextLink;
	}
	// setter：nextLink
	public void setNextLink(LinkedList nextLink) {
		this.nextLink = nextLink;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		LinkedList cloneList = (LinkedList) super.clone();
		cloneList.setObj(getObj());
		cloneList.setNextLink(getNextLink());
		return cloneList;
	}

	// mainメソッド
	public static void main(String[] args) {

		LinkedList linkedListA = new LinkedList("ObjectA");
		LinkedList linkedListB = new LinkedList("ObjectB");
		LinkedList linkedListC = new LinkedList("ObjectC");

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
