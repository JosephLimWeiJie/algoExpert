package prompt.medium;

import java.util.*;

public class LevenshteinDistance {

    public static int levenshteinDistance(String str1, String str2) {
        int[][] table = new int[str1.length() + 1][str2.length() + 1];
        table[0][0] = 0;

        // Fill top row
        for (int j = 1; j <= str2.length(); j++) {
            table[0][j] = table[0][j - 1] + 1;
        }

        // Fill leftmost col
        for (int k = 1; k <= str1.length(); k++) {
            table[k][0] = table[k - 1][0] + 1;
        }

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1];
                } else {
                    table[i][j] = Math.min(table[i][j - 1], Math.min(table[i - 1][j - 1], table[i - 1][j])) + 1;
                }
            }
        }

        return table[str1.length()][str2.length()];
    }

    public static void TestCase1() {
        System.out.println(levenshteinDistance("abc", "yabd") == 2);
    }
    
    public static void main(String[] args) {
        TestCase1();
    }
}