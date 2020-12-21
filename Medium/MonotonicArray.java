package Medium;

import java.util.*;

class Program {

    public static boolean isMonotonic(int[] array) {

        // Time:  O(n)
        // Space: O(1)

        if (array.length <= 1) {
            return true;
        }

        int prevDirection = array[1] - array[0];
        boolean changeDirection = false;
        for (int i = 2; i < array.length; i++) {
            int currDirection = array[i] - array[i - 1];
            if (currDirection > 0 && prevDirection < 0) {
                changeDirection = true;
                break;
            } else if (currDirection < 0 && prevDirection > 0) {
                changeDirection = true;
                break;
            }
            prevDirection = currDirection;
        }

        if (changeDirection) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        System.out.println(isMonotonic(arr));
    }
}