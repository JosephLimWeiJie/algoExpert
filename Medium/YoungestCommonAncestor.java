package Medium;

import java.util.*;

class Program {
    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {

        // Time:  O(h) where h is the depth of the tree
        // Space: O(1)

        int depthOne = getDescendantDepth(descendantOne, topAncestor);
        int depthTwo = getDescendantDepth(descendantTwo, topAncestor);

        if (depthOne > depthTwo) {
            return backtrackTree(descendantOne, descendantTwo, depthOne - depthTwo);
        } else {
            return backtrackTree(descendantTwo, descendantOne, depthTwo - depthOne);
        }
    }

    public static AncestralTree backtrackTree(
            AncestralTree descendantWithHigherDepth, AncestralTree descendantTwoWithLowerDepth, int depthDiff) {

        while (depthDiff > 0) {
            descendantWithHigherDepth = descendantWithHigherDepth.ancestor;
            depthDiff--;
        }

        while (descendantTwoWithLowerDepth != descendantWithHigherDepth) {
            descendantWithHigherDepth = descendantWithHigherDepth.ancestor;
            descendantTwoWithLowerDepth = descendantTwoWithLowerDepth.ancestor;
        }

        return descendantTwoWithLowerDepth;
    }

    public static int getDescendantDepth(AncestralTree descendant, AncestralTree topAncestor) {
        int depth = 0;

        while (descendant != topAncestor) {
            depth++;
            descendant = descendant.ancestor;
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
}
