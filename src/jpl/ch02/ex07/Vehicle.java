package jpl.ch02.ex07;


public class Vehicle {

	public double Id;
	public String owner;
	public double speed;
	public double direction;

	private static  double nextId = 0;

	Vehicle () {
		this.Id = nextId++;
	}

	Vehicle (String name) {
		this.owner = name;
	}

	public static void main(String[] args) {

	Vehicle firstVehicle = new Vehicle("太郎");
	firstVehicle.speed = 50;
	firstVehicle.direction = 30;

	Vehicle secondVehicle = new Vehicle("二郎");
	secondVehicle.speed = 65;
	secondVehicle.direction = 60;

	Vehicle thirdVehicle = new Vehicle("三郎");
	thirdVehicle.speed = 80;
	thirdVehicle.direction = 90;

	System.out.println("[持ち主]：" + firstVehicle.owner + "  [現在のスピード]：" + firstVehicle.speed + "キロ" + "  [現在の方向]：" + firstVehicle.direction +"°");
	System.out.println("[持ち主]：" + secondVehicle.owner + "  [現在のスピード]：" + secondVehicle.speed + "キロ" +  "  [現在の方向]：" + secondVehicle.direction +"°");
	System.out.println("[持ち主]：" + thirdVehicle.owner + "  [現在のスピード]：" + thirdVehicle.speed + "キロ" +  "  [現在の方向]：" + thirdVehicle.direction +"°");

	}

}
