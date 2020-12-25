package Medium;

import java.util.*;

class Program {

    public static int[] arrayOfProducts(int[] array) {

        // Time:  O(n)
        // Space: O(n)

        int[] leftProducts = new int[array.length];
        int[] rightProducts = new int[array.length];

        // Populate left products
        int runningLeft = 1;
        for (int i = 0; i < leftProducts.length; i++) {
            if (i == 0) {
                leftProducts[i] = 1;
            } else {
                runningLeft = array[i - 1] * runningLeft;
                leftProducts[i] = runningLeft;
            }

        }

        // Populate right products
        int runningRight = 1;
        for (int j = rightProducts.length - 1; j >= 0; j--) {
            if (j == rightProducts.length - 1) {
                rightProducts[j] = 1;
            } else {
                runningRight = array[j + 1] * runningRight;
                rightProducts[j] = runningRight;
            }
        }

        // get total product of each element
        int[] ans = new int[array.length];
        for (int k = 0; k < array.length; k++) {
            ans[k] = leftProducts[k] * rightProducts[k];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {5, 1, 4, 2};
        System.out.println(Arrays.toString(arrayOfProducts(arr)));
    }
}
