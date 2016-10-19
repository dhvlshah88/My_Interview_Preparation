import java.util.*;

public class CalendarObj {

    private static String[] days = {"sun", "mon", "tues", "wed", "thur", "fri", "sat"};
    private static int[] MONTH_DAYS = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    private static Calendar now = Calendar.getInstance();
    private static int REFERENCE_YEAR = now.get(Calendar.YEAR);
    private static int REFERENCE_MONTH = now.get(Calendar.MONTH) + 1;
    private static int REFERENCE_DAY = now.get(Calendar.DAY_OF_MONTH);

    public final int year;
    public final int month;
    public final int day;

    public CalendarObj (int year, int month, int day) {
	this.year = year;
	this.month = month;
	this.day =day;
    }

    public String weekday() {
	if (isDateCurrent()) {
	    System.out.println(now.get(Calendar.DAY_OF_WEEK));
	    return days[now.get(Calendar.DAY_OF_WEEK)-1];
	}

	//		int diffYear = !this.isDateFuture() ? (REFERENCE_YEAR - this.year - 1) : (this.year - REFERENCE_YEAR - 1);
	int diffMonth = !this.isDateFuture() ? (REFERENCE_MONTH - 1) :  (this.month - REFERENCE_MONTH-1);  	
	int diffDays =  !this.isDateFuture() ? (MONTH_DAYS[this.month] - this.day + REFERENCE_DAY) : (MONTH_DAYS[REFERENCE_MONTH] - REFERENCE_DAY + this.day);

	int monthIndex = !this.isDateFuture() ? this.month + 1 : REFERENCE_MONTH + 1;
	while(diffMonth > 0) {
	    if (monthIndex == 1 && diffMonth >= 12) {
		diffDays += daysInYear();
		diffDays -= 12;
	    } else {
		diffDays += MONTH_DAYS[monthIndex];
		monthIndex++;
		diffMonth-- ;
	    }
	}

	int mod = diffDays % 7;
	int dayIndex = Calendar.DAY_OF_WEEK - 1;
	if (isDateFuture()) {
	    while (dayIndex <= Calendar.SATURDAY && mod > 0) {
		mod--;
		dayIndex++;
		if (dayIndex > Calendar.SATURDAY) {
		    dayIndex = Calendar.SUNDAY;
		}
	    }
	} else {
	    while (dayIndex <= Calendar.SATURDAY && mod > 0) {
		mod--;
		dayIndex--;
		if (dayIndex < Calendar.SUNDAY) {
		    dayIndex = Calendar.SATURDAY;
		}
	    }
	}

	return days[dayIndex];
    }

    public int daysInYear() {
	int daysInYear = 0;
	for (int days : MONTH_DAYS) {
	    daysInYear += days;
	}
	return daysInYear;
    }

    public boolean isDateFuture() {
	return  (this.year >= REFERENCE_YEAR && this.month >= REFERENCE_MONTH && this.day > REFERENCE_DAY);
    }

    public boolean isDateCurrent() {
	return (this.year == REFERENCE_YEAR && this.month == REFERENCE_MONTH && this.day == REFERENCE_DAY);
    }

    public static void main(String[] args) {
	CalendarObj calendarObj = new CalendarObj(2016, 2, 20);
	System.out.println(calendarObj.weekday());
    }

}
