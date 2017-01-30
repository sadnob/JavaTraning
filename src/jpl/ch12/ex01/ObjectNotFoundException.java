package jpl.ch12.ex01;

/*
 * **********************************************************************************
 * Q：nullを返すよりも例外をスローする方が好ましい理由
 * A：単純にnullを返すのに比べ、例外の名前から指定した要素が見つからなかったことが明確に認識できる。
 *       再帰処理をすぐに抜け出せる。
 *       nullを返すことによる他の例外の発生を抑えられる。
 * **********************************************************************************
 */
public class ObjectNotFoundException extends Exception {
	public <E> ObjectNotFoundException(E serchObj) {
		super(serchObj.toString());
	}

}
