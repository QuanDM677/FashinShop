package poly.cafe.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XDate {

    public static final String PATTERN_FULL = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_SHORT = "MM/dd/yyyy";

    public static Date now() {
        return new Date();
    }

    public static Date parse(String dateTime, String pattern) {
        SimpleDateFormat formater = new SimpleDateFormat(pattern);
        try {
            return formater.parse(dateTime);
        } catch (ParseException e) {
            return null;
        }
    }

    public static Date parse(String dateTime) {
        return parse(dateTime, PATTERN_SHORT);
    }

    public static String format(Date dateTime, String pattern) {
        if (dateTime == null) {
            return "";
        }
        SimpleDateFormat formater = new SimpleDateFormat(pattern);
        return formater.format(dateTime);
    }

    public static String format(Date dateTime) {
        return format(dateTime, PATTERN_SHORT);
    }

    public static void main(String[] args) {
        Date date = XDate.parse("Jan 21, 2024", "MMM dd, yyyy");
        String text = XDate.format(date, "dd-MMM-yyyy");
        System.out.println(text); // => 21-Jan-2024
    }
}
