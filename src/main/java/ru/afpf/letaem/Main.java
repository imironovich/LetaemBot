package ru.afpf.letaem;

import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;


public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();
        Calendar dateWindguru = Calendar.getInstance();
        dateWindguru.set(Calendar.HOUR_OF_DAY, 8);
        dateWindguru.set(Calendar.MINUTE, 00);
        dateWindguru.set(Calendar.SECOND, 0);
        dateWindguru.set(Calendar.MILLISECOND, 0);
        WindguruParser wp = new WindguruParser();
        Bot bot = new Bot();
        timer.schedule(wp, dateWindguru.getTime(), 1000 * 60 * 60 * 24); //dayli take weather forecast from windguru.cz

        Calendar datePrint = Calendar.getInstance();
        datePrint.set(Calendar.HOUR_OF_DAY, 8);
        datePrint.set(Calendar.MINUTE, 02);
        datePrint.set(Calendar.SECOND, 0);
        datePrint.set(Calendar.MILLISECOND, 0);
        TimerTask Show = new ConditionsSuitable(bot, wp.getWindSpeedInt(),wp.getWindDirInt(),wp.getWeekdayInt(),wp.getSmernInt(),wp.getRainFloat(),wp.getHourseInt());
        timer.schedule(Show, datePrint.getTime(), 1000 * 60 * 60 * 24); // dayli send mess about conditions suitable on Jelohovo and Voronovo hills
    }
}

