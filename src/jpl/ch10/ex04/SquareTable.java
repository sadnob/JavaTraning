package jpl.ch10.ex04;

public class SquareTable {

	// while文のみで実現可能
	public static void main(String[] args) {
		int squre;

		System.out.println("◆平方表◆");
		int i = 1;
		while (i<=10) {
			squre = i * i;
			System.out.println(squre);
			i++;
		}

/*		do {
			squre = i * i;
			System.out.println(squre);
			i++;
		} while (i<=10);*/
	}

}
