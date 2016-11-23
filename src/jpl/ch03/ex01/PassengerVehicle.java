package jpl.ch03.ex01;

import jpl.ch02.ex18.Vehicle;


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
         * メインクラス
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

		public int getSeat() {
			return seat;
		}

		public int getPassenger() {
			return passenger;
		}

		public void setPassenger(int passenger) {
			this.passenger = passenger;
		}



}
