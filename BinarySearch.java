import java.util.*;

class Program {
    public static int binarySearch(int[] array, int target) {

        // Time: O(logN)
        // Space: O(1)

        // Write your code here.
        return binarySearch(array, target, 0, array.length - 1);
    }

    public static int binarySearch(int[] array, int target, int startIndex, int endIndex) {
        while (startIndex <= endIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            int value = array[midIndex];
            if (target == value) {
                return midIndex;
            } else if (target < value) {
                endIndex = midIndex - 1;
            } else {
                startIndex = midIndex + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {0, 1, 21, 33, 45, 45, 61, 72, 73};
        System.out.println(binarySearch(arr, 33));
    }
}

/** Space: O(logN) recursive version
    public static int binarySearch(int[] array, int target, int startIndex, int endIndex) {
        int midIndex = (startIndex + endIndex) / 2;

        if (startIndex > endIndex) {
            return -1; // target not found
        }

        if (target > array[midIndex]) {
            // search rightwards
            return binarySearch(array, target, midIndex + 1, endIndex);
        } else if (target < array[midIndex]) {
            // search leftwards
            return binarySearch(array, target, startIndex, midIndex - 1);
        } else {
            return midIndex;
        }
    }
*/
