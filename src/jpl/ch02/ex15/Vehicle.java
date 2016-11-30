package jpl.ch02.ex15;

public class Vehicle {

	private final long Id;
	private String owner;
	private double speed;
	private double direction;

	private static long nextId = 1;

	Vehicle() {
		this.Id = nextId++;
	}

	Vehicle(String owner) {
		this();
		this.owner = owner;
	}

	/**
	 * 現在使われている識別番号の最大値を得ます。
	 */
	static double getMaxId() {
		return nextId - 1;
	}

	/**
	 * 現在のスピードを渡された値に変更する。
	 */
	public void changeSpeed(double speed) {
		this.speed = speed;
	}

	/**
	 * スピードをゼロにする。
	 */
	public void stop() {
		this.speed = 0.0;
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

	/**
	 * IDを取得するゲッターメソッド
	 */
	public double getId() {
		return Id;
	}

	/**
	 * 次のIDを取得するゲッターメソッド
	 */
	public double getNextId() {
		return nextId;
	}

	/**
	 * 所有者を取得するゲッターメソッド
	 */
	public String getOwner() {
		return owner;
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
