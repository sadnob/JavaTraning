package jpl.ch03.ex09;

public class Garage implements Cloneable {

	private Vehicle[] vehicleList;

	Garage(int size) {
		vehicleList = new Vehicle[size];
	}

	// ガレージにvehicleをセットします。
	public void setVehicle(Vehicle vehicle) {
		for (int i=0; i<vehicleList.length; i++) {
			Object obj = vehicleList[i];
			if(obj ==null) {
				vehicleList[i] = vehicle;
				return;
			}
		}
		System.out.println("車庫がいっぱいです。");
	}

	// ガレージから指定したvehicleを取得します
	public Vehicle getVehicle(int id) {
		Vehicle target;
		for(int i = 1; i<vehicleList.length; i++) {
			if(vehicleList[i].getId() == id) {
				target = vehicleList[i];
				vehicleList[i] = null;
				return target;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		String desc = "";
		for(Vehicle obj : vehicleList) {
			desc += obj.toString() + " ";
		}
		return desc;
	}

	@Override
	protected Garage clone() throws CloneNotSupportedException {
		Garage cloneGarage = (Garage)super.clone();
		Vehicle[] cloneVehicleList = new Vehicle[vehicleList.length];
		for (int i = 0; i < cloneVehicleList.length; i++) {
			cloneVehicleList[i] = vehicleList[i].clone();
		}
		cloneGarage.setVehicleList(cloneVehicleList);
		return cloneGarage;
	}

	// getter：vehicleList
	public Vehicle[] getVehicleList() {
		return vehicleList;
	}
	// setter：vehicleList
	public void setVehicleList(Vehicle[] vehicleList) {
		this.vehicleList = vehicleList;
	}

	/**
	 *  mainメソッド
	 * @param args
	 */
	public static void main(String[] args) {

		Garage garage = new Garage(3);
		Vehicle vehicleA = new Vehicle("father");
		garage.setVehicle(vehicleA);
		Vehicle vehicleB = new Vehicle("mother");
		garage.setVehicle(vehicleB);
		Vehicle vehicleC = new Vehicle("brother");
		garage.setVehicle(vehicleC);
		try {
			System.out.println(garage);
			System.out.println(garage.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

}
