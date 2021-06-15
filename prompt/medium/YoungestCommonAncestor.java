package prompt.medium;

import java.util.*;

public class YoungestCommonAncestor {

    public static AncestralTree getYoungestCommonAncestor(
      AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        // Write your code here.
        int depthOfDescendantOne = getDepthLevelOfNode(descendantOne);
        int depthOfDescendantTwo = getDepthLevelOfNode(descendantTwo);

        // Make both descendant on the same height
        if (depthOfDescendantOne > depthOfDescendantTwo) {
            while (depthOfDescendantOne > depthOfDescendantTwo) {
                descendantOne = descendantOne.ancestor;
                depthOfDescendantOne--;
            }
        } else if (depthOfDescendantTwo > depthOfDescendantOne) {
            while (depthOfDescendantTwo > depthOfDescendantOne) {
                descendantTwo = descendantTwo.ancestor;
                depthOfDescendantTwo--;
            }
        }

        while (descendantOne.name != descendantTwo.name) {
            descendantOne = descendantOne.ancestor;
            descendantTwo = descendantTwo.ancestor;
        }
        
        return descendantOne; 
    }

    public static int getDepthLevelOfNode(AncestralTree node) {
        int depth = 0;

        AncestralTree currNode = node;
        while (currNode.ancestor != null) {
            currNode = currNode.ancestor;
            depth++;
        }

        return depth;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }

    public static HashMap<Character, AncestralTree> getTrees() {
        var trees = new HashMap<Character, AncestralTree>();
        var alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (char a : alphabet.toCharArray()) {
          trees.put(a, new AncestralTree(a));
        }
    
        trees
            .get('A')
            .addAsAncestor(
                new AncestralTree[] {
                  trees.get('B'), trees.get('C'), trees.get('D'), trees.get('E'), trees.get('F')
                });
        return trees;
    }
      
    public static void TestCase1() {
        var trees = getTrees();
        trees.get('A').addAsAncestor(new AncestralTree[] {trees.get('B'), trees.get('C')});
        trees.get('B').addAsAncestor(new AncestralTree[] {trees.get('D'), trees.get('E')});
        trees.get('D').addAsAncestor(new AncestralTree[] {trees.get('H'), trees.get('I')});
        trees.get('C').addAsAncestor(new AncestralTree[] {trees.get('F'), trees.get('G')});

        var yca = getYoungestCommonAncestor(trees.get('A'), trees.get('E'), trees.get('I'));
        System.out.println(yca == trees.get('B'));
    }

    public static void main(String[] args) {
        TestCase1();
    }
}
