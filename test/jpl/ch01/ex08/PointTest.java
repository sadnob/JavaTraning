package jpl.ch01.ex08;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class PointTest {

    Point point1 = new Point();
    Point point2 = new Point();
    Point point3 = new Point();

/*------------------------ClearTest-----------------------------*/
        @Test
        public void testClear() {

        }

/*------------------------MoveTest-----------------------------*/
        @Test
        public void testMove1() {

        }

        @Test
        public void testMove2() {

        }

        @Test
        public void testMove3() {

        }

/*------------------------MoveEqualTest-----------------------------*/
        @Test
        public void testMoveEqual1() {

            assertThat(point1.moveEqual(point2), is(""));
        }

        @Test
        public void testMoveEqual2() {

            assertThat(point1.moveEqual(point2), is(""));
        }

        @Test
        public void testMoveEqual3() {

            assertThat(point1.moveEqual(point2), is(""));
        }

/*------------------------distanceTest-----------------------------*/
        @Test
        public void Testdistance1() {

            assertThat(point1.distance(point2), is(""));
        }

        @Test
        public void Testdistance2() {

            assertThat(point1.distance(point2), is(""));
        }

        public void Testdistance3() {

            assertThat(point1.distance(point2), is(""));
        }




}
