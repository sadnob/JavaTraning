package jpl.ch10.ex05;

public class BetweenCharacter {

	static public void interpolation(char start, char end) {
		if (start < end) {
			while (start <= end) {System.out.println(start++); }
		} else {
			while (start >= end) {System.out.println(start--); }
		}
	}

	public static void main(String[] args) {
		interpolation('a', 'z');
	}

}
