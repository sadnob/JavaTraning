package jpl.ch03.ex01;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class PassengerVehicleTest {

	int seats = 6;
	int passenger = 4;
	String owner = "bob";
	double speed = 45.5;
	double direction = 70.5;

	@Test
	public void testPassengerVehicleInt() {
		PassengerVehicle pv = new PassengerVehicle(seats);
		assertThat(pv.getNumberObSeats(), is(seats));
	}

	@Test
	public void testPassengerVehicleStringInt() {
		PassengerVehicle pv = new PassengerVehicle(owner,seats);
		assertThat(pv.getOwner(), is(owner));
		assertThat(pv.getNumberObSeats(), is(seats));
	}

	@Test
	public void testPassengerVehicleStringIntInt() {
		PassengerVehicle pv = new PassengerVehicle(owner, seats, passenger);
		assertThat(pv.getOwner(), is(owner));
		assertThat(pv.getNumberObSeats(), is(seats));
		assertThat(pv.getPassenger(), is(passenger));
	}

	@Test
	public void testToString() {

		String str = "VehicleID:1  owner=" + owner +",  speed=" + speed + "km/h,  direction=" + direction
				+ ",  seats=" + seats + ",  passenger=" + passenger;
		PassengerVehicle pv = new PassengerVehicle(owner, seats, passenger);
		pv.setSpeed(speed);
		pv.setDirection(direction);
		assertThat(pv.toString(), is(str));;
	}
}
