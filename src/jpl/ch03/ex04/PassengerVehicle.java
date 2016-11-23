package jpl.ch03.ex04;

import jpl.ch02.ex18.Vehicle;

/**
 * Q3-4
 *   どのメソッドもサブクラスの特性によりオーバーライドされる可能性があるためfinalする必要はありません。
 *
 */
public class PassengerVehicle extends Vehicle {

        private  final int seat;
        private int passenger;

        PassengerVehicle (int seat) {
        	super();
        	this.seat = seat;
        }

        PassengerVehicle (String name, int seat) {
        	super(name);
        	this.seat = seat;
        }

        PassengerVehicle (String name, int seat, int passenger) {
        	this(name, seat);
        	this.passenger = passenger;
        }

        /**
         * 座席数を取得するゲッター
         */
		public int getSeat() {
			return seat;
		}
        /**
         * 乗員の数を取得するゲッター
         */
		public int getPassenger() {
			return passenger;
		}
	      /**
         * 乗員の数を設定するセッター
         */
		public void setPassenger(int passenger) {
			this.passenger = passenger;
		}

        /**
         * メインメソッド
         */
        public static void main(String[] args) {

        	PassengerVehicle vehicleA = new PassengerVehicle(5);
        	PassengerVehicle vehicleB = new PassengerVehicle("bob", 6);
        	PassengerVehicle vehicleC = new PassengerVehicle("bob", 8, 4);

        	System.out.println(vehicleA);
            System.out.println("座席数：" + vehicleA.getSeat() + "席" + "  乗員：" + vehicleA.getPassenger() + "人");
            System.out.println("座席数：" + vehicleB.getSeat() + "席" + "  乗員：" + vehicleB.getPassenger() + "人");
        	vehicleB.setPassenger(2);
            System.out.println("座席数：" + vehicleB.getSeat() + "席" + "  乗員：" + vehicleB.getPassenger() + "人");
            System.out.println("座席数：" + vehicleC.getSeat() + "席" + "  乗員：" + vehicleC.getPassenger() + "人");

        }

}
