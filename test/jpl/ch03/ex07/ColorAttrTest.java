package jpl.ch03.ex07;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColorAttrTest {

	ScreenColor scA = new ScreenColor();


	@Test
	public void testEqualsReturnsTrue() {

		String nameA = "name";
		String nameB = "name";
		Object valueA = "value";
		Object valueB = "value";

		// 正常系
		ColorAttr ca1 = new ColorAttr(nameA, valueA);
		ColorAttr ca2 = new ColorAttr(nameB, valueB);
		assertTrue(ca1.equals(ca2));
		assertTrue(ca1.hashCode() == ca2.hashCode());

		// naemが異なる
		String nameC = "nameC";
		ColorAttr ca3 = new ColorAttr(nameC, valueB);
		assertTrue(!ca1.equals(ca3));
		assertTrue(ca1.hashCode() != ca3.hashCode());


		// valueが異なる
		Object valueC = "valueC";
		ColorAttr ca4 = new ColorAttr(nameB, valueC);
		assertTrue(!ca1.equals(ca4));
		assertTrue(ca1.hashCode() != ca4.hashCode());

	}

}
