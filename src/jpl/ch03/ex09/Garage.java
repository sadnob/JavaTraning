package jpl.ch03.ex09;

public class Garage implements Cloneable {
	private int size;
	private Vehicle[] viecleList = new Vehicle[size];

	Garage(int size) {
		this.size = size;
	}

	/**
	 * 車庫にVehicleをセットします。
	 */
	public void setVehicle(Vehicle vehicle) {
		for (int i=1; i<size; i++) {
			if(viecleList[i] ==null) {
				viecleList[i] = vehicle;
				break;
			}
		}
		System.out.println("車庫がいっぱいです。");
	}

	/**
	 * @param id ： 対象のVehicleのID
	 * @return target : 対象のVehicle
	 */
	public Vehicle getVehicle(int id) {
		Vehicle target;
		for(int i = 1; i<size; i++) {
			if(viecleList[i].getId() == id) {
				target = viecleList[i];
				viecleList[i] = null;
				return target;
			}
		}
		return null;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	/**
	 * テスト用メインメソッド
	 */
	public static void main(String[] args) {

		Garage garage = new Garage(3);
		Vehicle vehicleA = new Vehicle();
		Vehicle vehicleB = new Vehicle();
		Vehicle vehicleC = new Vehicle();
		Vehicle vehicleD = new Vehicle();

	}

}
