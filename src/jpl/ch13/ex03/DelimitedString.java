package jpl.ch13.ex03;

public class DelimitedString {

	/**
	 * 文字列から区切られたサブ文字列を取り出します。
	 */
	private static String delimitedString(
			String from, char start, char end) {
		int startPos = from.indexOf(start);
		int endPos = from.lastIndexOf(end);
		if (startPos == -1)     // 開始文字が見つからない
			return null;
		else if (endPos == -1)  // 終了文字が見つからない
			return from.substring(startPos);
		else if (startPos > endPos)  // 開始文字が終了文字の後ろにある
			return null;
		else                          // 開始文字と終了文字が見つかった
			return from.substring(startPos, endPos + 1);
	}
	/**
	 * mainメソッド
	 * @param args
	 */
	public static void main(String[] args) {

		String result = DelimitedString.delimitedString("abcdefghigjlmn", 'c', 'l');
		System.out.println(result);

	}

}
