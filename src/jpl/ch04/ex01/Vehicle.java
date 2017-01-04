package jpl.ch04.ex01;

public class Vehicle implements Cloneable {

	private long Id;
	private String owner;
	private double speed;
	private double direction;
	private EnergySource source;
	private static long nextId = 1;
	public static final String TURN_LEFT = "TURN_LEFT";
	public static final String TURN_RIGHT = "TURN_RIGHT";

	public Vehicle() {
		this.Id = nextId++;
	}

	public Vehicle(String owner) {
		this();
		this.owner = owner;
	}

	public Vehicle(EnergySource  source) {
		this();
		this.source = source;
	}

	/**
	 *  vehicleインスタンスの最大IDを取得します。 */
	static double getMaxId() {
		return nextId - 1;
	}

	/**
	 * 速度を変更します。
	 * @param speed(double型)：変更する速度*/
	public void changeSpeed(double speed) {
		this.speed = speed;
	}

	/**
	 * 停止（speed＝0.0km/h）します。 */
	public void stop() {
		this.speed = 0.0;
	}

	/**
	 * 指定した値の角度で曲がります。
	 * @param direction(double型)：曲がる角度
	 */
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

	/**
	 * 動力源が空でなければtrueを返します。
	 * @return boolean
	 */
	public boolean start(){
		if(source.empty()) {
			return false;
		} else {
			return true;
		}
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
		Vehicle v1 = new Vehicle(new Battery(100));
		if(v1.start()){
			System.out.println("v1 start");
		}

		v1 = new Vehicle(new Battery(0));
		if(!v1.start()){
			System.out.println("v1 stop");
		}

		Vehicle v2 = new Vehicle(new GasTank(100));
		if(v2.start()){
			System.out.println("v2 start");
		}

		v2 = new Vehicle(new GasTank(0));
		if(!v2.start()){
			System.out.println("v2 stop");
		}

	}

}
