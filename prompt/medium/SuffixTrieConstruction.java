package prompt.medium;

import java.util.*;

public class SuffixTrieConstruction {
    
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
            for (int i = 0; i < str.length(); i++) {
                insertSubStringStartingAt(i, str);
            }
        }

        public void insertSubStringStartingAt(int idx, String str) {
            String subString = str.substring(idx, str.length());
            TrieNode currNode = this.root;

            for (int i = idx; i < str.length(); i++) {
                char currChar = str.charAt(i);

                if (!currNode.children.containsKey(currChar)) {
                    currNode.children.put(currChar, new TrieNode());
                }

                currNode = currNode.children.get(currChar);
            }

            currNode.children.put(this.endSymbol, null);
        }
    
        public boolean contains(String str) {
            if (!this.root.children.containsKey(str.charAt(0))) {
                return false;
            }

            TrieNode currNode = this.root;
            for (int i = 0; i < str.length(); i++) {
                char currChar = str.charAt(i);
                if (!currNode.children.containsKey(currChar)) {
                    return false;
                }

                currNode = currNode.children.get(currChar);
            }

            return currNode.children.containsKey(this.endSymbol);
        }
    }

    public static void TestCase1() {
        var trie = new SuffixTrie("babc");
        System.out.println(trie.contains("abc"));
    }

    public static void main(String[] args) {
        TestCase1();
    }
} 
