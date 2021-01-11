package Medium;

import java.util.*;

class Program {

    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] runningCounter = new int[n + 1];
        for (int i = 0; i < runningCounter.length; i++) {
            if (i == 0) {
                runningCounter[0] = 0;
            } else {
                runningCounter[i] = Integer.MAX_VALUE;
            }
        }

        int toCompare = 0;
        for (int denom : denoms) {
            for (int i = 0; i < runningCounter.length; i++) {
                if (denom <= i) {
                    if (runningCounter[i - denom] == Integer.MAX_VALUE) {
                        toCompare = runningCounter[i - denom];
                    } else {
                        toCompare = runningCounter[i - denom] + 1;
                    }
                    runningCounter[i] = Math.min(runningCounter[i], toCompare);
                }
            }
        }

        // If no change can be found
        if (runningCounter[runningCounter.length - 1] == Integer.MAX_VALUE) {
            return - 1;
        }

        return runningCounter[runningCounter.length - 1];
    }

    public static void main(String[] args) {
        int[] denoms = new int[] {1, 5};
        int n = 6;
        System.out.println(minNumberOfCoinsForChange(n, denoms));
    }
}
