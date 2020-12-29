package Medium;

import java.util.*;

class Program {

    public static String longestPalindromicSubstring(String str) {

        // Time:  O(n^2)
        // Space: O(n)

        int[] currLongest = new int[] {0, 1};
        for (int i = 1; i < str.length(); i++) {
            int[] odd = getLongestPalindromeFrom(str, i - 1, i + 1);
            int[] even = getLongestPalindromeFrom(str, i - 1, i);

            int[] longest = odd[1] - odd[0] > even[1] - even[0] ? odd : even;
            currLongest = currLongest[1] - currLongest[0] > longest[1] - longest[0] ? currLongest : longest;
        }

        return str.substring(currLongest[0], currLongest[1]);
    }

    public static int[] getLongestPalindromeFrom(String str, int leftIdx, int rightIdx) {
        while (leftIdx >= 0 && rightIdx < str.length()) {
            if (str.charAt(leftIdx) != str.charAt(rightIdx)) {
                break;
            }
            leftIdx--;
            rightIdx++;
        }

        return new int[] {leftIdx + 1, rightIdx};
    }

    public static void main(String[] args) {
        String str = "abaxyzzyxf";
        System.out.println(longestPalindromicSubstring(str));
    }
}

