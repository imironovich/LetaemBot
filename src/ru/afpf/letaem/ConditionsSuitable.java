package ru.afpf.letaem;

import java.util.ArrayList;
import java.util.TimerTask;

class ConditionsSuitable extends TimerTask {
    ArrayList<Integer> windSpeedInt;
    ArrayList<Integer> windDirInt;
    ArrayList<Integer> weekdayInt;
    ArrayList<Integer> smernInt;
    ArrayList<Float> rainFloat;
    ConditionsSuitable(ArrayList<Integer> windSpeedInt, ArrayList<Integer> windDirInt, ArrayList<Integer> weekdayInt, ArrayList<Integer> smernInt, ArrayList<Float> rainFloat, ArrayList<Integer> HourseInt){
     this.windSpeedInt = windSpeedInt;
     this.windDirInt = windDirInt;
     this.weekdayInt = weekdayInt;
     this.smernInt = smernInt;
     this.rainFloat =  rainFloat;
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
                letnaya = (rainFloat.get(i) == 0)&&(rainFloat.get(i + 1) == 0)&&(windSpeedInt.get(i) > 4 | 8 > windSpeedInt.get(i))&&(windSpeedInt.get(i + 1) > 4 | 8 > windSpeedInt.get(i + 1))&&(smernInt.get(i) < 10)&&(smernInt.get(i + 1) < 10);
                if ((letnaya && 200 < windDirInt.get(i) && windDirInt.get(i) > 160 && 200 < windDirInt.get(i + 1) && windDirInt.get(i) > 160))
                    System.out.println(" Летная погода " + days.get(weekdayInt.get(i)) + " утром в Желохово");
                if ((letnaya && 290 < windDirInt.get(i) && windDirInt.get(i) > 200 && 290 < windDirInt.get(i + 1) && windDirInt.get(i) > 250))
                    System.out.println("Летная погода " + days.get(weekdayInt.get(i)) + " утром в Вороново");
                else nomorning = true;

            }

            for (int i = 13; i < 8 * 8; i = i + 8) {
                letnaya = (rainFloat.get(i) == 0)&&(rainFloat.get(i + 1) == 0)&&(windSpeedInt.get(i) > 4 | 8 > windSpeedInt.get(i))&&(windSpeedInt.get(i + 1) > 4 | 8 > windSpeedInt.get(i + 1))&&(smernInt.get(i) < 10)&&(smernInt.get(i + 1) < 10);
                if ((letnaya && 200 < windDirInt.get(i) && windDirInt.get(i) > 160 && 200 < windDirInt.get(i + 1) && windDirInt.get(i) > 160))
                    System.out.println(" Летная погода " + days.get(weekdayInt.get(i)) + " утром в Желохово");
                if ((letnaya && 290 < windDirInt.get(i) && windDirInt.get(i) > 200 && 290 < windDirInt.get(i + 1) && windDirInt.get(i) > 250))
                    System.out.println("Летная погода " + days.get(weekdayInt.get(i)) + " утром в Вороново");
                else noday = true;
            }

            for (int i = 14; i < 8 * 8; i = i + 8) {
                letnaya = (rainFloat.get(i) == 0)&&(smernInt.get(i + 1) < 10)&&(windSpeedInt.get(i) > 4 | 8 > windSpeedInt.get(i))&&(windSpeedInt.get(i + 1) > 4 | 8 > windSpeedInt.get(i + 1))&&(smernInt.get(i) < 10)&&(smernInt.get(i + 1) < 10);
                if ((letnaya && 200 < windDirInt.get(i) && windDirInt.get(i) > 160 && 200 < windDirInt.get(i + 1) && windDirInt.get(i) > 160))
                    System.out.println(" Летная погода " + days.get(weekdayInt.get(i)) + " утром в Желохово");
                if ((letnaya && 290 < windDirInt.get(i) && windDirInt.get(i) > 200 && 290 < windDirInt.get(i + 1) && windDirInt.get(i) > 250))
                    System.out.println("Летная погода " + days.get(weekdayInt.get(i)) + " утром в Вороново");
                else noevening = true;
            }

            if (nomorning && noday && noevening) System.out.println("Ближайшую неделю лётных дней на наших горках не предвидится :-(");
        }
    }