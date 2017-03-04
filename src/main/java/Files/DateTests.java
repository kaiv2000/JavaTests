package Files;

import java.util.Calendar;
import java.util.Date;

public class DateTests
{
    public static void main(String[] args) {
        DateTests s = new DateTests();
        s.go();
    }

    void go()
    {
        String formatedData = String.format("%ta, %<tA, %<tB, %<td" , new Date());
        System.out.println(formatedData);

        Calendar myCalendar = Calendar.getInstance();
        myCalendar.set(2018, 0, 1, 10, 12);
        long day = myCalendar.getTimeInMillis();
        System.out.println(myCalendar.get(myCalendar.HOUR_OF_DAY));

        myCalendar.add(myCalendar.DATE, 55);
        System.out.println(myCalendar.getTime());
    }
}