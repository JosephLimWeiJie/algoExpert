import java.util.*;

class Program {
    public static int[] selectionSort(int[] array) {

        // Time: O(n ** 2) Worst-case
        // Space: O(1)

        if (array.length == 0) {
            return new int[] {};
        }

        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
        	    if (array[j] < array[minIndex]) {
                    minIndex = j;
        	       }
               }

                swap(i, minIndex, array);
        }

        return array;
    }

    public static void swap(int first, int second, int[] array) {
        int temp  = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
}
