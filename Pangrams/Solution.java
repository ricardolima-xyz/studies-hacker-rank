package Pangrams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Result {

    /*
     * Complete the 'pangrams' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String pangrams(String s) {
    // Write your code here
        boolean[] alphabet = new boolean[26];
        
        String uppercase = s.toUpperCase();
        for (int i = 0; i < uppercase.length(); i++) {
            char x = uppercase.charAt(i);
            if (x == ' ') continue;
            int position = (int) x - (int)'A';
            alphabet[position] = true;
        }
        
        int sum = 0;
        for (int i = 0; i < 26; i++) {
            if (alphabet[i]) sum++;
        }
        if (sum == 26) return "pangram";
        else return "not pangram";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out)); //new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = Result.pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
