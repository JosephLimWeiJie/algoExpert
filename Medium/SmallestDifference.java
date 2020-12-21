package Medium;

import java.util.*;

class Program {

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {

        // Time:  O(nLogN) + O(mLogM) where n and m are the sizes of arrayOne and arrayTwo respectively.
        // Space: O(1)

        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int idxOne = 0;
        int idxTwo = 0;

        int smallest = Integer.MAX_VALUE;
        int current = Integer.MAX_VALUE;
        int[] smallestPair = new int[2];
        while (idxOne < arrayOne.length && idxTwo < arrayTwo.length) {
            int first = arrayOne[idxOne];
            int second = arrayTwo[idxTwo];
            if (first < second) {
                current = second - first;
                idxOne++;
            } else if (first > second) {
                current = first - second;
                idxTwo++;
            } else if (first == second) {
                return new int[] {first, second};
            }

            if (current < smallest) {
                smallest = current;
                smallestPair = new int[] {first, second};
            }
        }

        return smallestPair;
    }

    public static void main(String[] args) {
        int[] arrOne = new int[]{-1, 5, 10, 20, 28, 3};
        int[] arrTwo = new int[]{26, 134, 135, 15, 17};
        System.out.println(smallestDifference(arrOne, arrTwo));
    }
}
