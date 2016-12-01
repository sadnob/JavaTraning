package jpl.ch02.ex08;


public class Vehicle {

	public final long Id;
	public String owner;
	public double speed;
	public double direction;

	public static long nextId = 1;

	Vehicle () {
		this.Id = nextId++;
	}

	Vehicle (String owner) {
		this();
		this.owner = owner;
	}

	public static void main(String[] args) {

	Vehicle firstVehicle = new Vehicle("A");
	firstVehicle.speed = 50;
	firstVehicle.direction = 30;

	Vehicle secondVehicle = new Vehicle("B");
	secondVehicle.speed = 65;
	secondVehicle.direction = 60;

	Vehicle thirdVehicle = new Vehicle("C");
	thirdVehicle.speed = 80;
	thirdVehicle.direction = 90;

	System.out.println("[持ち主]：" + firstVehicle.owner + "  [現在のスピード]：" + firstVehicle.speed + "キロ" + "  [現在の方向]：" + firstVehicle.direction +"°");
	System.out.println("[持ち主]：" + secondVehicle.owner + "  [現在のスピード]：" + secondVehicle.speed + "キロ" +  "  [現在の方向]：" + secondVehicle.direction +"°");
	System.out.println("[持ち主]：" + thirdVehicle.owner + "  [現在のスピード]：" + thirdVehicle.speed + "キロ" +  "  [現在の方向]：" + thirdVehicle.direction +"°");

	}

}
