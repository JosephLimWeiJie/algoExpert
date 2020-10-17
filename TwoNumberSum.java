import java.util.*;

class Program {
    public static int[] twoNumberSum(int[] array, int targetSum) {

        // Time: O(nLogn)
        // Space: O(1)

        int[] sortedArray = mergeSort(array);
        int leftIndex = 0;
        int rightIndex = sortedArray.length - 1;

        while (true) {
            int currSum = sortedArray[leftIndex] + sortedArray[rightIndex];

            if (leftIndex >= rightIndex) {
                break;
            } else if (currSum == targetSum) {
                return new int[] {sortedArray[leftIndex], sortedArray[rightIndex]};
            } else if (currSum > targetSum) {
                rightIndex--;
            } else if (currSum < targetSum) {
                leftIndex++;
            }
        }

        return new int[0];
    }

    /* A utility function to sort the array. */
    public static int[] mergeSort(int[] array) {

        // Time: O(nLogn)
        // Space: O(nLogn) - worst-case and O(n) best-case

        // Write your code here.
        if (array.length <= 1) {
            return array;
        }

        int midIndex = array.length / 2;
        int[] leftArray = Arrays.copyOfRange(array, 0, midIndex);
        int[] rightArray = Arrays.copyOfRange(array, midIndex, array.length);
        return merge(mergeSort(leftArray), mergeSort(rightArray));
    }

    public static int[] merge(int[] array1, int[] array2) {
        int totalSizeOfArrayOneAndTwo = array1.length + array2.length;
        int[] combinedArray = new int [totalSizeOfArrayOneAndTwo];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                combinedArray[k] = array1[i];
                k++;
                i++;
            } else {
                combinedArray[k] = array2[j];
                k++;
                j++;
            }
        }

        while (i < array1.length) {
            combinedArray[k] = array1[i];
            k++;
            i++;
        }

        while (j < array2.length) {
            combinedArray[k] = array2[j];
            k++;
            j++;
        }

        return combinedArray;
    }
}
