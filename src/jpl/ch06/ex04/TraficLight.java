package jpl.ch06.ex04;

import java.awt.Color;

enum TraficLight {
	RED(Color.red),
	BLUE(Color.blue),
	YELLOW(Color.yellow);

	private Color color;
	TraficLight(Color color) {this.color = color;}

	/**
	 * Colorオブジェクトを返します
	 */
	public  Color getColor() {
		return this.color;
	}

}
