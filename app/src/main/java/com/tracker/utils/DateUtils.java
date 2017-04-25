package com.tracker.utils;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {
    private static String dateKey = null;
    private static Calendar date;

    public static String getDateKey() {
        if (dateKey != null) {
            return dateKey;
        }
        Calendar calendar = Calendar.getInstance();
        int date = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        dateKey = date + "-" + month + "-" + year;
        return dateKey;
    }

    public String getDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        dateFormat.format(cal.getTime());
        return dateFormat.toString();
    }

    public static void setDate(Calendar calendar) {
        date = calendar;
        int date = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH);
        int year = calendar.get(Calendar.YEAR);
        dateKey = date + "_" + month + "" + year;
    }

}
