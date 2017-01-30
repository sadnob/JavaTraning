package jpl.ch13.ex03;


public class DelimitedString {

	/**
	 * 参考書
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
	 * 文字列から区切られたサブ文字列を取り出します。
	 * 複数存在する場合すべてのサブ文字列を取得します。
	 */
	private static String[] delimitedStrings(String from, char start, char end) {

		int count = 0;
		String[] str = from.split(String.valueOf(end)); // 終了文字で分ける
		String[] result;

		int startPos = from.indexOf(start);

		if (startPos == -1){     // 開始文字が見つからない
			return null;
		}else {
			for (int i = 0; i<str.length; i++) {
				startPos = str[i].indexOf(start);
				if (startPos != -1) {
					str[i] = str[i].substring(startPos) + end;
					count++;
				} else {
					str[i] = null;
				}
			}
			result = new String[count];
			// 結果の配列に入れ替え
			for (int i = 0, j = 0; i<str.length; i++) {
				if (str[i] != null) {
					result[j] = str[i];
					j++;
				}
			}
		}

		return result ;

	}
	/**
	 * mainメソッド
	 * @param args
	 */
	public static void main(String[] args) {

		String[] result = DelimitedString.delimitedStrings("abcdefghigjlclmcnadldllcllll", 'c', 'l');
		for (String str : result) {
			System.out.println(str);
		}

	}

}
