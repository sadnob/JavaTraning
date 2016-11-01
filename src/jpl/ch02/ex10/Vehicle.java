package jpl.ch02.ex10;

public class Vehicle {

	public final long Id;
	public String owner;
	public double speed;
	public double direction;

	public static long nextId = 0;

	Vehicle () {
		this.Id = nextId++;
	}

	Vehicle (String name) {
		this();
		this.owner = name;
	}

	/**
	 * 現在使われている識別番号の最大値を得ます。
	 */
	static double getMaxId() {
		return nextId-1;
	}

	public String toString() {
		return "[ID = "+ Id + "  Owner =" + owner + " ] [Speed = " + speed + "direction = " + direction + " ]";
	}

}
