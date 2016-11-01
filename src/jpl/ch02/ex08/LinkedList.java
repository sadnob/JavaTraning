package jpl.ch02.ex08;

public class LinkedList {

	public Object obj;
	public LinkedList nextLinkedList;

	LinkedList(Object obj) {
		this.obj = obj;
	}
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
