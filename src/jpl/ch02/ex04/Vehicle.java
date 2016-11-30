package jpl.ch02.ex04;

public class Vehicle {

	/*Id：はインスタンスの識別番号であり、設定後は不変のインスタンス変数であると考えられるためfinal修飾子が必要である。*/
	/* nextId：クラス変数でありインスタンスが作成される毎に変化するためfinal修飾子は不要である。*/

	public final long Id = nextId++;
	public String owner;
	public double speed;
	public double direction;

	public static long nextId = 1;


}
