import java.util.*;

class Program {
    public static int[] bubbleSort(int[] array) {

        // Time: O(n ** 2) Worst-case
        // Space: O(1)

        if (array.length == 0) {
    	       return new int[] {};
        }

        for (int i = 0; i < array.length - 1; i++) {
            boolean hasSwap = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    swap(j, j + 1, array);
                hasSwap = true;
            }
        }

        if (!hasSwap) {
            break;
        }
    }

        return array;
    }

    public static void swap(int first, int second, int[] array) {
        int temp  = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
