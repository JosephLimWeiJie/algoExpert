package prompt.medium;

import java.util.*;

public class ThreeNumberSort {

    public static int[] threeNumberSort(int[] array, int[] order) {
        
        int fstIdx = 0;
        int sndIdx = 0;
        int thdIdx = array.length - 1;

        int fstValue = order[0];
        int sndValue = order[1];
        int thdValue = order[2];

        while (sndIdx <= thdIdx) {
            int currValue = array[sndIdx];

            if (currValue == fstValue) {
                swap(array, sndIdx, fstIdx);
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

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void TestCase1() {
        var array = new int[] {1, 0, 0, -1, -1, 0, 1, 1};
        var order = new int[] {0, 1, -1};
        var expected = new int[] {0, 0, 0, 1, 1, 1, -1, -1};
        var actual = threeNumberSort(array, order);
        System.out.println(expected.length == actual.length);
        for (int i = 0; i < expected.length; i++) {
          System.out.println(expected[i] == actual[i]);
        }
    }
    
    public static void main(String[] args) {
        TestCase1();
    }
}
