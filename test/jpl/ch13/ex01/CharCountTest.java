package jpl.ch13.ex01;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class CharCountTest {

	@Test
	public void testCount() {
		String testStr1 = "abcdefgabcdefga";
		String testStr2 = "bcdefg";
		String testStr3 = "aaaaa";
		String testStr4 = "";
		String testStr5 = "   ";

		assertThat(CharCount.count(testStr1, 'a'), is(3));
		assertThat(CharCount.count(testStr2, 'a'), is(-1));
		assertThat(CharCount.count(testStr3, 'a'), is(5));
		assertThat(CharCount.count(testStr4, 'a'), is(-1));
		assertThat(CharCount.count(testStr5, 'a'), is(-1));

	}
	@Test(expected = NullPointerException.class)
	public void exceptionTest() {
		CharCount.count(null, 'a');
	}

}
