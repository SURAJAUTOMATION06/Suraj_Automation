package org.example;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Calendarprogram {
    public static void main(String[] args) {
        Calendar cl=  Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy hh:mm:ss");
        System.out.println(sdf.format(cl.getTime()));
        System.out.println(cl.get(Calendar.AM_PM));
        System.out.println(cl.get(Calendar.DATE));
    }
}
// ======================= Calendar Class Methods =======================

// Calendar.getInstance()        -> Creates and returns the current date and time.
// get(Calendar.DATE)            -> Returns the current day of the month (1-31).
// get(Calendar.DAY_OF_MONTH)    -> Returns the day of the month (1-31).
// get(Calendar.DAY_OF_WEEK)     -> Returns the day of the week (1=Sunday, 2=Monday, ..., 7=Saturday).
// get(Calendar.DAY_OF_YEAR)     -> Returns the day number in the current year (1-365/366).
// get(Calendar.MONTH)           -> Returns the current month (0=January, 11=December).
// get(Calendar.YEAR)            -> Returns the current year.
// get(Calendar.HOUR)            -> Returns the hour in 12-hour format (0-11).
// get(Calendar.HOUR_OF_DAY)     -> Returns the hour in 24-hour format (0-23).
// get(Calendar.MINUTE)          -> Returns the current minute (0-59).
// get(Calendar.SECOND)          -> Returns the current second (0-59).
// get(Calendar.MILLISECOND)     -> Returns the current millisecond (0-999).
// get(Calendar.AM_PM)           -> Returns AM (0) or PM (1).
// getTime()                     -> Returns the complete Date object.
// set(field, value)             -> Sets a specific date or time field.
// add(field, value)             -> Adds or subtracts days, months, years, etc.
// roll(field, value)            -> Changes a field without affecting larger fields.
// before(calendar)              -> Checks if one Calendar date is before another.
// after(calendar)               -> Checks if one Calendar date is after another.
// compareTo(calendar)           -> Compares two Calendar objects.
// clear()                       -> Clears all date and time values.
// clone()                       -> Creates a copy of the Calendar object.
// getActualMaximum(field)       -> Returns the maximum valid value for a field.
// getActualMinimum(field)       -> Returns the minimum valid value for a field.
// isLeapYear()                  -> Not available in Calendar (available in GregorianCalendar).