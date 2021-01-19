package Hard;

import java.util.*;

class Program {

    public static int[] subarraySort(int[] array) {

        // Time:  O(n)
        // Space: O(1)

        int left = 0;
        int right = array.length - 1;

        int smallest = Integer.MAX_VALUE;
        int biggest = Integer.MIN_VALUE;

        for (int i = 0; i < array.length; i++) {
            if (notInOrder(i, array)) {
                smallest = Math.min(smallest, array[i]);
                biggest = Math.max(biggest, array[i]);
            }
        }

        if (smallest == Integer.MAX_VALUE) {
            return new int[] {-1, -1};
        }

        while (smallest >= array[left]) {
            left++;
        }

        while (biggest <= array[right]) {
            right--;
        }

        return new int[] {left, right};
    }

    public static boolean notInOrder(int idx, int[] array) {
        if (idx == 0) {
            return array[idx] > array[idx + 1];
        } else if (idx == array.length - 1) {
            return array[idx - 1] > array[idx];
        } else {
            return array[idx] > array[idx + 1] || array[idx - 1] > array[idx];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 1};
        System.out.println(Arrays.toString(subarraySort(arr)));
    }
}
