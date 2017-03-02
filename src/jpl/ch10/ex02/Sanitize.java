package jpl.ch10.ex02;

public class Sanitize {

	static String change(String str) {

		String result = "";

		for (int i = 0; i < str.length(); i++) {

			char c = str.charAt(i);

			switch (c) {
			case '\n':
				result += "\\n";
				break;
			case '\t':
				result += "\\t";
				break;
			case '\b':
				result += "\\b";
				break;
			case '\r':
				result += "\\r";
				break;
			case '\f':
				result += "\\f";
				break;
			case '\\':
				result += "\\\\";
				break;
			case '\'':
				result += "\\'";
				break;
			case '\"':
				result += "\\\"";
				break;
			default:
				result += c;
			}
		}

		return result;
	}

	public static void main(String[] args) {
		// \ " ' \t \b \r \f \n
		String str = "\n \t \b \r \f \\ \' \" ";

		System.out.println(str + " ⇒ " + change(str));
	}

}