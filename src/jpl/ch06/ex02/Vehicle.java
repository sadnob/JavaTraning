package jpl.ch06.ex02;

/**
 * Q6-2
 * 渡される引数がenum宣言された定数のみに絞ることができる。
 */
enum Turn{
	TURN_LEFT,
	TURN_RIGHT;
}

public class Vehicle {

        private final long Id;
        private String owner;
        private double speed;
        private double direction;

        private static long nextId = 1;

        Vehicle () {
                this.Id = nextId++;
        }

        Vehicle (String name) {
                this();
                this.owner = name;
        }

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

    	/** 旋回 */
    	public void turn(double direction) {
    		this.direction += direction;
    	}

        /**右又は左に90度旋回
         * @param　direction　TURN*/
        public void turn(Turn direction) {

            if (direction == Turn.TURN_LEFT) {
            this.direction -= 90;
            } else if (direction == Turn.TURN_RIGHT) {
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


}
