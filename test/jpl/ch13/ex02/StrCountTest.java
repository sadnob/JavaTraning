package jpl.ch13.ex02;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class StrCountTest {

	@Test
	public void testCount() {
		String testStr1 = "abcdefgabcdefga";
		String testStr2 = "bcdefg";
		String testStr3 = "aaaaa";
		String testStr4 = "";
		String testStr5 = "   ";

		assertThat(StrCount.count(testStr1, "a"), is(3));
		assertThat(StrCount.count(testStr2, "a"), is(-1));
		assertThat(StrCount.count(testStr3, "a"), is(5));
		assertThat(StrCount.count(testStr4, "a"), is(-1));
		assertThat(StrCount.count(testStr5, "a"), is(-1));
	}
	@Test(expected = NullPointerException.class)
	public void exceptionTest() {
		StrCount.count(null, "a");
	}

}
