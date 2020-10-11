import java.util.*;

class Program {
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


// An alternative method of mergeSort that has better space complexity O(n)
// and in-place

/**
public static int[] mergeSort(array) {
    if (array.length <= 1) {
        return array;
    }

    int[] auxArray = array.clone();
    mergeSort(array, 0, array.length - 1, auxArray);
    return array;
}

public static void mergeSort(int[] mainArray, int startIndex, int endIndex,
        int[] auxArray) {

    if (startIndex == endIndex) {
        return;
    }

    int midIndex = (startIndex + endIndex) / 2;
    mergeSort(auxArray, startIndex, midIndex, mainArray);
    mergeSort(auxArray, midIndex + 1, endIndex, mainArray);
    doMerge(mainArray, startIndex, midIndex, endIndex, auxArray);
}

public static void doMerge(int[] mainArray, int startIndex, int midIndex,
        int endIndex, int[] auxArray) {

    int k = startIndex;
    int i = startIndex;
    int j = midIndex + 1;

    while (i <= midIndex && j <= endIndex) {
        if (auxArray[i] <= auxArray[j]) {
            mainArray[k++] = auxArray[i++];
        } else {
            mainArray[k++] = auxArray[j++];
        }
    }

    while (i <= midIndex) {
        mainArray[k++] = auxArray[i++];
    }

    while (j <= endIndex) {
        mainArray[k++] = auxArray[j++];
    }
}
*/
