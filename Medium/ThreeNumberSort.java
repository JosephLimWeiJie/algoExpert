package Medium;

import java.util.*;

class Program {

    public static int[] threeNumberSort(int[] array, int[] order) {

        // Time:  O(n)
        // Space: O(1)

        int fstIdx = 0;
        int sndIdx = 0;
        int thdIdx = array.length - 1;

        int fstValue = order[0];
        int sndValue = order[1];
        int thdValue = order[2];

        while (sndIdx <= thdIdx) {
            int currValue = array[sndIdx];

            if (currValue == fstValue) {
                swap(array, fstIdx, sndIdx);
                fstIdx++;
                sndIdx++;
            } else if (currValue == sndValue) {
                sndIdx++;
            } else {
                swap(array, sndIdx, thdIdx);
                thdIdx--;
            }
        }

        return array;
    }

    public static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 0, 0, -1, -1, 0, 1, 1};
        int[] order = new int[] {0, 1, -1};
        System.out.println(Arrays.toString(threeNumberSort(arr, order)));
    }
}
