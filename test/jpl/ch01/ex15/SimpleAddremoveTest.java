package jpl.ch01.ex15;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleAddremoveTest {

	Object testObjA = new Object();
	Object testObjB = new Object();
	String NameA = "A";
	String NameB = "B";
	String NameZ = "Z";


	@Test
	public void testAdd() {
		SimpleAddRemove addtestSimpleAddRemove = new SimpleAddRemove();
		assertTrue(addtestSimpleAddRemove.add(NameA, testObjA));
		assertFalse(addtestSimpleAddRemove.add(NameZ, testObjA));
		assertTrue(addtestSimpleAddRemove.add(NameA, testObjB));
	}

	@Test
	public void testFind() {
		SimpleAddRemove findTestSimpleAddRemove = new SimpleAddRemove();
		findTestSimpleAddRemove.add(NameA, testObjA);
		findTestSimpleAddRemove.add(NameA, testObjB);
		assertThat(findTestSimpleAddRemove.find(NameA), is(not(equals(testObjA))));
		assertEquals(testObjB, findTestSimpleAddRemove.find(NameA));
		assertNull(findTestSimpleAddRemove.find(NameB));
		assertNull(findTestSimpleAddRemove.find(NameZ));

	}

	@Test
	public void testRemove() {
		SimpleAddRemove removeTestSimpleAddRemove = new SimpleAddRemove();
		removeTestSimpleAddRemove.add(NameA, testObjA);
		assertTrue(removeTestSimpleAddRemove.remove(NameA));
		// assertThat(removeTestSimpleAddRemove.remove("Z"), is(false));
		assertTrue(removeTestSimpleAddRemove.remove(NameA));
	}

}
