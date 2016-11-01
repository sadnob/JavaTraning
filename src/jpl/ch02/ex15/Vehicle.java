package jpl.ch02.ex15;

public class Vehicle {

	private final long Id;
	private String owner;
	private double speed;
	private double direction;

	private static long nextId = 0;

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

	/**
	 *現在のスピードを渡された値に変更する。
	 */
	public void changeSpeed(double speed) {
		setSpeed(speed);
	}

	public String toString() {
		return "[ID = "+ Id + "  Owner =" + owner + " ] [Speed = " + speed + "direction = " + direction + " ]";
	}

	public double getId() {
		return Id;
	}

	public double getNextId() {
		return nextId;
	}

	public String getOwner() {
		return owner;
	}

	public double getSpeed() {
		return speed;
	}

	public double getDirection() {
		return direction;
	}

	/**
	 * 所有者を設定するセッターメソッド
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * スピードを設定するセッターメソッド
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	/**
	 * 方向を設定するセッターメソッド
	 */
	public void setDirection(double direction) {
		this.direction = direction;
	}



}
