package com.einar.supervision.utils;

import java.util.Calendar;
import java.util.Date;

public abstract class TimeManager {

	private static void purge(Calendar calendar) {
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
	}

	public static long getTodayInMillis() {
		return getDateInMillis(new Date());
	}

	public static long getTomorrowInMillis() {
		return getNextDateInMillis(new Date());
	}

	public static long getYesterdayInMillis() {
		return getPreviousDateInMillis(new Date());
	}

	public static long getDateInMillis(long date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date);
		purge(calendar);

		return calendar.getTimeInMillis();
	}
	
	public static long getNextDateInMillis(long date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(date);
		calendar.add(Calendar.DATE, 1);
		purge(calendar);

		return calendar.getTimeInMillis();
	}
	
	public static long getDateInMillis(Date d) {
		return getDateInMillis(d.getTime());
	}

	public static long getNextDateInMillis(Date d) {
		return getNextDateInMillis(d.getTime());
	}

	public static long getPreviousDateInMillis(Date d) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(d);
		calendar.add(Calendar.DATE, -1);
		purge(calendar);

		return calendar.getTimeInMillis();
	}
}
