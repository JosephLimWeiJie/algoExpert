package Hard;

import java.util.*;

class Program {

    public static int quickselect(int[] array, int k) {

        // Time:  O(n) on average, O(n ^ 2) on worst-case
        // Space: O(1)

        partition(0, array.length - 1, array, k);

        return array[k - 1];
    }

    public static void partition(int startIdx, int endIdx, int[] array, int k) {

        while (true) {
            int pivot = array[startIdx];

            int left = startIdx + 1;
            int right = endIdx;
            while (left <= right) {
                if (array[left] > pivot && array[right] < pivot) {
                    swap(left, right, array);
                }

                if (array[left] <= pivot) {
                    left++;
                }

                if (array[right] >= pivot) {
                    right--;
                }

            }

            swap(startIdx, right, array);

            if (right == k - 1) {
                return;
            } else if (right < k - 1) {
                startIdx = right + 1;
            } else {
                endIdx = right - 1;
            }
        }
    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {8, 5, 2, 9, 7, 6, 3};
        int k = 3;
        System.out.println(quickselect(arr, k));
    }
}
