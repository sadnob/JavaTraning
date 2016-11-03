package jpl.ch01.ex15;

public class SimpleAddRemove implements AddRemove{

	private String[] names = {"A", "B", "C", "D", "E"};
	private Object[] values = new Object[names.length];


	@Override
	public boolean add(String name, Object value) {
		boolean addCheck = false;
			for (int i=0; i < names.length; i++) {
				if (names[i].equals(name)){
					values[i] = value;
					addCheck = true;
				}
			}
			return addCheck;
	}

	@Override
	public Object find(String name) {
		for (int i=0; i < names.length; i++) {
			if (names[i].equals(name))
				return values[i];
		}
		return null; // 見つからなかった
	}

	@Override
	public boolean remove(String name) {
		boolean removeCheck = false;
		for (int i=0; i < names.length; i++) {
			if (names[i].equals(name))
				 values[i] = null;
			removeCheck = true;
		}
		return removeCheck;
	}

}
