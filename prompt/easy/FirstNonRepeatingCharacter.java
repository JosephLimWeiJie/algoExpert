package prompt.easy;

import java.util.*;

public class FirstNonRepeatingCharacter {
    
    public static int firstNonRepeatingCharacter(String string) {
        Map<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < string.length(); i++) {
            map.put(string.charAt(i), map.getOrDefault(string.charAt(i), 0) + 1);
        }

        for (int i = 0; i < string.length(); i++) {
            if (map.get(string.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String input = "abcdcaf";
        int expected = 1;
        var actual = firstNonRepeatingCharacter(input);
        System.out.println(expected == actual);
    }
}
