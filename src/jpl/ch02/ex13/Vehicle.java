package jpl.ch02.ex13;

public class Vehicle {

	private double Id;
	private String owner;
	private double speed;
	private double direction;

	private static  double nextId = 0;

	Vehicle () {
		this.Id = nextId++;
	}

	Vehicle (String name) {
		this.setOwner(name);
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
	 * 所有者を設定するゲッターメソッド
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
	 * スピードを設定するゲッターメソッド
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
	 * 方向を設定するゲッターメソッド
	 */
	public void setDirection(double direction) {
		this.direction = direction;
	}



}
