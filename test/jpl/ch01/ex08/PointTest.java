package jpl.ch01.ex08;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

	double testX = 1.5;
	double testY = 3.0;
	Point movePoint = new Point();

	@Test
	public void testMoveAndClear() {
		Point testPoint = new Point();
		testPoint.move(testX, testY);
		assertThat(testPoint.x, is(testX));
		assertThat(testPoint.y, is(testY));

		testPoint.clear();
		assertThat(testPoint.x, is(0.0));
		assertThat(testPoint.y, is(0.0));

	}

	@Test
	public void testMoveEqual() {
		Point testPoint = new Point();
		movePoint.x = 2.0;
		movePoint.y = 6.0;
		testPoint.moveEqual(movePoint);
		assertThat(movePoint.x, is(testPoint.x));
		assertThat(movePoint.y, is(testPoint.y));
	}

	@Test
	public void testDistance() {
		Point testPointA = new Point();
		Point testPointB = new Point();
		testPointA.x = testX;
		testPointA.y = testX;
		testPointB.x = 1.5;
		testPointB.y = 4.5;

		assertThat(testPointA.distance(testPointB), is(3.0));

	}

}
