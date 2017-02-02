package jpl.ch13.ex03;


public class DelimitedString {

	/**
	 * 文字列から区切られたサブ文字列を取り出します。
	 * 複数存在する場合すべてのサブ文字列を取得します。
	 */
	private static String[] delimitedStrings(String from, char start, char end) {

		int count = 0;
		String[] str = from.split(String.valueOf(end)); // 終了文字で分ける
		String[] result;

		int startPos = from.indexOf(start);
		int endPos = from.lastIndexOf(end);

		if (startPos == -1){     // 開始文字が見つからない
			return null;
		}else if (endPos == -1){   // 終了文字が見つからない
			result = new String[1];
			result[0] = from;
			return result;
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
	 * テスト用mainメソッド
	 * @param args
	 */
	public static void main(String[] args) {

		String[] resultA = delimitedStrings("abcdefghigjlclmcnadldllcllll", 'c', 'l');
		System.out.println("テストA　期待結果：cdefghigjl, cl, cnadl, cl");
		for (String str : resultA) {
			System.out.println(str);
		}
		String[] resultB = delimitedStrings("aaaaaaa", 'a', 'c');
		System.out.println("テストB　期待結果：aaaaaaa");
		for (String str : resultB) {
			System.out.println(str);
		}
		String[] resultC = delimitedStrings("daefeseew", 'q', 'z');
		System.out.println("テストC　期待結果：null");
		System.out.println(resultC);

	}

}
