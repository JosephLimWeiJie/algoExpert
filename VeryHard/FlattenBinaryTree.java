package VeryHard;

import java.util.*;

class Program {

    public static BinaryTree flattenBinaryTree(BinaryTree root) {

        // Time:  O(n) where n is the number of nodes in the tree
        // Space: O(d) where d is the depth of the tree

        BinaryTree[] flatTree = flattenTree(root);
        return flatTree[0];
    }

    public static BinaryTree[] flattenTree(BinaryTree node) {
        BinaryTree leftMost;
        BinaryTree rightMost;

        if (node.left == null) {
            leftMost = node;
        } else {
            BinaryTree[] leftSubtree = flattenTree(node.left);
            connectNodes(leftSubtree[1], node);
            leftMost = leftSubtree[0];
        }

        if (node.right == null) {
            rightMost = node;
        } else {
            BinaryTree[] rightSubtree = flattenTree(node.right);
            connectNodes(node, rightSubtree[0]);
            rightMost = rightSubtree[1];
        }

        return new BinaryTree[] {leftMost, rightMost};
    }

    public static void connectNodes(BinaryTree left, BinaryTree right) {
        left.right = right;
        right.left = left;
    }

    // This is the class of the input root. Do not edit it.
    static class BinaryTree {
        int value;
        BinaryTree left = null;
        BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(this.value);
        }
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);

        BinaryTree one = new BinaryTree(5);
        one.left = new BinaryTree(7);
        one.right = new BinaryTree(8);

        BinaryTree two = new BinaryTree(2);
        two.left = new BinaryTree(4);
        two.right = one;

        BinaryTree three = new BinaryTree(3);
        three.left = new BinaryTree(6);

        root.left = two;
        root.right = three;

        System.out.println(flattenBinaryTree(root));


    }
}
