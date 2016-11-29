package jpl.ch03.ex01;

public class Vehicle implements Cloneable {

	private long Id;
	private String owner;
	private double speed;
	private double direction;
	private static long nextId = 1;
	public static final String TURN_LEFT = "TURN_LEFT";
	public static final String TURN_RIGHT = "TURN_RIGHT";

	protected Vehicle() {
		this.Id = nextId++;
	}

	protected Vehicle(String owner) {
		this();
		this.owner = owner;
	}

//*****************************************************************************
//　Q3-4
//　A:getNextId()はstaticメンバに関連しており、
//　サブクラスによるオーバーライドは考えにくいと判断しfinalメソッドとした。
//*****************************************************************************

	/** vehicleインスタンスの最大IDを得ます。 */
	static double getMaxId() {
		return nextId - 1;
	}

	/** 変速 */
	public void changeSpeed(double speed) {
		this.speed = speed;
	}

	/** 停止 */
	public void stop() {
		this.speed = 0.0;
	}

	/** 右旋回 */
	public void turn(double direction) {
		this.speed += direction;
	}

	/** 左旋回 */
	public void turn(String direction) {
		if (direction.equals(TURN_LEFT)) {
			this.direction -= 90;
		} else if (direction.equals(TURN_RIGHT)) {
			this.direction += 90;
		}
	}

	/**
	 * 各フィールドをまとめた文字列を返します。
	 * @Override
	 */
	public String toString() {
		String desc = "VehicleID:" + Id +"  ";
		desc +=  "owner=" + owner +",  ";
		desc += "speed=" + speed + "km/h,  direction=" + direction;
		return  desc;
	}

	/** getter：ID */
	public double getId() {
		return Id;
	}
	/** getter：nextId */
	public final double getNextId() {
		return nextId;
	}
	/** getter：owner */
	public String getOwner() {
		return owner;
	}
	/** getter：speed */
	public double getSpeed() {
		return speed;
	}
	/** getter：direction */
	public double getDirection() {
		return direction;
	}
	/** setter：owner */
	public void setOwner(String owner) {
		this.owner = owner;
	}
	/** setter：speed */
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	/** setter：direction */
	public void setDirection(double direction) {
		this.direction = direction;
	}

	/**
	 * mainメソッド
	 * @param args
	 */
	public static void main(String[] args) {

	}

}
