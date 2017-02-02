package jpl.ch13.ex05;

import java.util.regex.Pattern;

public class Comma {
		public static String insert(String num) {
			return Pattern.compile("(?<=[0-9])(?=([0-9]{3})+$)")
					.matcher(num).replaceAll(",");
		}
    /**
     * 動作確認用mainメソッド
     */
    public static void main(String[] args) {
        System.out.println(insert("12345678910"));
        System.out.println(insert("123"));
        System.out.println(insert("1"));
        System.out.println(insert(""));

    }

}