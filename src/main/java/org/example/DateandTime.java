package org.example;
import java.text.SimpleDateFormat;
import java.util.Date; // Util = package and Date = class
// This one is use for the current Date and Time
//This Actual use of this is to
public class DateandTime {
    public static void main(String[] args) {
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
        SimpleDateFormat sd = new SimpleDateFormat("d/M/yyyy hh:mm:ss");
        //Goes in Format wise
        System.out.println(sdf.format(d));
        System.out.println(sd.format(d));
        System.out.println(d);
        //Goes in Format wise
    }
}
// d      -> Day (1-31)
// dd     -> Day with leading zero (01-31)
// M      -> Month (1-12)
// MM     -> Month with leading zero (01-12)
// MMM    -> Short month name (Jan, Feb, Mar)
// MMMM   -> Full month name (January, February)
// yy     -> 2-digit year (26)
// yyyy   -> 4-digit year (2026)
// H      -> Hour in 24-hour format (0-23)
// HH     -> Hour in 24-hour format with leading zero (00-23)
// h      -> Hour in 12-hour format (1-12)
// hh     -> Hour in 12-hour format with leading zero (01-12)
// m      -> Minutes
// mm     -> Minutes with leading zero
// s      -> Seconds
// ss     -> Seconds with leading zero
// a      -> AM/PM
// E      -> Short day name (Mon, Tue)
// EEEE   -> Full day name (Monday, Tuesday)
