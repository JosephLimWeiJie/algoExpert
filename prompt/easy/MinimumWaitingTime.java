package prompt.easy;

import java.util.*;

public class MinimumWaitingTime {
    
    public static int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);

        int total = 0;
        int runningSum = 0;
        for (int i = 1; i < queries.length; i++) {
            runningSum += queries[i - 1];
            total += runningSum;
        }

        return total;
    }

    public static void main(String[] args) {
        int[] queries = new int[] {3, 2, 1, 2, 6};
        int expected = 17;
        var actual = minimumWaitingTime(queries);
        System.out.println(actual);
        System.out.println(actual == expected);
    }
}
