package jpl.ch02.ex13;

public class Vehicle {

	private final long Id;   // 設定後変わることがないため、変更を許すメソッドを持つべきではない。
	private String owner;  // 変わる可能性があるため、変更を許すメソッドを持つべきである。
	private double speed; // 変わる可能性が大いにあるため、変更を許すメソッドを持つべきである。
	private double direction; //変わる可能性が大いにあるため、変更を許すメソッドを持つべきである

	private static long nextId = 0; //クラス変数でありインスタンス生成時のみ加算されるという決まりのため変更を許すメソッドを持つべきではない。

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
	/**
	 * Idを取得するゲッターメソッド
	 */
	public double getId() {
		return Id;
	}

	/**
	 * 次のIdを取得するゲッターメソッド
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
	 * 所有者を設定するセッターメソッド
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
	 * スピードを設定するセッターメソッド
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
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
