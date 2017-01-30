package jpl.ch12.ex01;


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

	/**
	 * 渡されたObjectを要素に持つLinkedListを探します。
	 * @param <E>
	 * @param o：探索する要素
	 * @return result：LinkedList型の
	 * @throws ObjectNotFoundException
	 */
	public <E> LinkedList find (E serchObj) throws ObjectNotFoundException {
		int count = 0;
		if (getObj().equals(serchObj)){
			return this;
		} else if(getNextLink()==null || count ==100){ // スタックオーバーフロー対策
			throw new ObjectNotFoundException(serchObj);
		} else {
			count++;
			return this.getNextLink().find(serchObj);// 再帰呼出し
		}
	}

	/** obj：ゲッター */
	public Object getObj() {
		return obj;
	}
	/** obj：セッター */
	public void setObj(Object obj) {
		this.obj = obj;
	}
	/** nextLink：ゲッター*/
	public LinkedList getNextLink() {
		return nextLink;
	}
	/** nextLink：セッター */
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
