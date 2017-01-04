package jpl.ch04.ex01;

public class GasTank implements EnergySource {

	private int amount;

	public GasTank(int amount){
		this.amount = amount;
	}
	public boolean empty(){
		if(amount == 0)return true;
		else return false;
	}

}
