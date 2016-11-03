package jpl.ch02.ex14;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void testGetSetObj() {
		Object objA = new Object();
		Object objB = new Object();
		LinkedList linkedList = new LinkedList(objA);
		assertThat(linkedList.getObj(),is(objA));
		linkedList.setObj(objB);
		assertThat(linkedList.getObj(),is(objB));
	}

	@Test
	public void testGetSetNextLinkedList() {
		Object obj = new Object();
		LinkedList linkedListA = new LinkedList(obj);
		LinkedList linkedListB = new LinkedList(obj);
		assertNull(linkedListA.getNextLinkedList());
		linkedListA.setNextLinkedList(linkedListB);
		assertThat(linkedListA.getNextLinkedList(), is(linkedListB));

	}


}
