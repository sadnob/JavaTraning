package jpl.ch02.ex15;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class VehicleTest {

	double before = 60.0;
	double after = 20.0;

	@Test
	public void testChangeSpeed() {
		Vehicle testVehicle = new Vehicle();
		testVehicle.setSpeed(before);
		testVehicle.changeSpeed(after);
		assertThat(testVehicle.getSpeed(), is(after));
	}

	@Test
	public void testStop() {
		Vehicle testVehicle = new Vehicle();
		testVehicle.setSpeed(before);
		testVehicle.stop();
		assertThat(testVehicle.getSpeed(), is(0.0));
	}

}
