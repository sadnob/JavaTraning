package jpl.ch01.ex08;

public class Point {

        public double  x, y;

        // 原点の座標
        public static Point origin = new Point();

        // 座標をゼロにクリアします。
        public void clear() {
        	this.x = 0.0;
        	this.y = 0.0;
        }

        // 渡されたパラメータで座標を設定します。
        public void move(double x, double y) {
        	this.x = x;
        	this.y = y;
        }

        // 渡されたPointオブジェクトと同じ座標を設定します。
        public void moveEqual(Point point) {
        	this.x = point.x;
        	this.y = point.y;
        }
        // 自分自身と渡されたポイント間のユークリッド距離を計算します。
        public double distance(Point that) {
        	double xdiff = x - that.x;
        	double ydiff = y - that.y;
        	return Math.sqrt(xdiff * xdiff + ydiff * ydiff) ;
        }




}
