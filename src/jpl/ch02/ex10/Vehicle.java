package jpl.ch02.ex10;

public class Vehicle {

	public final long Id;
	public String owner;
	public double speed;
	public double direction;

	public static long nextId = 1;

	public Vehicle () {
		this.Id = nextId++;
	}

	public Vehicle (String name) {
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
		return "[ID : "+ Id + " Owner : " + owner + "] [Speed = " + speed + " Direction = " + direction + "]";
	}

}
