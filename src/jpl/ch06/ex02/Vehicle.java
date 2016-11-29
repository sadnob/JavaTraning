package jpl.ch06.ex02;

/**
 * Q6-4
 * 元のメソッドの場合、引数の型がString型であったためString型であれば何でも渡すことができてしまった。
 * 今回、引数の型がenum定数のため引数に渡されるのがenum宣言された定数のみに絞ることができる。
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
        /**
         * スピードを停止する。
         */
        public void stop() {
        	this.speed = 0.0;
        }

        /**
         *渡された角度だけ回転します。
         */
        public void turn(double direction) {
    this.direction += direction;
        }
        /**
         *右又は左に90度回転します。
         */
        public void turn(Turn direction) {

            if (direction == Turn.TURN_LEFT) {
            this.direction -= 90;
            } else if (direction == Turn.TURN_RIGHT) {
            this.direction += 90;
            }
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
