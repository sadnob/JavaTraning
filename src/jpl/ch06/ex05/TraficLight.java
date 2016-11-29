package jpl.ch06.ex05;

import java.awt.Color;

enum TraficLight {
	RED(Color.red) { public Color getColor(){return this.color;}},
	BLUE(Color.blue) { public Color getColor(){return this.color;}},
	YELLOW(Color.yellow) { public Color getColor(){return this.color;}};

	Color color;
	TraficLight(Color color) {this.color = color;}

	/**
	 * Colorオブジェクトを返します
	 */
	abstract public  Color getColor();

}
