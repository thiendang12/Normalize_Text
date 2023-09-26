package service;

import java.io.File;
import repository.TextRepository;

public class NormalizeTextService {

    private static final String BASE_PATH = new File("").getAbsolutePath();
    private static final String READ_PATH = "\\src\\data\\input.txt";
    private static final String WRITE_PATH = "\\src\\data\\output.txt";
    private TextRepository repository;

    public NormalizeTextService() {
        repository = new TextRepository();

    }

    public boolean formatText() {
        String originText = repository.readFile(BASE_PATH + READ_PATH);
        originText = formatOneSpace(originText);
        originText = formatSpecialCharacters(originText);
        originText = afterDotUpperCase(originText);
        originText = noSpaceQuotes(originText);
        originText = firstUpercase(originText);
        originText = lastAddDot(originText);
        return repository.savefile(BASE_PATH + WRITE_PATH, originText);

    }

    public String formatOneSpaceSpecial(String line, String character) {
        StringBuffer stringBuffer = new StringBuffer();
        String[] strings = line.split("\\s*\\" + character + "\\s*");
        //appen every word and character special distance is one space
        for (String oneWord : strings) {
            stringBuffer.append(oneWord + " " + character);
            stringBuffer.append(" ");
        }

        String result = stringBuffer.toString().trim();
        result = result.subSequence(0, result.length() - 1).toString();

        return result;
    }

    public String formatOneSpace(String line) {
        line = line.toLowerCase();
        line = line.replaceAll("\\s+", " ");
        line = formatOneSpaceSpecial(line, ".");
        line = formatOneSpaceSpecial(line, ",");
        line = formatOneSpaceSpecial(line, ":");
        line = formatOneSpaceSpecial(line, "\"");
        return line.trim();
    }

    public static String formatSpecialCharacters(String line) {
        StringBuffer stringBuffer = new StringBuffer(line);
        //check from first to last before .,:; then delete
        for (int i = 0; i < stringBuffer.length() - 1; i++) {
            if (stringBuffer.charAt(i) == ' '
                    && stringBuffer.charAt(i + 1) == '.'
                    || stringBuffer.charAt(i + 1) == ','
                    || stringBuffer.charAt(i + 1) == ':') {
                stringBuffer.deleteCharAt(i);
            }
        }
        return stringBuffer.toString().trim();
    }

    public String afterDotUpperCase(String line) {
        StringBuffer stringBuffer = new StringBuffer(line);
        int lengthLine = stringBuffer.length();
        for (int i = 0; i < lengthLine - 2; i++) {
            if (stringBuffer.charAt(i) == '.') {
                char afterDot = stringBuffer.charAt(i + 2);
                stringBuffer.setCharAt(i + 2, Character.toUpperCase(afterDot));
            }
        }
        return stringBuffer.toString().trim();
    }

    public String noSpaceQuotes(String line) {
        int count = 0;
        StringBuffer stringBuffer = new StringBuffer(line);
        for (int i = 0; i < stringBuffer.length(); i++) {
            if (stringBuffer.charAt(i) == '"' && count % 2 == 0) {
                stringBuffer.deleteCharAt(i + 1);
                count++;
            } else if (stringBuffer.charAt(i) == '"' && count % 2 == 1
                    && i != 0) {
                stringBuffer.deleteCharAt(i - 1);
                count++;
            }
        }
        return stringBuffer.toString().trim();
    }

    public String firstUpercase(String line) {
        line = line.substring(3);
        StringBuffer stringBuffer = new StringBuffer(line);
        for (int i = 0; i < line.length(); i++) {
            if (Character.isLetter(line.charAt(i))) {
                stringBuffer.setCharAt(i, Character.toUpperCase(line.charAt(i)));
                break;
            }
        }
        return stringBuffer.toString().trim();
    }

    public String lastAddDot(String line) {
        if (line.endsWith(".")) {
            return line;
        } else {
            return line + ".";
        }
    }
}
