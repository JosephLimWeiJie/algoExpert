package prompt.easy;

import java.util.*;

public class NonconstructibleChange {

    public static int nonConstructibleChange(int[] coins) {
        int currChange = 0;
        Arrays.sort(coins);

        for (int coin : coins) {
            if (coin > currChange + 1) {
                return currChange + 1;
            }

            currChange += coin;
        }

        return currChange + 1;
    }

    public static void main(String[] args) {
        int[] input = new int[] {5, 7, 1, 1, 2, 3, 22};
        int expected = 20;
        int actual = nonConstructibleChange(input);
        System.out.println(expected == actual);
    }
}