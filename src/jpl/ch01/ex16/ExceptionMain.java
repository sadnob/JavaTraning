package jpl.ch01.ex16;

public class ExceptionMain {

	public static void main(String[] args) {
		MyUtilities muUtils = new MyUtilities();
		try {
			muUtils.getDateSet("input");
		} catch (BadDataSetException e) {
			System.out.println(e.dataName);
			System.out.println(e.ioException);
			//e.printStackTrace();
		}

	}

}
