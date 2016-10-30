package jpl.ch02.ex09;

public class Vehicle {

	public double Id;
	public String owner;
	public double speed;
	public double direction;

	private static  double nextId = 0;

	Vehicle () {
		this.Id = nextId++;
	}

	Vehicle (String name) {
		this.owner = name;
	}

	/**
	 * 現在使われている識別番号の最大値を得ます。
	 */
	static double getMaxId() {
		return nextId-1;
	}

}
