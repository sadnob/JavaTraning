package jpl.ch10.ex03;

public class WorkMain {

/* if文よりも"働く日" "働かない日" が分かりやすいので、switch文の方が明瞭なコードである*/
	public static void main(String[] args) {

		System.out.println("Sunday: " + isWorkDay(Week.SUNDAY));
		System.out.println("Monday: " + isWorkDay(Week.MONDAY));
		System.out.println("Tuesday: " + isWorkDay(Week.TUESDAY));
		System.out.println("Wednesday: " + isWorkDay(Week.WEDNESDAY));
		System.out.println("Thursday: " + isWorkDay(Week.THURSDAY));
		System.out.println("Friday: " + isWorkDay(Week.FRIDAY));
		System.out.println("Saturday: " + isWorkDay(Week.SATURDAY));

	}

/*	private static boolean isWorkDay(Week day) {
		if (day == Week.MONDAY || day == Week.TUESDAY || day == Week.WEDNESDAY
				|| day == Week.THURSDAY || day == Week.FRIDAY) {
			return true;
		} else if (day == Week.SUNDAY || day == Week.SATURDAY) {
			return false;
		} else {
			return false;
		}
	}*/

	private static boolean isWorkDay(Week day) {
		boolean work = true;

		switch (day) {
		case MONDAY:
		case TUESDAY:
		case WEDNESDAY:
		case THURSDAY:
		case FRIDAY:
			break;

		case SATURDAY:
		case SUNDAY:
			work = false;
			break;
		}
		return work;
	}
}
