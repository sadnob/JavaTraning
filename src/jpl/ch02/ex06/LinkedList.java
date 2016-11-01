package jpl.ch02.ex06;

public class LinkedList {

	public Object obj;
	public LinkedList nextLinkedList;

	public static void main(String[] args) {

		Vehicle firstVehicle = new Vehicle();
		Vehicle secondVehicle = new Vehicle();
		Vehicle thirdVehicle = new Vehicle();


		LinkedList linkedListA = new LinkedList();
		linkedListA.obj =firstVehicle;
		LinkedList linkedListB = new LinkedList();
		linkedListB.obj = secondVehicle;
		LinkedList linkedListC = new LinkedList();
		linkedListC.obj = thirdVehicle;

		linkedListA.nextLinkedList = linkedListB;
		linkedListB.nextLinkedList = linkedListC;




	}

}
