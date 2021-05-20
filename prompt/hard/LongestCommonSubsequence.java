package prompt.hard;

import java.util.*;

public class LongestCommonSubsequence {

    public static List<Character> longestCommonSubsequence(String str1, String str2) {
        int[][] table = new int[str2.length() + 1][str1.length() + 1];

        for (int i = 1; i < str2.length() + 1; i++) {
            for (int j = 1; j < str1.length() + 1; j++) {
                if (str2.charAt(i - 1) == str1.charAt(j - 1)) {
                    table[i][j] = table[i - 1][j - 1] + 1;
                } else {
                    table[i][j] = Math.max(table[i - 1][j], table[i][j - 1]);
                }
            }
        }

        return buildSequence(table, str1);
    }

    public static List<Character> buildSequence(int[][] table, String str) {
        List<Character> sequence = new ArrayList<>();
        int i = table.length - 1;
        int j = table[0].length - 1;
        while (i != 0 && j != 0) {
            if (table[i][j] == table[i - 1][j]) {
                i--;
            } else if (table[i][j] == table[i][j - 1]) {
                j--;
            } else {
                sequence.add(0, str.charAt(j - 1));
                i--;
                j--;
            }
        }

        return sequence;
    }

    public static void TestCase1() {
        char[] expected = {'X', 'Y', 'Z', 'W'};
        System.out.println(compare(longestCommonSubsequence("ZXVVYZW", "XKYKZPW"), expected));
    }
    
    private static boolean compare(List<Character> arr1, char[] arr2) {
        if (arr1.size() != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i) != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TestCase1();
    }
}