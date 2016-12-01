package jpl.ch02.ex08;

public class LinkedList {

	public Object value;
	public LinkedList nextLink;

	// 受け取ったvalueをObject型変数に設定するコンストラクタ
	LinkedList(Object value) {
		this.value = value;
	}
	// Object型変数と次のLinkedList型要素を設定する。
	LinkedList(Object value, LinkedList linkedList) {
		this(value);
		this.nextLink = linkedList;
	}

	public static void main(String[] args) {

		Object valueA = "A";
		Object valueB = "B";
		Object valueC = "C";

		LinkedList linkedListC = new LinkedList(valueC);
		LinkedList linkedListB = new LinkedList(valueB, linkedListC);
		LinkedList linkedListA = new LinkedList(valueA, linkedListB);

		System.out.println( linkedListA.value +"  次の要素："+ linkedListA.nextLink.value);
		System.out.println( linkedListB.value +"  次の要素："+ linkedListB.nextLink.value);
		System.out.println( linkedListC.value +"  次の要素："+ linkedListC.nextLink);



	}

}
