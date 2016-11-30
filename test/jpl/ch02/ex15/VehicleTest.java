package jpl.ch02.ex15;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class VehicleTest {

	double testSpeedA = 60.0;
	double testSpeedB = -20.0;

	@Test
	public void testChangeSpeed() {
		Vehicle testVehicle = new Vehicle();
		testVehicle.changeSpeed(testSpeedA);
		assertThat(testVehicle.getSpeed(), is(testSpeedA));
		testVehicle.changeSpeed(testSpeedB);
		assertThat(testVehicle.getSpeed(), is(testSpeedB));
	}

	@Test
	public void testStop() {
		Vehicle testVehicle = new Vehicle();
		testVehicle.setSpeed(testSpeedA);
		testVehicle.stop();
		assertThat(testVehicle.getSpeed(), is(0.0));
	}

}
