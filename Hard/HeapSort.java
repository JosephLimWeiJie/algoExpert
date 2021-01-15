package Hard;

import java.util.*;

class Program {

    public static int[] heapSort(int[] array) {

        // Time:  O(n * log(n))
        // Space: O(1)
        buildMaxHeap(array);
        for (int i = array.length - 1; i > 0; i--) {
            swap(0, i, array);
            siftDown(0, i - 1, array);
        }
        return array;
    }

    public static void buildMaxHeap(int[] array) {
        int firstParentIdx = (array.length - 2) / 2;
        for (int i = firstParentIdx; i >= 0; i--) {
            siftDown(i, array.length - 1, array);
        }
    }

    public static void siftDown(int currIdx, int endIdx, int[] array) {
        // Based on 0-based indexing for a binary heap.
        int leftChildIdx = (currIdx * 2) + 1;

        while (leftChildIdx <= endIdx) {
            int rightChildIdx = (currIdx * 2) + 2 <= endIdx ? (currIdx * 2) + 2 : -1;
            int idxToSwap = 0;
            if (rightChildIdx != -1 && array[rightChildIdx] > array[leftChildIdx]) {
                idxToSwap = rightChildIdx;
            } else {
                idxToSwap = leftChildIdx;
            }

            if (array[currIdx] < array[idxToSwap]) {
                swap(currIdx, idxToSwap, array);
                currIdx = idxToSwap;
                leftChildIdx = (currIdx * 2) + 1;
            } else {
                return;
            }
        }
    }

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {8, 5, 2, 9, 5, 6, 3};
        System.out.println(Arrays.toString(heapSort(arr)));
    }
}
