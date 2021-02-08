package Hard;

import java.util.*;

class Program {

    public static int indexEqualsValue(int[] array) {

        // Time:  O(log(n))
        // Space: O(1)

        int leftIdx = 0;
        int rightIdx = array.length - 1;

        while (leftIdx <= rightIdx) {
            int midIdx = rightIdx + (leftIdx - rightIdx) / 2;
            int midVal = array[midIdx];

            if (midVal < midIdx) {
                leftIdx = midIdx + 1;
            } else if (midVal == midIdx && midIdx == 0) {
                return midIdx;
            } else if (midVal == midIdx && array[midIdx - 1] < (midIdx - 1)) {
                return midIdx;
            } else {
                rightIdx = midIdx - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {-12, 1, 2, 3, 12};
        int[] arr2 = new int[] {-5, -3, 0, 3, 4, 5, 9};
        System.out.println(indexEqualsValue(arr));
    }
}
