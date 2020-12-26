package Medium;

import java.util.*;

class Program {

    public static boolean hasSingleCycle(int[] array) {

        // Time:  O(N)
        // Space: O(1)

        // 2 scenarios:
        // Scenario 1: if traverse back to startingIdx without visiting every other element
        //             then there's possibly more than 1 cycle
        // Scenario 2: if visit every other element and then doesn't come back to startingIdx
        //             then there's possible more than 1 cycle too

        int currIdx = 0;
        int numsElementVisited = 0;
        while (numsElementVisited < array.length) {
            // Scenario 1
            if (numsElementVisited > 0 && currIdx == 0) {
                return false;
            };
            numsElementVisited += 1;
            currIdx = getNextIndex(currIdx, array);
        }

        // Scenario 2
        return currIdx == 0;
    }

    public static int getNextIndex(int currIdx, int[] array) {
        int steps = array[currIdx];
        int nextIdx = (currIdx + steps) % array.length;
        return nextIdx >= 0 ? nextIdx : nextIdx + array.length;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 3, 1, -4, -4, 2};
        System.out.println(hasSingleCycle(arr));
    }
}
