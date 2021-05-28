package prompt.hard;

import java.util.*;

public class QuickSort {

    public static int[] quickSort(int[] array) {
        
        if (array.length <= 1) {
            return array;
        }
    
        quickSort(array, 0, array.length - 1);
        return array;
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int m = partition(array, start, end);
            quickSort(array, start, m - 1);
            quickSort(array, m + 1, end);
        }
    }

    public static int partition(int[] array, int start, int end) {
        getRandomPivot(array, start, end);
        int pivot = array[start];
        int m = start;

        for (int i = start + 1; i <= end; i++) {
            if (array[i] < pivot) {
                m++;
                swap(array, i, m);
            }
        }

        swap(array, start, m);
        return m;
    }

    public static void getRandomPivot(int[] array, int start, int end) {
        Random random =  new Random();
        int randomPivot = random.nextInt(end - start) + start;

        swap(array, start, randomPivot);
    }

    public static void swap(int[] array, int i, int j) { 
        int temp =  array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void TestCase1() {
        int[] expected = {2, 3, 5, 5, 6, 8, 9};
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        System.out.println(compare(quickSort(input), expected));
    }

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

    public static void main(String[] args) {
        TestCase1();
    }
}
