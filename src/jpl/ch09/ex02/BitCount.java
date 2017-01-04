package jpl.ch09.ex02;

/*
 * 分かりませんでした。
 */
public class BitCount {

	public static void main(String[] args) {
		int num = 100;
		System.out.println(bitCount(num));

	}

/*	private int countBits (int num) {
		int count;

		return count;
	}*/

	/**
	 * ネット参照の公開アルゴリズム
	 * @param i
	 * @return bitが1の数
	 */
	public static int bitCount(int i) {
		  i = i - ((i >>> 1) & 0x55555555);
		  i = (i & 0x33333333) + ((i >>> 2) & 0x33333333);
		  i = (i + (i >>> 4)) & 0x0f0f0f0f;
		  i = i + (i >>> 8);
		  i = i + (i >>> 16);
		  return i & 0x3f;
		}

}
