package jpl.ch10.ex01;

public class Sanitize {

	static String change(String str){

		String result = "";

		for(int i = 0; i < str.length(); i++) {

			char c = str.charAt(i);

			if(c == '\n') {
				result += "\\n";
			} else if(c == '\t') {
				result += "\\t";
			} else if(c == '\b') {
				result += "\\b";
			} else if(c == '\r') {
				result += "\\r";
			} else if(c == '\f') {
				result += "\\f";
			} else if(c == '\\') {
				result += "\\\\";
			} else if(c == '\'') {
				result += "\\'";
			} else if(c == '\"') {
				result += "\\\"";
			} else {
				result += c;
			}
		}

		return result;
	}

	public static void main(String[] args){
		//\ " ' \t \b \r \f \n
		String str = "\n \t \b \r \f \\ \' \" ";

		System.out.println( str + " ⇒ " + change(str));
	}

}