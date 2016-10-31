package jpl.ch01.ex15;

public class SimpleAddRemove implements AddRemove{

	private String[] names = new String[10];
	private Object[] values = new Object[10];


	@Override
	public void add(String name, Object value) {
			for (int i=0; i < names.length; i++) {
				if (names[i].equals(name)){
					values[i] = value;
					System.out.println("正常に追加されました。");
					break;
				}
			}
			System.out.println("名前が見つかりませんでした。");
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
	public void remove(String name) {
		for (int i=0; i < names.length; i++) {
			if (names[i].equals(name))
				 values[i] = null;
				System.out.println("正常に削除されました。");
		}
		System.out.println("名前が見つかりませんでした。");
	}

}
