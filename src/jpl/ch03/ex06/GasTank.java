package jpl.ch03.ex06;

public class GasTank extends EnergySource {

	private int amount;

	public GasTank(int amount){
		this.amount = amount;
	}
	boolean empty(){
		if(amount == 0)return true;
		else return false;
	}

}
