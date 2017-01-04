package jpl.ch09.ex01;

public class Infinity {

	public static void main(String[] args) {
		final float pInfinity = Float.POSITIVE_INFINITY;
		float nInfinity = Float.NEGATIVE_INFINITY;

		/**********************同じ符号(正の無限大)での計算******************************/

		float addition = pInfinity + pInfinity;         // 足し算
		float subtraction = pInfinity - pInfinity;     // 引き算
		float multiplication = pInfinity*pInfinity;   // 掛け算
		float division = pInfinity/pInfinity;            // 割り算

		System.out.println("∞+∞："+ addition);
		System.out.println("∞－∞："+ subtraction);
		System.out.println("∞×∞："+ multiplication);
		System.out.println("∞÷∞："+ division);

		/**********************同じ符号(負の無限大)での計算******************************/
		addition = nInfinity + nInfinity;
		subtraction = nInfinity - nInfinity;
		multiplication = nInfinity * nInfinity;
		division = nInfinity / nInfinity;

		System.out.println("(-∞)+(-∞)："+ addition);
		System.out.println("(-∞)－(-∞)："+ subtraction);
		System.out.println("(-∞)×(-∞)："+ multiplication);
		System.out.println("(-∞)÷(-∞)："+ division);

		/**********************異なる符号の無限大での計算******************************/

		addition = pInfinity + nInfinity;
		subtraction = pInfinity - nInfinity;
		multiplication = pInfinity * nInfinity;
		division = pInfinity / nInfinity;

		System.out.println("∞+(-∞)："+ addition);
		System.out.println("∞－(-∞)："+ subtraction);
		System.out.println("∞×(-∞)："+ multiplication);
		System.out.println("∞÷(-∞)："+ division);

	}

}
