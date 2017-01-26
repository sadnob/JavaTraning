package jpl.ch13.ex01;

public class CharCount {

	/**
	 * 文字列中から指定された文字の出現する回数を返します。
	 * @param str - 捜査対象の文字列
	 * @param ch - 検索する文字
	 * @return  count - 文字列中の指定文字出現回数。見つからない場合-1を返す。
	 */
	public static int count(String str, char ch) {
		int count = 0; // 出現数
		int first = str.indexOf(ch) ;  // 最初に出現するインデックス
		int last = str.lastIndexOf(ch);  // 最後に出現するインデックス
		if (first < 0)
			return -1;
		count++;
		// 最初と最後のインデックスが同じになるまでループ
		while (!(first == last)) {
			first = str.indexOf(ch, first+1);
			count++;
		}
		return count;
	}

	/**
	 * 確認用　mainメソッド
	 * @param args
	 */
	public static void main(String[] args) {

		final String testStr = "abcdefgabcdabcaba";
		final char testCh = 'a';
		int count = count(testStr, testCh);

		System.out.println("文字列："+ testStr);
		System.out.println(count);

	}

}
