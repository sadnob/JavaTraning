package jpl.ch09.ex03;

/*
 * Q9-3
 * 　パスカルの三角形を表示するロジックに関しては、拡張for文を使用することでより簡潔に書くことができた。
 */
public class Pascal {

	public static void main(String[] args) {

		int depth = 12;
		int[][] pascal = pascal(depth);
		display(pascal);
	}

	/**
	 * パスカルの三角形を計算するメソッド
	 * @param depth ：パスカルの三角形の深さ
	 * @return pascal ：計算したパスカルの三角形を格納した2次元配列
	 */
	private static int[][] pascal(int depth) {
		int[][] pascal = new int[depth][];

		for (int i = 0; i < pascal.length; i++) {
			int[] inner = new int[i + 1];
			for (int j = 0; j <= i; j++) {
				if (j == 0 || j == i) { // 最初or最後の要素に"1"を設定する。
					inner[j] = 1;
				} else {
					inner[j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
				}
			}
			pascal[i] = inner;
		}
		return pascal;
	}

	/**
	 * 二次元配列の要素を画面に出力します。
	 * @param pascal  ： パスカルの三角形の要素を持つ2次元配列
	 */
	private static void display(int[][] pascal) {
/*		for (int i = 0; i < pascal.length; i++) {
			for (int j = 0; j < pascal[i].length; j++) {
				// System.out.printf("(a+b)の"+i+"乗：");
				System.out.printf("%d ", pascal[i][j]);
			}
			System.out.println("\n");
		}*/

		for (int[] i : pascal) {
			for (int j : i) {
				// System.out.printf("(a+b)の"+i+"乗：");
				System.out.printf("%d ", j);
			}
			System.out.println("\n");
		}
	}

}
