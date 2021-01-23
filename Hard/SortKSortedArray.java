package Hard;

import java.util.*;

class Program {

    public static int[] sortKSortedArray(int[] array, int k) {

        // Time:  O(n * log(k)) where k is the range
        // Space: O(k)

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < Math.min(k + 1, array.length); i++) {
            pq.add(array[i]);
        }

        int idxToInsert = 0;
        for (int i = k + 1; i < array.length; i++) {
            int toAdd = pq.remove();
            array[idxToInsert] = toAdd;
            idxToInsert++;

            pq.add(array[i]);
        }

        while (!pq.isEmpty()) {
            int toAdd = pq.remove();
            array[idxToInsert] = toAdd;
            idxToInsert++;
        }

        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[] {3, 2, 1, 5, 4, 7, 6, 5};
        int k = 3;
        System.out.println(Arrays.toString(sortKSortedArray(array, k)));
    }
}

