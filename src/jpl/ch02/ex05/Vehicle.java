package jpl.ch02.ex05;


public class Vehicle {

	public final long Id = nextId++;
	public String owner;
	public double speed;
	public double direction;

	public static long nextId = 1;

	public static void main(String[] args) {

		Vehicle VehicleA = new Vehicle();
		VehicleA.owner = "A";
		VehicleA.speed = 50;
		VehicleA.direction = 30;

		Vehicle VehicleB = new Vehicle();
		VehicleB.owner = "B";
		VehicleB.speed = 65;
		VehicleB.direction = 60;

		Vehicle VehicleC = new Vehicle();
		VehicleC.owner = "C";
		VehicleC.speed = 80;
		VehicleC.direction = 90;

		System.out.println("[持ち主]：" + VehicleA.owner + "  [現在のスピード]：" + VehicleA.speed + "キロ" + "  [現在の方向]：" + VehicleA.direction +"°");
		System.out.println("[持ち主]：" + VehicleB.owner + "  [現在のスピード]：" + VehicleB.speed + "キロ" +  "  [現在の方向]：" + VehicleB.direction +"°");
		System.out.println("[持ち主]：" + VehicleC.owner + "  [現在のスピード]：" + VehicleC.speed + "キロ" +  "  [現在の方向]：" + VehicleC.direction +"°");

	}

}
