package jpl.ch02.ex08;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void testLinkedListObject() {
		LinkedList linkedList = new LinkedList(new String());
		assertThat(linkedList.obj, is(new String()));
		LinkedList nullLinkedList = new LinkedList(null);
		assertNull(nullLinkedList.obj);
	}

	@Test
	public void testLinkedListObjectLinkedList() {
		LinkedList nextLinkedList = new LinkedList(new Object());
		LinkedList linkedList = new LinkedList(new String(), nextLinkedList);
		assertThat(linkedList.obj, is(new String()));
		assertThat(linkedList.nextLinkedList, is(nextLinkedList));
	}

}
