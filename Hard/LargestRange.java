package Hard;

import java.util.*;

class Program {

    public static int[] largestRange(int[] array) {

        // Time:  O(n)
        // Space: O(n)

        int[] ans = new int[2];
        int longestLength = 0;
        Map<Integer, Boolean> map = new HashMap<>();

        for (int num : array) {
            map.put(num, true);
        }

        for (int num : array) {
            if (!map.get(num)) {
                continue;
            }

            map.put(num, false);
            int currLength = 1;
            int left = num - 1;
            int right = num + 1;

            while (map.containsKey(left)) {
                map.put(left, false);
                currLength++;
                left--;
            }

            while (map.containsKey(right)) {
                map.put(right, false);
                currLength++;
                right++;
            }

            if (currLength > longestLength) {
                longestLength = currLength;
                ans = new int[] {left + 1, right - 1};
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};
        System.out.println(Arrays.toString(largestRange(arr)));
    }
}
