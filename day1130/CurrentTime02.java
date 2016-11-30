package day1130;

import java.util.Calendar;

public class CurrentTime02 {
	public static void main(String[] args) {
		Calendar time=Calendar.getInstance();
		System.out.println(time);
		int year=time.get(Calendar.YEAR);
		int month=time.get(Calendar.MONTH);
		int day=time.get(Calendar.DATE);
		int week_month=time.get(Calendar.WEEK_OF_MONTH);
		int week_year=time.get(Calendar.WEEK_OF_YEAR);
		int weekdays=time.get(Calendar.DAY_OF_WEEK);
		System.out.println(year+" "+month+" "+day+" "+week_month+" "+week_year+" "+weekdays);
	}
}
