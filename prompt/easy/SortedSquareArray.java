package prompt.easy;

import java.util.*;

public class SortedSquareArray {
    
    public static int[] sortedSquaredArray(int[] array) {
        int[] squaredArray = new int[array.length];

        int leftIdx = 0;
        int rightIdx = array.length - 1;
        int idxToInsert = array.length - 1;

        while (idxToInsert >= 0) {
            int[] results = compareBigger(array[leftIdx], array[rightIdx]);
            if (results[0] == 0) {
                // left side is bigger
                squaredArray[idxToInsert] = results[1];
                leftIdx++;
            } else {
                // right side is bigger
                squaredArray[idxToInsert] = results[1];
                rightIdx--;
            }

            idxToInsert--;
        }

        return squaredArray;
    }

    public static int[] compareBigger(int first, int second) {
        int bigger = (Math.abs(first) > Math.abs(second) ? Math.abs(first) : Math.abs(second));
        // 0 to denote first, 1 to denote second
        if (Math.abs(first) > Math.abs(second)) {
            return new int[] {0, bigger * bigger};
        } else {
            return new int[] {1, bigger * bigger};
        }
    }
    
    public static void main(String[] args) {
        var input = new int[] {1, 2, 3, 5, 6, 8, 9};
        var expected = new int[] {1, 4, 9, 25, 36, 64, 81};
        var actual = sortedSquaredArray(input);
        boolean isSame = true;
        for (int i = 0; i < expected.length; i++) {
            if (expected[i] != actual[i]) {
                isSame = false;
                System.out.println(isSame);
                break;
            }
        }
        System.out.println(isSame);
    }
}
