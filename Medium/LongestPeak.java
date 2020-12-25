package Medium;

import java.util.*;

class Program {

    public static int longestPeak(int[] array) {

        // Time:  O(n)
        // Space: O(1)

        int ans = 0;

        for (int i = 1; i < array.length - 1; i++) {
            if (array[i - 1] < array[i] && array[i + 1] < array[i]) {
                int leftIdx = i - 2;
                int rightIdx = i + 2;

                while (leftIdx >= 0 && array[leftIdx] < array[leftIdx + 1]) {
                    leftIdx--;
                }

                while (rightIdx < array.length && array[rightIdx] < array[rightIdx - 1]) {
                    rightIdx++;
                }

                int peakLength = rightIdx - leftIdx - 1;
                if (peakLength > ans) {
                    ans = peakLength;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        System.out.println(longestPeak(arr));
    }
}
