package jpl.ch13.ex05;

public class Comma {

	public static String insert(String str) {
		int index = 0;
		int remainder = str.length() % 3;

		StringBuilder strbrd = new StringBuilder(str);

		if (remainder != 0) {
			index = remainder;
		} else {
			index = 3;
		}

		// 更新条件: 3文字 + 増えた","分の1文字
		for (; index < str.length(); index = index + 3 + 1) {
			strbrd.insert(index, ",");
		}
		return strbrd.toString();

	}

	/**
	 * 動作確認用mainメソッド
	 */
	public static void main(String[] args) {
		System.out.println(insert("12345678910"));
		System.out.println(insert("123"));
		System.out.println(insert("1"));
		System.out.println(insert(""));

	}

}