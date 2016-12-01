package jpl.ch02.ex13;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void testGetIdAndNextId() {
		Vehicle vehicle = new Vehicle();
		assertThat(vehicle.getId(), is(1L));
		assertThat(vehicle.getNextId(), is(2L));
	}

	@Test
	public void testSetGetOwner() {
		Vehicle vehicle = new Vehicle();
		String owner = "Bob";
		vehicle.setOwner(owner);
		assertThat(vehicle.getOwner(), is(owner));
		vehicle.setOwner(null);
		assertNull(vehicle.getOwner());
	}

	@Test
	public void testSetGetSpeed() {
		Vehicle vehicle = new Vehicle();
		double speed = 65;
		vehicle.setSpeed(speed);
		assertThat(vehicle.getSpeed(), is(speed));
	}

	@Test
	public void testSetGetDirection() {
		Vehicle vehicle = new Vehicle();
		double direction = 90;
		vehicle.setDirection(direction);
		assertThat(vehicle.getDirection(), is(direction));
	}

}
