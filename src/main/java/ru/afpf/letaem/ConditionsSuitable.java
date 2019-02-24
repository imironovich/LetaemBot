package ru.afpf.letaem;

import java.util.ArrayList;
import java.util.TimerTask;

class ConditionsSuitable extends TimerTask {
    Bot bot;
    ArrayList<Integer> windSpeedInt;
    ArrayList<Integer> windDirInt;
    ArrayList<Integer> weekdayInt;
    ArrayList<Integer> smernInt;
    ArrayList<Float> rainFloat;
    ConditionsSuitable(Bot bot, ArrayList<Integer> windSpeedInt, ArrayList<Integer> windDirInt, ArrayList<Integer> weekdayInt, ArrayList<Integer> smernInt, ArrayList<Float> rainFloat, ArrayList<Integer> HourseInt){
     this.windSpeedInt = windSpeedInt;
     this.windDirInt = windDirInt;
     this.weekdayInt = weekdayInt;
     this.smernInt = smernInt;
     this.rainFloat =  rainFloat;
     this.bot = bot;
    }
        public void run () {
            ArrayList<String> days = new ArrayList<>();
            days.add("в понедельник");
            days.add("во вторник");
            days.add("в среду");
            days.add("в четверг");
            days.add("в пятницу");
            days.add("в субботу");
            days.add("в воскресенье");

            boolean letnaya;
            boolean nomorning = false;
            boolean noday = false;
            boolean noevening = false;

            for (int i = 12; i < 8 * 8; i = i + 8) {
                letnaya = (rainFloat.get(i) == 0)&&(rainFloat.get(i + 1) == 0)&&(windSpeedInt.get(i) > 8 | 16 > windSpeedInt.get(i))&&(windSpeedInt.get(i + 1) > 8 | 16 > windSpeedInt.get(i + 1))&&(smernInt.get(i) < 20)&&(smernInt.get(i + 1) < 20);
                if ((letnaya && 200 < windDirInt.get(i) && windDirInt.get(i) > 160 && 200 < windDirInt.get(i + 1) && windDirInt.get(i) > 160)){
                   System.out.println(" Летная погода " + days.get(weekdayInt.get(i)) + " утром в Желохово");
                   bot.sendMess(192211047, " Летная погода " + days.get(weekdayInt.get(i)) + " утром в Желохово");}
                if ((letnaya && 290 < windDirInt.get(i) && windDirInt.get(i) > 200 && 290 < windDirInt.get(i + 1) && windDirInt.get(i) > 250)){
                   System.out.println("Летная погода " + days.get(weekdayInt.get(i)) + " утром в Вороново");
                   bot.sendMess(192211047, " Летная погода " + days.get(weekdayInt.get(i)) + " утром в Вороново");}
                else nomorning = false;

            }

            for (int i = 13; i < 8 * 8; i = i + 8) {
                letnaya = (rainFloat.get(i) == 0)&&(rainFloat.get(i + 1) == 0)&&(windSpeedInt.get(i) > 8 | 16 > windSpeedInt.get(i))&&(windSpeedInt.get(i + 1) > 8 | 16 > windSpeedInt.get(i + 1))&&(smernInt.get(i) < 20)&&(smernInt.get(i + 1) < 20);
                if ((letnaya && 200 < windDirInt.get(i) && windDirInt.get(i) > 160 && 200 < windDirInt.get(i + 1) && windDirInt.get(i) > 160)){
                    System.out.println(" Летная погода " + days.get(weekdayInt.get(i)) + " днём в Желохово");
                    bot.sendMess(192211047, " Летная погода " + days.get(weekdayInt.get(i)) + " днём в Желохово");}
                if ((letnaya && 290 < windDirInt.get(i) && windDirInt.get(i) > 200 && 290 < windDirInt.get(i + 1) && windDirInt.get(i) > 250)){
                    System.out.println("Летная погода " + days.get(weekdayInt.get(i)) + " днём в Вороново");
                    bot.sendMess(192211047, " Летная погода " + days.get(weekdayInt.get(i)) + " днём в Вороново");}
                else noday = false;
            }

            for (int i = 14; i < 8 * 8; i = i + 8) {
                letnaya = (rainFloat.get(i) == 0)&&(rainFloat.get(i + 1) == 0)&&(windSpeedInt.get(i) > 8 | 16 > windSpeedInt.get(i))&&(windSpeedInt.get(i + 1) > 8 |16 > windSpeedInt.get(i + 1))&&(smernInt.get(i) < 20)&&(smernInt.get(i + 1) < 20);
                if ((letnaya && 200 < windDirInt.get(i) && windDirInt.get(i) > 160 && 200 < windDirInt.get(i + 1) && windDirInt.get(i) > 160)){
                    System.out.println(" Летная погода " + days.get(weekdayInt.get(i)) + " после обеда в Желохово");
                    bot.sendMess(192211047, " Летная погода " + days.get(weekdayInt.get(i)) + " после обеда в Желохово");}
                if ((letnaya && 290 < windDirInt.get(i) && windDirInt.get(i) > 200 && 290 < windDirInt.get(i + 1) && windDirInt.get(i) > 250)){
                    System.out.println("Летная погода " + days.get(weekdayInt.get(i)) + " после обеда в Вороново");
                    bot.sendMess(192211047, " Летная погода " + days.get(weekdayInt.get(i)) + " после обеда в Вороново");}
                else noevening = false;
            }

            if (nomorning && noday && noevening){
                System.out.println("Ближайшую неделю лётных дней на наших горках не предвидится :-(");
                bot.sendMess(192211047, "Ближайшую неделю лётных дней на наших горках не предвидится :-(");
            }
        }
    }