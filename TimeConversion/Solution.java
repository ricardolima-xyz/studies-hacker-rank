package TimeConversion;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'timeConversion' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String timeConversion(String s) {
    // Write your code here
        String regex = "(\\d{2}):(\\d{2}):(\\d{2})(.{2})";
        // Backslash im Java Sourcecode verdoppeln!
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(s);
        if (matcher.matches()) {
            int hours = Integer.valueOf(matcher.group(1));
            int minutes = Integer.valueOf(matcher.group(2));
            int seconds = Integer.valueOf(matcher.group(3));
            String period = matcher.group(4);

            if (period.equalsIgnoreCase("PM") && hours < 12) 
            {
                hours = hours + 12;
            }
            if (period.equalsIgnoreCase("AM") && hours == 12)
            {
                hours = 0;
            }
            return String.format("%02d:%02d:%02d", hours, minutes, seconds);
        }
        else
            return "";

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.timeConversion(s);

        //bufferedWriter.write(result);
        //bufferedWriter.newLine();
        System.out.printf("%s\n", result);
        bufferedReader.close();
        //bufferedWriter.close();
    }
}