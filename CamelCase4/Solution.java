package CamelCase4;

import java.util.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        List<String> input = new ArrayList<String>();
        
        do {
            input.add(sc.nextLine());
        } while (sc.hasNextLine());
        sc.close();

        for (String line : input) {
            System.out.println(camelCase4(line));
        }
    }

    static String camelCase4(String input) {
        String regex = "([A-Za-z]);([A-Za-z]);(.*)";
        // Backslash im Java Sourcecode verdoppeln!
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            String method = matcher.group(1);
            String type = matcher.group(2);
            String parameter = matcher.group(3);

            if (method.equalsIgnoreCase("S"))
                return split(type, parameter);
            else if (method.equalsIgnoreCase("C"))
                return combine(type, parameter);
            else
                return null;
        }
        else
            return null;
    }

    static String split(String type, String parameter) {
        switch (type) {
            case "M":
                parameter = parameter.replace("()", "");
                parameter = parameter.substring(0, 1).toUpperCase() + parameter.substring(1);
                break;
            case "V":
                parameter = parameter.substring(0, 1).toUpperCase() + parameter.substring(1);
                break;
            default:
                break;
        }
        
        String regex = "[A-Z]{1}[a-z]*";
        // Backslash im Java Sourcecode verdoppeln!
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(parameter);
        List<String> pieces = new ArrayList<String>();

        while (matcher.find()) {
            pieces.add(matcher.group(0).toLowerCase());
        }
        return String.join(" ", pieces);
    }

    static String combine(String type, String parameter) {
        String[] pieces = parameter.split(" ");

        StringBuilder result = new StringBuilder();
        
        switch (type) {
            case "V": case "M":
                for (int i = 1; i < pieces.length; i++) {
                    pieces[i] = pieces[i].substring(0, 1).toUpperCase() + pieces[i].substring(1);
                }                
                break;
            case "C":
                for (int i = 0; i < pieces.length; i++) {
                    pieces[i] = pieces[i].substring(0, 1).toUpperCase() + pieces[i].substring(1);
                }
            default:
                break;
        }

        for (String piece : pieces) {
            result.append(piece);
        }
        if (type.equals("M"))
            result.append("()");

        return result.toString();
    }
}
