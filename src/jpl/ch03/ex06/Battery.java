package jpl.ch03.ex06;

public class Battery extends EnergySource {

	private int level;

	public Battery(int level){
		this.level = level;
	}
	boolean empty(){
		if(level == 0)return true;
		else return false;
	}

}