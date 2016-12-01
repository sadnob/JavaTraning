package jpl.ch06.ex05;

import java.awt.Color;

//******************************************************************
//Q6-5
//A. 定数固有の振る舞いでないため推奨しません。
//******************************************************************
enum TraficLight {
	RED() {
		public Color getColor() {
			return Color.red;
		}
	},
	BLUE() {
		public Color getColor() {
			return Color.blue;
		}
	},
	YELLOW() {
		public Color getColor() {
			return Color.yellow;
		}
	};

	/**
	 * Colorオブジェクトを返します
	 */
	abstract public Color getColor();

}
