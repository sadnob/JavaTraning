package jpl.ch13.ex02;

public class StrCount {

	/**
	 * 文字列中から指定された文字列の出現する回数を返します。
	 * @param str - 捜査対象の文字列
	 * @param ch - 検索する文字列
	 * @return  count - 文字列中の指定文字列出現回数。見つからない場合-1を返す。
	 */
	public static int count(String str, String strSeach) {
		int count = 0; // 出現数
		int first = str.indexOf(strSeach) ;  // 最初に出現するインデックス
		int last = str.lastIndexOf(strSeach);  // 最後に出現するインデックス
		if (first < 0)
			return -1;
		count++;
		// 最初と最後のインデックスが同じになるまでループ
		while (!(first == last)) {
			first = str.indexOf(strSeach, first+1);
			count++;
		}
		return count;
	}

	/**
	 * 確認用　mainメソッド
	 * @param args
	 */
	public static void main(String[] args) {

		final String testStr1 = "abcdefgabcdabcaba";
		final String testStr2 = "ab";
		int count = count(testStr1, testStr2);

		System.out.println("文字列："+ testStr2);
		System.out.println(count);

	}

}
