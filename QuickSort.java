import java.util.*;

class Program {
    public static int[] quickSort(int[] array) {
        // Time: Best O(N log(N))
        //       Worst O(N^2)

        // Space: Average (log(N))
        //        Worst (O(N))

        if (array.length <= 1) {
            return array;
        }

        quickSort(array, 0, array.length - 1);
        return array;
    }

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int m = partition(array, low, high);
            quickSort(array, low, m - 1);
            quickSort(array, m + 1, high);
        }
    }

    /**
     *  Organize the array into 3 regions such that there is the pivot
     *  in the middle, and those lesser than the pivot on the left
     *  and those greater on the right of the pivot.
     */

    public static int partition(int[] array, int i, int j) {
        // The first element of the array is the pivot.
        int p = array[i];

        // m is the new index for the pivot element after partition but
        // initialized at index 0;

        int m = i;
        for (int k = i + 1; k <= j; k++) {
            if (array[k] < p) {
                m++;
                swap(k, m, array);
            }
        }
        swap(i, m, array);
        // after partitioning, swap pivot element into the new m index
        return m;
    }

    public static void swap(int first, int second, int[] array) {
        int temp  = array[first];
        array[first] = array[second];
        array[second] = temp;
    }


}
