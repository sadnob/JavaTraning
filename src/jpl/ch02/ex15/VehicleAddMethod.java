package jpl.ch02.ex15;

public class VehicleAddMethod {
	private double Id;
	private String owner;
	private double speed;
	private double direction;

	private static  double nextId = 0;

	/**
	 *
	 */
	VehicleAddMethod () {
		this.Id = nextId++;
	}

	/**
	 *
	 */
	VehicleAddMethod (String name) {
		this.setOwner(name);
	}

	/**
	 * スピードを変更するメソッド
	 */
	public void changeSpeed (int speed) {
		this.speed = speed;
	}
	/**
	 * スピードを０にするメソッド
	 */
	public void stop () {
		this.speed = 0;
	}

	/**
	 * Idを返すゲッターメソッド
	 */
	public double getId() {
		return Id;
	}
	/**
	 * 所有者を取得するゲッターメソッド
	 */
	public String getOwner() {
		return owner;
	}
	/**
	 * 所有者を設定するゲセッターメソッド
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/**
	 * スピードを取得するゲッターメソッド
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * 方向を取得するゲッターメソッド
	 */
	public double getDirection() {
		return direction;
	}
	/**
	 * 方向を設定するセッターメソッド
	 */
	public void setDirection(double direction) {
		this.direction = direction;
	}

}
