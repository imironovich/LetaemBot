package ru.afpf.letaem;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;


public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();
        Calendar dateWindguru = Calendar.getInstance();
        dateWindguru.set(Calendar.HOUR, 13);
        dateWindguru.set(Calendar.MINUTE, 35);
        dateWindguru.set(Calendar.SECOND, 0);
        dateWindguru.set(Calendar.MILLISECOND, 0);
        WindguruParser wp = new WindguruParser();
        timer.schedule(wp, dateWindguru.getTime(), 1000 * 60 * 60 * 24 * 7);

        Calendar datePrint = Calendar.getInstance();
        datePrint.set(Calendar.HOUR, 13);
        datePrint.set(Calendar.MINUTE, 37);
        datePrint.set(Calendar.SECOND, 0);
        datePrint.set(Calendar.MILLISECOND, 0);
        TimerTask Show = new ConditionsSuitable(wp.getWindSpeedInt(),wp.getWindDirInt(),wp.getWeekdayInt(),wp.getSmernInt(),wp.getRainFloat(),wp.getHourseInt());
        timer.schedule(Show, datePrint.getTime(), 1000 * 60 * 60 * 24 * 7);
    }
}

