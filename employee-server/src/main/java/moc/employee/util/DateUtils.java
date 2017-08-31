package moc.employee.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

	private static final String DATE_PATTERN = "yyyy/MM/dd";

	public static String stringFormat(Date date) {
		return (new SimpleDateFormat(DATE_PATTERN)).format(date);
	}

	public static Date dateFormat(String date) {
		try {
			return (new SimpleDateFormat(DATE_PATTERN)).parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	public static int dateYears(Date date) {
		Calendar current = Calendar.getInstance();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int currentYear = current.get(Calendar.YEAR);
		int calendarYear = calendar.get(Calendar.YEAR);
		int year = currentYear - calendarYear;
		calendar.add(Calendar.YEAR, year);
		if (year > 0) {
			if (calendar.before(current)) {
				year -= 1;
			}
		} else if (year < 0) {
			if (calendar.before(current)) {
				year += 1;
			}
		}
		return year;
	}
}