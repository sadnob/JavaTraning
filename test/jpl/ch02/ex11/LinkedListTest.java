package jpl.ch02.ex11;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import jpl.ch02.ex10.Vehicle;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void testToString() {
		Vehicle objA = new Vehicle("A");
		objA.direction = 10;
		objA.speed = 30;
		Vehicle objB = new Vehicle("B");
		objB.direction = 20;
		objB.speed = 60;
		Vehicle objC = new Vehicle("C");
		objC.direction = 30;
		objC.speed = 90;

		LinkedList linkedListA = new LinkedList(objA);
		LinkedList linkedListB = new LinkedList(objB);
		LinkedList linkedListC = new LinkedList(objC);
		linkedListA.nextLinkedList = linkedListB;
		linkedListB.nextLinkedList = linkedListC;

		String answer = objA + ", nextLinkedObj＝" + objB + ", nextLinkedObj＝" + objC;

		assertThat(linkedListA.toString(), is(answer));
	}

}
