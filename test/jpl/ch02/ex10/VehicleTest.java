package jpl.ch02.ex10;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void testToString() {
		String owner = "A";
		double speed = 30.0;
		double direction = 65.0;

		Vehicle vehicle = new Vehicle(owner);
		vehicle.speed = speed;
		vehicle.direction = direction;

		String result = "VehicleID:1  owner=" +owner+ ",  speed=" + speed + "km/h,  direction=" + direction;
		assertThat(vehicle.toString(), is(result));
	}

}
