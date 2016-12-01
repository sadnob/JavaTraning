package jpl.ch02.ex06;


public class LinkedList {

	public Object value;
	public LinkedList nextLink;

	public static void main(String[] args) {

		Object valueA = "A";
		Object valueB = "B";
		Object valueC = "C";

		LinkedList linkedListA = new LinkedList();
		linkedListA.value =valueA;
		LinkedList linkedListB = new LinkedList();
		linkedListB.value = valueB;
		LinkedList linkedListC = new LinkedList();
		linkedListC.value = valueC;

		linkedListA.nextLink = linkedListB;
		linkedListB.nextLink = linkedListC;

		System.out.println( linkedListA.value +"  次の要素："+ linkedListA.nextLink.value);
		System.out.println( linkedListB.value +"  次の要素："+ linkedListB.nextLink.value);
		System.out.println( linkedListC.value +"  次の要素："+ linkedListC.nextLink);


	}

}
