package jpl.ch02.ex17;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void testTurnDouble() {
		Vehicle vehicleA = new Vehicle();
		vehicleA.setDirection(20.0);
		assertThat(vehicleA.getDirection(), is(20.0));
		vehicleA.turn(-60);
		assertThat(vehicleA.getDirection(), is(-40.0));
	}

	@Test
	public void testTurn() {
		Vehicle vehicleA = new Vehicle();
		vehicleA.turn("TURN_RIGHT");
		assertThat(vehicleA.getDirection(), is(90.0));
		Vehicle vehicleB = new Vehicle();
		vehicleB.turn("TURN_LEFT");
		assertThat(vehicleB.getDirection(), is(-90.0));
		vehicleA.turn("");
		assertThat(vehicleA.getDirection(), is(90.0));

	}

}
