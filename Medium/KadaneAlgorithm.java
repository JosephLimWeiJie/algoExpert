package Medium;

import java.util.*;

class Program {

    public static int kadanesAlgorithm(int[] array) {

        // Time:  O(n)
        // Space: O(1)

        int currRunningSum = 0;
        int maxSum = array[0];

        for (int i = 0; i < array.length; i++) {
            currRunningSum = Math.max(currRunningSum + array[i], array[i]);
            maxSum = Math.max(currRunningSum, maxSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        System.out.println(kadanesAlgorithm(arr));
    }
}
