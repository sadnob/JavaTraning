package jpl.ch02.ex09;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void testGetMaxId() {
		Vehicle vehicleA = new Vehicle();
		Vehicle vehicleB = new Vehicle();
		Vehicle vehicleC = new Vehicle();

		assertThat(Vehicle.getMaxId(), is(3L));
	}

}
