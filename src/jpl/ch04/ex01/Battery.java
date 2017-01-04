package jpl.ch04.ex01;

public class Battery implements EnergySource {

	private int level;

	public Battery(int level){
		this.level = level;
	}
	public boolean empty(){
		if(level == 0)return true;
		else return false;
	}

}