package Medium;

import java.util.*;

class Program {

    public static List<List<String>> groupAnagrams(List<String> words) {

        // Time:  O(n * m * log(m)) where n is the number of words and m is the length of the longest word.
        // Space: O(n * m)

        Map<String, List<String>> anagrams = new HashMap<>();

        for (String word : words) {
            char[] charArr = word.toCharArray();
            Arrays.sort(charArr);
            String sortedWord = new String(charArr);

            if (anagrams.containsKey(sortedWord)) {
                anagrams.get(sortedWord).add(word);
            } else {
                anagrams.put(sortedWord, new ArrayList<>(Arrays.asList(word)));
            }
        }

        return new ArrayList<>(anagrams.values());
    }

    public static void main(String[] args) {
        List<String> words = Arrays.asList(new String[] {"yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp"});
        System.out.println(groupAnagrams(words));
    }

}
