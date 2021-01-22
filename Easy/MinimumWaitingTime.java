package Easy;

import java.util.*;

class Program {

    public static int minimumWaitingTime(int[] queries) {

        // Time:  O(n * log(n))
        // Space: O(1)

        Arrays.sort(queries);
        int waitingTime = 0;
        int prev = 0;

        for (int i = 0; i < queries.length - 1; i++) {
            waitingTime += (queries[i] + prev);
            prev += (queries[i]);
        }

        return waitingTime;
    }

    public static void main(String[] args) {
        int[] queries = new int[] {3, 2, 1, 2, 6};
        System.out.println(minimumWaitingTime(queries));
    }
}

