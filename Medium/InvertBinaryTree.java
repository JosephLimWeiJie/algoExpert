package Medium;

import java.util.*;

class Program {

    public static void invertBinaryTree(BinaryTree tree) {

        // Time:  O(n)
        // Space: O(d) where d is the depth of the tree

        if (tree == null) {
            return;
        }

        swapLeftAndRight(tree);
        invertBinaryTree(tree.left);
        invertBinaryTree(tree.right);
    }

    public static void swapLeftAndRight(BinaryTree tree) {
        BinaryTree left = tree.left;
        tree.left = tree.right;
        tree.right = left;
    }

    static class BinaryTree {
        public int value;
        public BinaryTree left;
        public BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }
}
