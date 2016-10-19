import java.util.*;

/* 
Your previous Plain Text content is preserved below:

# Calendar Math

## Goal

weekday(year, month, day) -> name

## Example

weekday(2016, 8, 17) -> wed

## Given

- a reference date -- specifically today
  we can hardcode that 2016/8/17 is a Tuesday
- number of days in each month
- list of days in a week
- leap year rules

## Notes

- Correctness > Efficiency
- Suggestion: days in the past first

## Leap Year Rules

- typically, a leap year is every 4 years
  2016, 2012, 2008, etc etc
- exception every century (every 100 years)
   - only every 4th century is a leap year
  2000 - yes
  1900 - no    1904 - yes (because it's not the 100th year)
  1800 - no
  1700 - no
  1600 - yes

 */

public class SquareInterview {

    int curr_year = 2016;
    int curr_month = 8;
    int curr_day = 17;
    String curr_weekday = "Wed";

    static final String[] WEEKDAYS = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

    // 1-indexed array of the number of days in each month
    // does not account for leap years when feb (2) has 29 days
    static final int[] MONTH_DAYS = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public String weekday(int year, int month, int day) {

	int total_days = 0;
	int ref_month = month;
	if (year != curr_year || month != curr_month) {
	    if (isLeapYear(year) && month == 2) {
		total_days = 29 - day + 1;
	    } else {
		total_days = MONTH_DAYS[month] - day + 1;
	    }
	    ref_month += 1;
	} else {
	    total_days += curr_day - day; 
	}

	int start_year = (curr_year > year) ? year : curr_year;
	int end_year = (curr_year > year)  ? curr_year : year;
	while (start_year != end_year || curr_month != ref_month) {

	    if (isLeapYear(start_year) && ref_month == 2) {
		total_days += 29;
	    } else {
		total_days += MONTH_DAYS[ref_month];
	    }

	    if (ref_month == 12) {
		start_year++;
		ref_month = 1;
	    } else {
		ref_month++;
	    }
	}

	if (year != curr_year || month != curr_month) {
	    total_days += curr_day - 1;
	}

	int rem_days = total_days % 7;
	int curr_day_index = Arrays.asList(WEEKDAYS).indexOf(curr_weekday);

	while (rem_days > 0) {
	    --curr_day_index;

	    if (curr_day_index < 0) {
		curr_day_index = WEEKDAYS.length - 1;
	    }

	    --rem_days;
	}

	return WEEKDAYS[curr_day_index];
    }


    public static boolean isLeapYear(int year) {
	boolean isLeapYear;
	
	//divisible by 4
	isLeapYear = (year % 4) == 0;
	
	//divisible by 4 and not 100
	isLeapYear = isLeapYear && (year % 100 != 0);
	
	// divisible by 4 and not 100 unless divisible by 400
	isLeapYear = isLeapYear || (year % 400 == 0);
	
	return isLeapYear;
}

    public static void main(String[] args) {
	SquareInterview s = new SquareInterview();

	System.out.println(s.weekday(2014, 4, 10) + ", expected Thu"); // 860 days
	System.out.println(s.weekday(1970, 1, 1) + ", expected Thu"); // 17030 days
	System.out.println("---");
	System.out.println(s.weekday(2016, 8, 16) + ", expected Tue");
	System.out.println(s.weekday(2016, 8, 15) + ", expected Mon");
	System.out.println(s.weekday(2016, 8, 14) + ", expected Sun");
	System.out.println(s.weekday(2016, 8, 13) + ", expected Sat");
	System.out.println(s.weekday(2016, 8, 12) + ", expected Fri");
	System.out.println(s.weekday(2016, 8, 11) + ", expected Thu");
	System.out.println(s.weekday(2016, 8, 10) + ", expected Wed");
	System.out.println(s.weekday(2016, 8, 9) + ", expected Tue");
	System.out.println("---");
	System.out.println(isLeapYear(1988) + ", expected true");

    }

}
