package jpl.ch02.ex12;

public class Vehicle {
	/*
	 * 複数のVehicleオブジェクトを引数に取り、現在止まっているオブジェクトの数をカウントする等
	 * のメソッドを実装する際には必要である。
	 */
	public final long Id;
	public String owner;
	public double speed;
	public double direction;

	public static long nextId = 1;

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
