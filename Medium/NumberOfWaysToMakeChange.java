package Medium;

import java.util.*;

class Program {

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {

        // Time:  O(n * d)
        // Space: O(n)

        int[] runningCounter = new int[n + 1];
        for (int i = 0; i < runningCounter.length; i++) {
            if (i == 0) {
                runningCounter[0] = 1;
            } else {
                runningCounter[i] = 0;
            }
        }

        for (int i = 0; i < denoms.length; i++) {
            int currDenom = denoms[i];
            for (int j = 1; j < runningCounter.length; j++) {
                if (currDenom <= j) {
                    runningCounter[j] += runningCounter[j - currDenom];
                }
            }
        }

        return runningCounter[runningCounter.length - 1];
    }

    public static void main(String[] args) {
        int[] denoms = new int[] {1, 5};
        int n = 6;
        System.out.println(numberOfWaysToMakeChange(n, denoms));
    }

    /** Generic Formula
     * int[] ways = new int[n + 1]
     *
     * for (int denom : denoms)
     *     for (int amount = 1; amount < n + 1; amount++)
     *          if (denom <= amount)
     *              ways[amount] += ways[amount - denom]
     *
     * return ways[n]
     */
}
