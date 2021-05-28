package prompt.hard;

import java.util.*;

public class HeapSort {

    public static int[] heapSort(int[] array) {
        buildMaxHeap(array);

        for (int i = array.length - 1; i > 0; i--) {
            swap(array, 0, i);
            siftDown(array, 0, i - 1);
        }

        System.out.println(Arrays.toString(array));
        return array;
    }

    public static void buildMaxHeap(int[] array) {
        int lastLeafNodeIndex = (array.length / 2) - 1;
        
        for (int i = lastLeafNodeIndex; i >= 0; i--) {
            heapify(array, i);
        }
    }

    public static void siftDown(int[] array, int currIdx, int endIdx) {
        int n = array.length;
        int leftChildIdx = (2 * currIdx) + 1;

        while (leftChildIdx <= endIdx) {
            int rightChildIdx = (2 * currIdx) + 2 <= endIdx ? (2 * currIdx) + 2 : -1;
            int idxToSwap = 0;

            if (rightChildIdx != -1 && array[rightChildIdx] > array[leftChildIdx]) {
                idxToSwap = rightChildIdx;
            } else {
                idxToSwap = leftChildIdx;
            }

            if (array[currIdx] < array[idxToSwap]) {
                swap(array, currIdx, idxToSwap);
                currIdx = idxToSwap;
                leftChildIdx = (2 * currIdx) + 1;
            } else {
                return;
            }
        }
    }

    public static void heapify(int[] array, int nodeIdx) {
        int n = array.length;
        int largestIdx = nodeIdx;

        int leftChildIdx = (2 * nodeIdx) + 1;
        int rightChildIdx = (2 * nodeIdx) + 2;

        // Compare left
        if (leftChildIdx < n && array[leftChildIdx] > array[largestIdx]) {
            largestIdx = leftChildIdx;
        }

        // Compare right
        if (rightChildIdx < n && array[rightChildIdx] > array[largestIdx]) {
            largestIdx = rightChildIdx;
        }

        if (largestIdx != nodeIdx) {
            swap(array, largestIdx, nodeIdx);
            heapify(array, largestIdx);
        }

    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void TestCase1() {
        int[] expected = {2, 3, 5, 5, 6, 8, 9};
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        System.out.println(compare(heapSort(input), expected));
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
