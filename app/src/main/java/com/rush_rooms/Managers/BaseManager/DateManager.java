package com.VB_Healthtech_Pvt_Ltd.Vaccine_Buddy.ui.view.Managers.BaseManager;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class DateManager {
    public static final String kDateFormatDefault                                   = "MM/dd/yyyy";
    private static final String kDateFormatMMMDDYYYY                                 = "MMM/dd/yyyy";
    public static final String kDateFormatDDMMYYYY                                  = "dd/MM/yyyy";
    public static final String kDateFormatYYYYMMDD                                   ="yyyy/mm/dd";

    private static final String kDateFormatEEEE                                      = "EEEE";
    private static final String kTimeFormatHHMMA                                     = "hh:mm a";

    /**calender Unit Enum*/
    public enum CalenderUnit {
        pastDay("Days before yesterday"),
        yesterday("Yesterday"),
        today("Today"),
        tomorrow("Tomorrow"),
        week("Week"),
        month("Month"),
        year("Year");

        private String value;
        CalenderUnit (String value) {
            this.value = value;
        }

        /**To get string value of corresponding emum*/
        public String getValue()    {
            return this.value;
        }

        public static  CalenderUnit getCalenderUnit(String value)   {
            for (CalenderUnit unit : CalenderUnit.values()) {
                if(unit.value.equals(value))    {
                    return unit;
                }
            }
            return yesterday;
        }
    }

    /**************************************Date Time Conversion********************************************/
    /**return the current UNIX timestamp in seconds in Long Object*/
    public static Long getCurrentTimestamp () {
        return (System.currentTimeMillis());
    }



    /**Convert timestamp to string time. to show on UI. Timestamp must be in seconds*/
    public static String dispalyValue(String timestamp)    {

        @SuppressLint("SimpleDateFormat") SimpleDateFormat dateFormat = new SimpleDateFormat(kDateFormatMMMDDYYYY);
        dateFormat.setTimeZone(TimeZone.getDefault());

        @SuppressLint("SimpleDateFormat") SimpleDateFormat timeFormat = new SimpleDateFormat(kTimeFormatHHMMA);
        timeFormat.setTimeZone(TimeZone.getDefault());

        Date fromDate       = new Date(Long.valueOf(timestamp));
        Date currentDate    = Calendar.getInstance().getTime();

        Long days = numberOfDaysBetween(fromDate, currentDate);

        if(days == 0)   {
            return timeFormat.format(fromDate);
        }
        else if(days == 1)  {
            return CalenderUnit.yesterday.getValue();
        }
//        else if(days > 1 && days <= 7)  {
//            SimpleDateFormat dayFormat = new SimpleDateFormat(kDateFormatEEEE);
//            dayFormat.setTimeZone(TimeZone.getDefault());
//            return dayFormat.format(fromDate);
//        }
        else    {
            return dateFormat.format(fromDate);
        }
    }

    /**Return the Calender unit between fromDate and toDate*/
    public static String calenderUnitBetween(Date fromDate, Date toDate)    {
        Long days = numberOfDaysBetween(fromDate, toDate);

        if (days < -1)  {
            return CalenderUnit.pastDay.getValue();
        }
        else if (days == -1)    {
            return CalenderUnit.yesterday.getValue();
        }
        else if(days == 0) {
            return CalenderUnit.today.getValue();
        }
        else if(days == 1) {
            return CalenderUnit.yesterday.getValue();
        }
        else if(days == 2)  {
            return CalenderUnit.tomorrow.getValue();
        }
        else if (days > 2 && days <= 7) {
            return CalenderUnit.week.getValue();
        }
        else if (days > 7 && days <=30)    {
            return CalenderUnit.month.getValue();
        }
        else if (days > 30 && days <= 365)   {
            return CalenderUnit.year.getValue();
        }
        else {
            return CalenderUnit.yesterday.getValue();
        }
    }

    /**returns the number of days from fromDate to toDate.
     * (-)ve value shows fromDate is newer than toDate
     * (+)ve value shows fromDate is before than toDate*/
    public static Long numberOfDaysBetween(Date fromDate, Date toDate)   {
        long diff = toDate.getTime() - fromDate.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }
    /**************************************Date Time Conversion********************************************/
}