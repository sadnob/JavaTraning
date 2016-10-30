package jpl.ch02.ex10;

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

}
