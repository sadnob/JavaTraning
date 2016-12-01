package jpl.ch02.ex11;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void testToString() {
		Object valueA = "A";
		Object valueB = "B";
		Object valueC = "C";

		LinkedList linkedListA = new LinkedList(valueA);
		LinkedList linkedListB = new LinkedList(valueB);
		LinkedList linkedListC = new LinkedList(valueC);
		linkedListA.nextLink = linkedListB;
		linkedListB.nextLink = linkedListC;

		String answer1 = valueA + ", " + valueB + ", " + valueC;
		assertThat(linkedListA.toString(), is(answer1));
	}

	@Test(expected = NullPointerException.class)
    public void testSetAge1() {
		Object valueA = "A";
		Object valueB = null;
		LinkedList linkedListA = new LinkedList(valueA);
		LinkedList linkedListB = new LinkedList(valueB);
		linkedListA.nextLink = linkedListB;
		System.out.println(linkedListA.toString());
    }

}
