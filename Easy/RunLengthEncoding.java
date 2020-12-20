package Easy;

import java.util.*;

class Program {

    public static String runLengthEncoding(String string) {

        // Time:  O(n)
        // Space: O(n)

        char[] charArr = string.toCharArray();
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();

        int count = 1;
        for (int i = 1; i < charArr.length; i++) {
            if (charArr[i] != charArr[i - 1] || count == 9) {
                list.add(String.valueOf(count));
                list.add(String.valueOf(charArr[i - 1]));
                count = 0;
            }
            count++;
        }

        // Handles the left-overs.
        list.add(String.valueOf(count));
        list.add(String.valueOf(charArr[charArr.length - 1]));

        for (String str : list) {
            sb.append(str);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(runLengthEncoding("AAAAAAAAAAAAABBCCCCDD"));
    }
}

