package jpl.ch02.ex16;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {
	Object objA = new Object();
	Object objB = new Object();
	Object objC = new Object();

	@Test
	public void testGetlistCount() {
		LinkedList lListA = new LinkedList(objA);
		LinkedList lListB = new LinkedList(objB);
		LinkedList lListC = new LinkedList(objC);
		lListA.setNextLinkedList(lListB);
		lListB.setNextLinkedList(lListC);

		assertThat(LinkedList.getlistCount(lListC),is(0));
		assertThat(LinkedList.getlistCount(lListB),is(1));
		assertThat(LinkedList.getlistCount(lListA),is(2));
	}

}
