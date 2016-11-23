package jpl.ch03.ex04;

/**
 * Q3-4
 *   どのメソッドもサブクラスの特性によりオーバーライドされる可能性があるためfinalする必要はありません。
 *
 */
public class Vehicle {

        private final long Id;
        private String owner;
        private double speed;
        private double direction;
        public static final String TURN_LEFT = "TURN_LEFT";
        public static final String TURN_RIGHT = "TURN_RIGHT";

        private static long nextId = 1;

        protected Vehicle () {
                this.Id = nextId++;
        }

        protected Vehicle (String name) {
                this();
                this.owner = name;
        }

        /**
         * メインクラス
         */
        public static void main(String[] args) {

            Vehicle vehicle = new Vehicle(args[0]);

            System.out.println(vehicle);

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
                this.speed = speed;
        }

        /**
         * スピードを停止させます。
         */
        public void stop() {
        	this.speed = 0.0;
        }

        /**
         *渡された角度だけ回転します。
         */
        public void turn(double direction) {
    this.speed += direction;
        }
        /**
         *右又は左に90度回転します。
         */
        public void turn(String direction) {
            if (direction.equals(TURN_LEFT)) {
            this.direction -= 90;
            } else if (direction.equals(TURN_RIGHT)) {
            this.direction += 90;
            }
        }

        public String toString() {
                return "[ID = "+ Id + "  Owner =" + owner + " ] [Speed = " + speed + " direction = " + direction + " ]";
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

        public void setOwner(String owner) {
                this.owner = owner;
        }

        public void setSpeed(double speed) {
                this.speed = speed;
        }

        public void setDirection(double direction) {
                this.direction = direction;
        }



}
