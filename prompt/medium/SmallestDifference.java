package prompt.medium;

import java.util.*;

public class SmallestDifference {
    
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);

        int arrOneMarker = 0;
        int arrTwoMarker = 0;

        int smallestDiff = Integer.MAX_VALUE;
        int currDiff = Integer.MAX_VALUE;
        int[] ans = new int[2];
        while (arrOneMarker < arrayOne.length && arrTwoMarker < arrayTwo.length) {
            int first = arrayOne[arrOneMarker];
            int second = arrayTwo[arrTwoMarker];

            if (first - second == 0) {
                return new int[] {first, second};
            } else if (first > second) {
                currDiff = first - second;
                arrTwoMarker++;
            } else {
                currDiff = second - first;
                arrOneMarker++;
            }

            if (currDiff < smallestDiff) {
                smallestDiff = currDiff;
                ans = new int[] {first, second};
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] expected = {28, 26};
        System.out.println(
            Arrays.equals(
                smallestDifference(
                    new int[] {-1, 5, 10, 20, 28, 3}, new int[] {26, 134, 135, 15, 17}),
                expected));
      
    }
}
