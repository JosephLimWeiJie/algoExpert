package prompt.medium;

import java.util.*;

public class MinNumberOfCoinChange {
    
    public static int minNumberOfCoinsForChange(int n, int[] denoms) {
        int[] table = new int[n + 1];
        Arrays.fill(table, Integer.MAX_VALUE);
        table[0] = 0;
        int toCompare = 0;

        for (int i = 0; i < denoms.length; i++) {
            for (int j = 0; j <= n; j++) {
                int currDenom = denoms[i];
                if (currDenom <= j) {
                    if (table[j - currDenom] == Integer.MAX_VALUE) {
                        toCompare = table[j - currDenom];
                    } else {
                        toCompare = table[j - currDenom] + 1;
                    }
                    table[j] = Math.min(table[j], toCompare);
                }
            }
        }

        return table[n] == Integer.MAX_VALUE ? - 1 : table[n];
    }

    public static void TestCase1() {
        int[] input = {1, 5, 10};
        System.out.println(minNumberOfCoinsForChange(7, input) == 3);
    }
    public static void main(String[] argsd) {
        TestCase1();
    }
}
