package jpl.ch03.ex08;

public class PassengerVehicle extends Vehicle implements Cloneable {

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

	@Override
	public String toString() {
		String desc = super.toString() + ",  ";
		desc += "seat=" + NUMBER_OF_SEATS + "席,  ";
		desc += "passenger=" +passenger + "人";
		return desc;
	}

	@Override
	protected PassengerVehicle clone() throws CloneNotSupportedException {
		return (PassengerVehicle) super.clone();
	}

	// getter：NUMBER_OF_SEATS
	public int getNumberObSeats() {
		return NUMBER_OF_SEATS;
	}

	// getter：passenger
	public int getPassenger() {
		return passenger;
	}

	// setter：passenger
	public void setPassenger(int passenger) {
		this.passenger = passenger;
	}

	/**
	 * mainメソッド
	 *
	 * @param aargs
	 */
	public static void main(String[] args) {

		PassengerVehicle pVehicleA = new PassengerVehicle(5);
		PassengerVehicle pVehicleB = new PassengerVehicle("bob", 6);
		PassengerVehicle pVehicleC = new PassengerVehicle("bob", 8, 4);

		System.out.println(pVehicleA);
		System.out.println(pVehicleB);
		pVehicleB.setPassenger(2);
		System.out.println(pVehicleB);
		try {
			PassengerVehicle cloneObj = pVehicleC.clone();
			System.out.println(pVehicleC);
			System.out.println(cloneObj);
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

	}

}
