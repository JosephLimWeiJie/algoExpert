package Easy;

import java.util.*;

class Program {

    public static int[] findThreeLargestNumbers(int[] array) {

        // Time:  O(n log (n))
        // Space: O(h) where h depends on the height of the max-heap

        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < array.length; i++) {
            pq.add(array[i]);
        }

        int[] ans = new int[3];
        for (int j = 2; j > 0; j--) {
            int ele = pq.poll();
            ans[j] = ele;
        }

        return ans;
    }

}

