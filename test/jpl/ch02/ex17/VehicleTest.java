package jpl.ch02.ex17;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void testTurnDouble() {
		Vehicle testVehicle = new Vehicle();
		testVehicle.setDirection(30);
		testVehicle.turn(20);
		assertThat(testVehicle.getDirection(), is(50.0));
		testVehicle.turn(-60);
		assertThat(testVehicle.getDirection(), is(-10.0));
	}

	@Test
	public void testTurn() {
		Vehicle testVehicle = new Vehicle();
		testVehicle.setDirection(30);
		testVehicle.turn("TURN_RIGHT");
		assertThat(testVehicle.getDirection(), is(120.0));
		testVehicle.turn("TURN_LEFT");
		assertThat(testVehicle.getDirection(), is(30.0));
		testVehicle.turn("turn_right");
		assertThat(testVehicle.getDirection(), is(30.0));
	}

}
