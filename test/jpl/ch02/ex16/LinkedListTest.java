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
		lListA.setNextLink(lListB);
		lListB.setNextLink(lListC);

		assertThat(lListA.getlistCount(),is(2));
		assertThat(lListB.getlistCount(),is(1));
		assertThat(lListC.getlistCount(),is(0));
	}

}
