package jpl.ch06.ex02;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void testTurnTurn() {
		Vehicle vehicleA = new Vehicle();
		vehicleA.turn(Turn.TURN_LEFT);
		assertThat(vehicleA.getDirection(), is(-90.0));
		Vehicle vehicleB = new Vehicle();
		vehicleB.turn(Turn.TURN_RIGHT);
		assertThat(vehicleB.getDirection(), is(90.0));
		Vehicle vehicleC = new Vehicle();
		vehicleC.turn(null);
		assertThat(vehicleC.getDirection(), is(0.0));
	}

}
