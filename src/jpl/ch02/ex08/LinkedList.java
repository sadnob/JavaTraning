package jpl.ch02.ex08;

public class LinkedList {

	public Object obj;
	public LinkedList nextLinkedList;

	// 受け取ったオブジェクトをObject型変数に設定するコンストラクタ
	LinkedList(Object obj) {
		this.obj = obj;
	}
	// Object型変数と次のLinkedList型要素を設定する。
	LinkedList(Object obj, LinkedList linkedList) {
		this.obj = obj;
		this.nextLinkedList = linkedList;
	}

	public static void main(String[] args) {

		LinkedList linkedListA = new LinkedList(new Vehicle());
		LinkedList linkedListB = new LinkedList(new Vehicle());
		LinkedList linkedListC = new LinkedList(new Vehicle());

		linkedListA.nextLinkedList = linkedListB;
		linkedListB.nextLinkedList = linkedListC;




	}

}
