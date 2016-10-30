package jpl.ch02.ex05;


public class VehicleMain {

	public double carId;
	public String owner;
	public double speed;
	public double direction;

	public static double nextId = 0;

	public static void main(String[] args) {

		VehicleMain firstVehicle = new VehicleMain();
		firstVehicle.owner = "太郎";
		firstVehicle.speed = 50;
		firstVehicle.direction = 30;

		VehicleMain secondVehicle = new VehicleMain();
		secondVehicle.owner = "二郎";
		secondVehicle.speed = 65;
		secondVehicle.direction = 60;

		VehicleMain thirdVehicle = new VehicleMain();
		thirdVehicle.owner = "三郎";
		thirdVehicle.speed = 80;
		thirdVehicle.direction = 90;

		System.out.println("[持ち主]：" + firstVehicle.owner + "  [現在のスピード]：" + firstVehicle.speed + "キロ" + "  [現在の方向]：" + firstVehicle.direction +"°");
		System.out.println("[持ち主]：" + secondVehicle.owner + "  [現在のスピード]：" + secondVehicle.speed + "キロ" +  "  [現在の方向]：" + secondVehicle.direction +"°");
		System.out.println("[持ち主]：" + thirdVehicle.owner + "  [現在のスピード]：" + thirdVehicle.speed + "キロ" +  "  [現在の方向]：" + thirdVehicle.direction +"°");

	}

}
