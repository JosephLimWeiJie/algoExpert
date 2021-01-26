package Hard;

import java.util.*;

class Program {

    public static int waterArea(int[] heights) {

        // Time:  O(n)
        // Space: O(1)

        if (heights.length == 0) {
            return 0;
        }

        int leftIdx = 0;
        int rightIdx = heights.length - 1;
        int leftMax = heights[leftIdx];
        int rightMax = heights[rightIdx];
        int waterArea = 0;

        while (leftIdx < rightIdx) {
            if (heights[leftIdx] < heights[rightIdx]) {
                leftIdx++;
                leftMax = Math.max(leftMax, heights[leftIdx]);
                waterArea += (leftMax - heights[leftIdx]);
            } else {
                rightIdx--;
                rightMax = Math.max(rightMax, heights[rightIdx]);
                waterArea += (rightMax - heights[rightIdx]);
            }
        }

        return waterArea;
    }

    public static void main(String[] args) {
        int[] heights = new int[] {0, 8, 0, 0, 5, 0, 0, 10, 0, 0, 1, 1, 0, 3};
        System.out.println(waterArea(heights));
    }
}
