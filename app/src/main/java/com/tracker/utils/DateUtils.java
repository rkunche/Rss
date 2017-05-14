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

    public static void setDate(String key) {
//        date = calendar;
//        int date = calendar.get(Calendar.DAY_OF_MONTH);
//        int month = calendar.get(Calendar.MONTH);
//        int year = calendar.get(Calendar.YEAR);
//        dateKey = date + "_" + month + "" + year;
        dateKey = key;
    }

    public static int getWeek(int date)
    {
        if(date <= 7)
        {
            return 1;
        }
        if(date <= 14)
        {
            return 2;
        }
        if(date <= 21)
        {
            return 3;
        }
        return 4;
    }

    public static String getType(String type,int i)
    {
        if(type.equalsIgnoreCase("weekly"))
        {
            switch (i)
            {
                case 1: return "First week";
                case 2: return "Second week";
                case 3: return "Third week";
                case 4: return "Fourth week";
            }

        } else {
            switch (i) {
                case 1:
                    return "JAN";
                case 2:
                    return "FEB";
                case 3:
                    return "MAR";
                case 4:
                    return "APR";
                case 5:
                    return "MAY";
                case 6:
                    return "JUN";
                case 7:
                    return "JUL";
                case 8:
                    return "AUG";
                case 9:
                    return "SEP";
                case 10:
                    return "OCT";
                case 11:
                    return "NOV";
                case 12:
                    return "DEC";
            }
        }
        return "";
    }

}
