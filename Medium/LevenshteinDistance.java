package Medium;

import java.util.*;

class Program {

    public static int levenshteinDistance(String str1, String str2) {
        int[][] arr = new int[str1.length() + 1][str2.length() + 1];

        // Prepopulate the 2D array.
        arr[0][0] = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (i == 0) {
                    // Fill top horizontal row
                    arr[i][j] = j;
                }
            }
            // Fill leftmost vertical column
            arr[i][0] = i;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    arr[i][j] = arr[i - 1][j - 1];
                } else {
                    arr[i][j] = 1 + getMin(arr[i - 1][j], arr[i - 1][j - 1], arr[i][j - 1]);
                }
            }
        }

        return arr[arr.length - 1][arr[0].length - 1];
    }

    public static int getMin(int x, int y, int z) {
        int currMin = x;
        return Math.min(x, Math.min(y, z));
    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "yabd";
        System.out.println(levenshteinDistance(str1, str2));
    }
}
