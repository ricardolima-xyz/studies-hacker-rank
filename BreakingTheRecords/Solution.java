package BreakingTheRecords;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {
    // Write your code here
        int currentMostPoints = scores.get(0);
        int currentLeastPoints = scores.get(0);
        int mostPointsRecords = 0;
        int leastPointsRecords = 0;

        for (int score : scores) {
            if (score < currentLeastPoints) {
                currentLeastPoints = score;
                leastPointsRecords++;
            }
            if (score > currentMostPoints) {
                currentMostPoints = score;
                mostPointsRecords++;
            }
        }

        return Arrays.asList(new Integer[]{mostPointsRecords, leastPointsRecords});
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out)); //new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        /* int n =  */Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> scores = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.breakingRecords(scores);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining(" "))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}

