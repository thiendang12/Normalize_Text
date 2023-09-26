package repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

public class TextRepository {

    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";

    public boolean savefile(String path, String text) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(path));
            bw.write(text);

        } catch (IOException e) {
            System.out.println("Error When save file !!!");
            return false;
        } finally {
            try {
                bw.flush();
                bw.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                return false;
            }
        }
        return true;
    }

    public static Calendar toCalendar(String str) {
        Calendar c = Calendar.getInstance();
        DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        Date d = null;
        try {
            d = f.parse(str);
        } catch (ParseException ex) {

        }
        c.setTime(d);
        return c;
    }

    public static String readFile(String path) {
        String result = "";
        BufferedReader br = null;
        try {
            String line;
            br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                result = result.concat(line);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return result;
    }

    public static List<String> parseCsvLine(String csvLine) {
        List<String> result = new ArrayList<>();
        if (csvLine != null) {
            String[] splitData = csvLine.split(COMMA_DELIMITER);
            for (int i = 0; i < splitData.length; i++) {
                result.add(splitData[i]);
            }
        }
        return result;
    }
}
