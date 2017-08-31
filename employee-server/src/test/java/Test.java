import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Test {
	public static void main(String[] args) {
		Date date = getDate();
		if (date != null) {
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			System.out.println(date);
			System.out.println(cal.getTime());
			System.out.println(cal.get(Calendar.YEAR));
			System.out.println(cal.get(Calendar.MONTH));
			System.out.println(cal.get(Calendar.DATE));
		} else {
			System.out.println("ERROR");
		}
	}

	public static Date getDate() {
		try {
			return (new SimpleDateFormat("yyyy/MM/dd")).parse("2016/07/32");
		} catch (ParseException e) {
			return null;
		}
	}
}