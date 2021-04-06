package prompt.easy;

import java.util.*;

public class FindThreeLargestNumbers {

    public static boolean compare(int[] arr1, int[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public static int[] findThreeLargestNumbers(int[] array) {
        int[] sortedArray = new int[3];
        for (int i = 0; i < sortedArray.length; i++) {
            sortedArray[i] = Integer.MIN_VALUE;
        }

        for (int j = 0; j < array.length; j++) {
            insertNumberIntoSortedArray(sortedArray, array[j]);
        }

        return sortedArray;
    }

    public static void insertNumberIntoSortedArray(int[] array, int num) {
        if (num > array[2]) {
            array[0] = array[1];
            array[1] = array[2];
            array[2] = num;
        } else if (num > array[1] && num <= array[2]) {
            array[0] = array[1];
            array[1] = num;
        } else if (num > array[0] && num <= array[1]) {
            array[0] = num;
        }
    }

    public static void main(String[] args) {
        int[] expected = {18, 141, 541};
        System.out.println(compare(findThreeLargestNumbers(new int[] {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7}),
                expected));
    
    
    }
    
}