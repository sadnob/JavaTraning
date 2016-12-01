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

	public Vehicle (String owner) {
		this();
		this.owner = owner;
	}

	/**
	 * 現在使われている識別番号の最大値を得ます。
	 */
	static double getMaxId() {
		return nextId-1;
	}

	/**
	 * 各フィールドをまとめた文字列を返します。
	 * @Override
	 */
	public String toString() {
		String desc = "VehicleID:" + Id + "  ";
		desc += "owner=" + owner + ",  ";
		desc += "speed=" + speed + "km/h,  direction=" + direction;
		return desc;
	}

}
