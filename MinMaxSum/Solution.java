package MinMaxSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Result {

    /*
     * Complete the 'miniMaxSum' function below.
     *
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static void miniMaxSum(List<Integer> arr) {
    // Write your code here
        List<Long> sums = new ArrayList<>();
        // Assuming arr has 5 elements
        sums.add((long)arr.get(1) + arr.get(2) + arr.get(3) + arr.get(4));
        sums.add((long)arr.get(0) + arr.get(2) + arr.get(3) + arr.get(4));
        sums.add((long)arr.get(0) + arr.get(1) + arr.get(3) + arr.get(4));
        sums.add((long)arr.get(0) + arr.get(1) + arr.get(2) + arr.get(4));
        sums.add((long)arr.get(0) + arr.get(1) + arr.get(2) + arr.get(3));
        Collections.sort(sums);
        System.out.printf("%d %d\n", sums.get(0), sums.get(4));
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] arrTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        List<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            int arrItem = Integer.parseInt(arrTemp[i]);
            arr.add(arrItem);
        }

        Result.miniMaxSum(arr);

        bufferedReader.close();
    }
}
