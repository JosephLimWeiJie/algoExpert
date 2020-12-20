package Easy;

import java.util.*;

class Program {

    public static boolean isPalindrome(String str) {

        // Time:  O(n)
        // Space: O(1)

        int leftIdx = 0;
        int rightIdx = str.length() - 1;
        while (leftIdx < rightIdx) {
            if (str.charAt(leftIdx) == str.charAt(rightIdx)) {
                leftIdx++;
                rightIdx--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeAlt(String str) {

        // Time:  O(n)
        // Space: O(n) is worst case

        char[] charArr = str.toCharArray();
        Map<Character, Integer> m = new HashMap<>();
        int midIdx = (str.length() - 1) / 2;

        for (char c : charArr) {
            if (m.containsKey(c)) {
                m.computeIfPresent(c, (k, v) -> v += 1);
            } else {
                m.put(c, 1);
            }
        }

        boolean mapHasPalindrome = true;
        for (Map.Entry mEle : m.entrySet()) {
            if ((Character) mEle.getKey() == charArr[midIdx]) {
                continue;
            } else {
                if ((int) mEle.getValue() == 1) {
                    mapHasPalindrome = false;
                }
            }
        }

        if (mapHasPalindrome) {
            return true;
        }

        return false;
    }
}

