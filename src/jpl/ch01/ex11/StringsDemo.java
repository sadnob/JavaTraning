package jpl.ch01.ex11;

public class StringsDemo {

	public static void main(String[] args) {
		String myName = "Petronius";
		String occupation = "doctor";
		String sex = "man";

		myName = myName + " Arbiter";
		myName += " ";
		myName += "(sex:" + sex + " " + " Occupation:" + occupation + ")";
		System.out.println("Name = " + myName );

	}

}
