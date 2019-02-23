package ru.afpf.letaem;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.*;

import static java.lang.Float.parseFloat;
import static javax.xml.bind.DatatypeConverter.parseInt;
;


public class WindguruParser extends TimerTask {
    ArrayList<Integer> windSpeedInt = new ArrayList<>();

    public ArrayList<Integer> getWindDirInt() {
        return windDirInt;
    }

    public ArrayList<Integer> getWeekdayInt() {
        return weekdayInt;
    }

    public ArrayList<Integer> getHourseInt() {
        return hourseInt;
    }

    public ArrayList<Integer> getSmernInt() {
        return smernInt;
    }

    public ArrayList<Float> getRainFloat() {
        return rainFloat;
    }

    ArrayList<Integer> windDirInt = new ArrayList<>();
    ArrayList<Integer> weekdayInt = new ArrayList<>();
    ArrayList<Integer> hourseInt = new ArrayList<>();
    ArrayList<Integer> smernInt = new ArrayList<>();
    ArrayList<Float> rainFloat = new ArrayList<>();


    public ArrayList<Integer> getWindSpeedInt() {
        return windSpeedInt;
    }

    public void run() {
        URL url;
        InputStream is = null;
        BufferedReader br;
        String line;

        try {
            url = new URL("https://old.windguru.cz/ru/index.php?sc=743917&sty=m_spot");
            is = url.openStream();  // throws an IOException
            br = new BufferedReader(new InputStreamReader(is));
            String allLine = null;
            while ((line = br.readLine()) != null) {
                allLine += line;
            }
            int tableStart = allLine.indexOf("var wg_fcst_tab_data_1");
            if (tableStart >0) {
                String resultStr1 = allLine.substring(tableStart + 1, allLine.indexOf("}}}}", tableStart));
       //         System.out.println(resultStr1);
                String winspd = resultStr1.substring(resultStr1.indexOf("WINDSPD\":[") + 10, resultStr1.indexOf("]", resultStr1.indexOf("WINDSPD\":[")));
                List<String> windSpeed = Arrays.asList(winspd.split(","));

                for (int i = 0; i < windSpeed.size(); i++) {
                    windSpeedInt.add((int)(parseFloat(windSpeed.get(i))+0.5));
                }

                String windir = resultStr1.substring(resultStr1.indexOf("WINDDIR\":[") + 10, resultStr1.indexOf("]", resultStr1.indexOf("WINDDIR\":[")));
                List<String> windDir = Arrays.asList(windir.split(","));

                for (int i = 0; i < windDir.size(); i++) {
                    windDirInt.add(parseInt(windDir.get(i)));
                }

                String weekday = resultStr1.substring(resultStr1.indexOf("hr_weekday\":[") + 13, resultStr1.indexOf("]", resultStr1.indexOf("hr_weekday\":[")));
                List<String> hrWeekday = Arrays.asList(weekday.split(","));

                for (int i = 0; i < hrWeekday.size(); i++) {
                    weekdayInt.add(parseInt(hrWeekday.get(i)));
                }

                String hours = resultStr1.substring(resultStr1.indexOf("hours\":[") + 8, resultStr1.indexOf("]", resultStr1.indexOf("hours\":[")));
                List<String> hoursS = Arrays.asList(hours.split(","));

                for (int i = 0; i < hoursS.size(); i++) {
                    hourseInt.add(parseInt(hoursS.get(i)));
                }
                String smern = resultStr1.substring(resultStr1.indexOf("SMERN\":[") + 8, resultStr1.indexOf("]", resultStr1.indexOf("SMERN\":[")));
                List<String> smernS = Arrays.asList(smern.split(","));

                for (int i = 0; i < smernS.size(); i++) {
                    String s = smernS.get(i);
                    s = s.replace("\"","");
                     smernInt.add(parseInt(s));
                }
                String rain = resultStr1.substring(resultStr1.indexOf("APCP\":[") + 7, resultStr1.indexOf("]", resultStr1.indexOf("APCP\":[")));
                List<String> rainn = Arrays.asList(rain.split(","));

                for (int i = 0; i < rainn.size(); i++) {
                    String s = rainn.get(i);
                    s = s.replace("null","0");
                    rainFloat.add(parseFloat(s));

                }

                System.out.println(windSpeedInt);
                System.out.println(windDirInt);
                System.out.println(weekdayInt);
                System.out.println(hourseInt);
                System.out.println(smernInt);
                System.out.println(rainFloat);
            }
//

            else System.out.println("Не найдена таблица");
        } catch (MalformedURLException mue) {
            mue.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                // nothing to see here
            }
        }
    }
}