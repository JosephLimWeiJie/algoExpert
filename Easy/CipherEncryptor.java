package Easy;

import java.util.*;

class Program {

    public static String caesarCypherEncryptor(String str, int key) {

        // Time:  O(n)
        // Space: O(n) where n is length of new string

        StringBuilder sb = new StringBuilder();
        char[] charArr = str.toCharArray();
        for (char c : charArr) {
            char newC = getNextChar(c, key);
            sb.append(newC);
        }

        return sb.toString();
    }

    public static char getNextChar(Character c, int key) {
        int rangeOfAlphaAscii = 26;
        int asciiVal = (int) c;
        int newAsciiVal = (asciiVal + key - 'a') % rangeOfAlphaAscii;
        return (char) (newAsciiVal + 'a');
    }

    public static void main(String[] args) {
        System.out.println(caesarCypherEncryptor("abc", 2));
    }
}
