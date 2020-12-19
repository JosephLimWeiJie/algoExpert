package Easy;

import java.util.*;

class Program {

    public static int[] findThreeLargestNumbers(int[] array) {

        // Time:  O(n)
        // Space: O(1)
        int[] ans = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int i = 0; i < array.length; i++) {
            ans = updateAns(ans, array[i]);
        }

        return ans;
    }

    public static int[] updateAns(int[] ans, int num) {
        if (ans[2] == Integer.MIN_VALUE || num > ans[2]) {
            ans = shiftNumsInAns(ans, num,2);
        } else if (ans[1] == Integer.MIN_VALUE || num > ans[1]) {
            ans = shiftNumsInAns(ans, num, 1);
        } else if (ans[0] == Integer.MIN_VALUE || num > ans[0]) {
            ans = shiftNumsInAns(ans, num, 0);
        }

        return ans;
    }

    public static int[] shiftNumsInAns(int[] ans, int num, int startIdx) {
        for (int i = 0; i < startIdx; i++) {
            ans[i] = ans[i + 1];
        }

        ans[startIdx] = num;
        return ans;
    }


    /** My alternative easy solution but slower. */
    public static int[] findThreeLargestNumbersAlt(int[] array) {

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

