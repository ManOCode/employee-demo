package moc.employee.util;

import java.text.SimpleDateFormat;

public class StringUtils {

	public static boolean hasValue(String value) {
		return !noValue(value);
	}

	public static boolean noValue(String value) {
		return value == null || value.isEmpty();
	}

	public static boolean withinLength(String value, int length) {
		return value.length() <= length;
	}

}