package prompt.medium;

import java.util.*;

public class NumberOfWaysToMakeChange {

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] ways = new int[n + 1];

        // Base case: The number of ways to make change for an amount of 0 is assumed to be 1
        ways[0] = 1;

        for (int i = 0; i < denoms.length; i++) {
            for (int amount = 1; amount <= n; amount++) {
                int denom = denoms[i];
                if (denom <= amount) {
                    ways[amount] += ways[amount - denom];
                }
            }
        }

        return ways[ways.length - 1];
    }

    public static void TestCase1() {
        int[] input = {1, 5};
        System.out.println(numberOfWaysToMakeChange(6, input) == 2);
    }

    public static void main(String[] args) {
        TestCase1();
    }
    
}
