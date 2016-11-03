package jpl.ch02.ex10;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void testToString() {
		Vehicle vehicle = new Vehicle("Bob");
		vehicle.direction = 30;
		vehicle.speed = 65;

		assertThat(vehicle.toString(), is("[ID : 1 Owner : Bob] [Speed = 65.0 Direction = 30.0]"));
	}

}
