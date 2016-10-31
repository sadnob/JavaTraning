package jpl.ch02.ex10;

public class Vehicle {

	public double id;
	public String owner;
	public double speed;
	public double direction;

	private static  double nextId = 0;

	Vehicle () {
		this.id = nextId++;
	}

	Vehicle (String name) {
		this.owner = name;
	}
	public String toString() {
		return "[ID = "+ id + "  Owner =" + owner + " ] [Speed = " + speed + "direction = " + direction + " ]";
	}

}
