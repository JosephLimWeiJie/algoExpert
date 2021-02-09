package Hard;

import java.util.*;

class Program {
    public static int minNumberOfJumps(int[] array) {

        // Time:  O(n)
        // Space: O(1)

        if (array.length == 1) {
            return 0;
        }

        int jumps = 0;
        int maxReach = array[0];
        int steps = array[0];

        for (int i = 1; i < array.length - 1; i++) {
            maxReach = Math.max(maxReach, i + array[i]);
            steps--;
            if (steps == 0) {
                jumps++;
                steps = maxReach - i;
            }
        }

        return jumps + 1;
    }

    public static void main(String[] args) {
        int[] input = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3, 2, 3, 2, 1, 1, 1, 1};
        System.out.println(minNumberOfJumps(input));
    }
}
