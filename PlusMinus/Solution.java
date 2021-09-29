package PlusMinus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Result {

    /*
     * Complete the 'plusMinus' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void plusMinus(List<Integer> arr) {
    // Write your code here
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;
        int generalCount = 0;
        for (Integer i : arr) {
            if (i > 0) positiveCount++;
            else if (i < 0) negativeCount++;
            else zeroCount++;
            generalCount++;
        }
        System.out.printf("%.6f\n", (float)positiveCount/generalCount);
        System.out.printf("%.6f\n", (float)negativeCount/generalCount);
        System.out.printf("%.6f\n", (float)zeroCount/generalCount);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.plusMinus(arr);

        bufferedReader.close();
    }
}
