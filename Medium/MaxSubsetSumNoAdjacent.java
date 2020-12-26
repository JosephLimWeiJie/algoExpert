package Medium;

import java.util.*;

class Program {

    public static int maxSubsetSumNoAdjacent(int[] array) {

        // Time:  O(n)
        // Space: O(1)

        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        } else {
            int first = array[0];
            int second = Math.max(array[0], array[1]);
            for (int i = 2; i < array.length; i++) {
                int next = Math.max(first + array[i], second);
                first = second;
                second = next;
            }

            return second;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {75, 105, 120, 75, 90, 135};
        System.out.println(maxSubsetSumNoAdjacent(arr));
    }
}
