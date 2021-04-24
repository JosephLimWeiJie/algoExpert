package prompt.medium;

import java.util.*;

public class SingleCycleCheck {
    
    public static boolean hasSingleCycle(int[] array) {
        
        int runningIdx = 0;
        int numOfElementsVisited = 0;

        while (numOfElementsVisited < array.length) {
            // Scenario 1
            if (numOfElementsVisited > 0 && runningIdx == 0) {
                return false;
            }

            numOfElementsVisited++;
            runningIdx = getNextIdx(runningIdx, array);
        }

        // Scenario 2
        return runningIdx == 0;
    }

    public static int getNextIdx(int currIdx, int[] array) {
        int steps = array[currIdx];
        int nextIdx = (currIdx + steps) % array.length;
        return nextIdx >= 0 ? nextIdx : nextIdx + array.length;
    }

    public static void main(String[] args) {
        System.out.println(hasSingleCycle(new int[] {2, 3, 1, -4, -4, 2}));
    }
}
