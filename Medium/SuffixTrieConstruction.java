package Medium;

import java.util.*;

class Program {
    // Do not edit the class below except for the
    // populateSuffixTrieFrom and contains methods.
    // Feel free to add new properties and methods
    // to the class.
    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    }

    static class SuffixTrie {
        TrieNode root = new TrieNode();
        char endSymbol = '*';

        public SuffixTrie(String str) {
            populateSuffixTrieFrom(str);
        }

        public void populateSuffixTrieFrom(String str) {

            // Time:  O(n ^ 2)
            // Space: O(n ^ 2)

            for (int i = 0; i < str.length(); i++) {
                insertSubstringStartingAt(i, str);
            }
        }

        public void insertSubstringStartingAt(int startIdx, String str) {
            TrieNode currNode = root;
            for (int i = startIdx; i < str.length(); i++) {
                char currLetter = str.charAt(i);
                if (!currNode.children.containsKey(currLetter)) {
                    currNode.children.put(currLetter, new TrieNode());
                }
                currNode = currNode.children.get(currLetter);
            }
            currNode.children.put(endSymbol, null);
        }

        public boolean contains(String str) {

            // Time:  O(n) where n is the length of str.
            // Space: O(1)
            TrieNode currNode = root;
            for (int i = 0; i < str.length(); i++) {
                char currLetter = str.charAt(i);
                if (!currNode.children.containsKey(currLetter)) {
                    return false;
                }
                currNode = currNode.children.get(currLetter);
            }

            return currNode.children.containsKey(endSymbol);
        }
    }
}
