package jpl.ch03.ex01;

public class PassengerVehicle extends Vehicle {

	private final int NUMBER_OF_SEATS;
	private int passenger;

	public PassengerVehicle(int numberOfSeats) {
		super();
		this.NUMBER_OF_SEATS = numberOfSeats;
	}

	public PassengerVehicle(String owner, int numberOfSeats) {
		super(owner);
		this.NUMBER_OF_SEATS = numberOfSeats;
	}

	public PassengerVehicle(String owner, int numberOfSeats, int passenger) {
		this(owner, numberOfSeats);
		this.passenger = passenger;
	}

	/**
	 * 各フィールドをまとめた文字列を返す。
	 * @Override
	 */
	public String toString() {
		String desc = super.toString() + ",  ";
		desc += "seats=" + NUMBER_OF_SEATS + ",  ";
		desc += "passenger=" + passenger;
		return desc;
	}

	/** getter：NUMBER_OF_SEATS */
	public int getNumberObSeats() {
		return NUMBER_OF_SEATS;
	}

	/** getter：passenger */
	public int getPassenger() {
		return passenger;
	}

	/** setter：passenger */
	public void setPassenger(int passenger) {
		this.passenger = passenger;
	}

	/**
	 * mainクラス
	 *
	 * @param args
	 */
	public static void main(String[] args) {

		PassengerVehicle vehicleA = new PassengerVehicle(5);
		PassengerVehicle vehicleB = new PassengerVehicle("bob", 6);
		PassengerVehicle vehicleC = new PassengerVehicle("bob", 8, 4);

		System.out.println(vehicleA);
		System.out.println(vehicleB);
		vehicleB.setPassenger(2);
		System.out.println(vehicleB);
		System.out.println(vehicleC);

	}

}
