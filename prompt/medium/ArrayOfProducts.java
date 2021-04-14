package prompt.medium;

import java.util.*;

public class ArrayOfProducts {
    
    public static int[] arrayOfProducts(int[] array) {
        // Write your code here.

        int[] leftToRight = new int[array.length];
        int[] rightToLeft = new int[array.length];
        int[] ans = new int[array.length];

        leftToRight[0] = 1;
        rightToLeft[array.length - 1] = 1;

        for (int i = 1; i < leftToRight.length; i++) {
            leftToRight[i] = array[i - 1] * leftToRight[i - 1];
        }

        for (int j = rightToLeft.length - 2; j >= 0; j--) {
            rightToLeft[j] = array[j + 1] * rightToLeft[j + 1];
        }

        for (int k = 0; k < ans.length; k++) {
            ans[k] = leftToRight[k] * rightToLeft[k];
        }

        return ans;
    }

    public static void main(String[] args) {
        var input = new int[] {5, 1, 4, 2};
        var expected = new int[] {8, 40, 10, 20};
        int[] actual = arrayOfProducts(input);
        System.out.println(expected.length == actual.length);
        for (int i = 0; i < actual.length; i++) {
          System.out.println(actual[i] == expected[i]);
        }
    }
}
