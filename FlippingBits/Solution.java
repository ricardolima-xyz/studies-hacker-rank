package FlippingBits;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Result {

    /*
     * Complete the 'flippingBits' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long flippingBits(long n) {
    // Write your code here
        long result = 0;
        int[] binary = new int[32];
        for (int i = 0; i < 32; i++) {
            binary[i] = (int)(n % 2);
            if (binary[i] == 1) binary[i] = 0;
            else if (binary[i] == 0) binary[i] = 1;
            n = n / 2;
        }
        for (int i = 0; i < 32; i++) {
            result += binary[i] * (long) Math.pow(2, i);
        }
        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out)); //new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        for (int qItr = 0; qItr < q; qItr++) {
            long n = Long.parseLong(bufferedReader.readLine().trim());

            long result = Result.flippingBits(n);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
