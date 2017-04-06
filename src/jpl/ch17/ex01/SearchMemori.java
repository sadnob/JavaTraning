package jpl.ch17.ex01;

public class SearchMemori {

	/**
	 * メモリの使用量の変化を確認するメインメソッド
	 * @param args
	 */
	public static void main(String[] args) {
		Runtime r = Runtime.getRuntime();

		System.out.println(r.freeMemory());
		createObject(100); // 100個生成
		System.out.println(r.freeMemory());
		createObject(1000); // 1000個生成
		System.out.println(r.freeMemory());
		createObject(10000); // 10000個生成
		System.out.println(r.freeMemory());
		createObject(100000); // 100000個生成
		System.out.println(r.freeMemory());
		createObject(1000000000); // 1000000000個生成
		System.out.println(r.freeMemory());


	}
	/**
	 * 指定した数だけオブジェクトを作成するメソッド
	 * @param num
	 */
	private static void createObject(long num) {
		for(long i=0; i<num; i++){
			new Object();
		}
	}

}
