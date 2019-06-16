package com.brushbasics.evs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtility {
	static SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:MM:ss");

	public static String getCurrentDateToString() {
		Calendar calendar = Calendar.getInstance();
		return dateFormat.format(calendar.getTime());
	}

	public static Date getDateFromString(String s) throws ParseException {
		return dateFormat.parse(s);
	}

}
