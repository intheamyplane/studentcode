package com.techelevator;

public class AlarmClock {

    public static final String TEN_AM = "10:00";
    public static final String SEVEN_AM = "7:00";
    public static final String OFF = "off";

    /* Given a day of the week encoded as 0=Sun, 1=Mon, 2=Tue, ..., 6=Sat, and a boolean
            indicating if we are on vacation, return a string of the form "7:00" indicating when
            the alarm clock should ring. Weekdays, the alarm should be "7:00" and on the weekend it
            should be "10:00". Unless we are on vacation -- then on weekdays it should be "10:00"
            and weekends it should be "off".

            wakeUp(1, false) → "7:00"
            wakeUp(5, false) → "7:00"
            wakeUp(0, false) → "10:00"
            */
    public String wakeUp(int day, boolean vacation) {
        boolean isWeekend = day == 0 || day == 6;  // 2 paths
        if (vacation)  { // 2 paths
            return isWeekend ? OFF : TEN_AM;  // 2 paths
        } else {
            return isWeekend ? TEN_AM : SEVEN_AM; // 2 paths
        }
    }

}
