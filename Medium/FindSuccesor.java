package Medium;

import java.util.*;

class Program {
    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {

        // Time:  O(h) where h is the height of the tree
        // Space: O(1)

        if (node.right != null) {
            return getLeftmostChild(node);
        } else {
            return getRightmostParent(node);
        }
    }

    public BinaryTree getLeftmostChild(BinaryTree node) {
        BinaryTree currNode = node.right;

        while (currNode.left != null) {
            currNode = currNode.left;
        }

        return currNode;
    }

    public BinaryTree getRightmostParent(BinaryTree node) {
        BinaryTree currNode = node;

        while (currNode.parent != null && currNode.parent.right == currNode) {
            currNode = currNode.parent;
        }

        return currNode.parent;
    }
}
