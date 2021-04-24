package prompt.medium;

import java.util.*;

public class HeightBalancedTree {

    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
    
        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        public int height;
        public boolean isBalanced;

        public TreeInfo(int height, boolean isBalanced) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
    
    public static boolean heightBalancedBinaryTree(BinaryTree tree) {
        TreeInfo treeInfo = getTreeInfo(tree);
        return treeInfo.isBalanced;
    }

    public static TreeInfo getTreeInfo(BinaryTree node) {
        if (node == null) {
            return new TreeInfo(-1, true);
        }

        TreeInfo leftTreeInfo = getTreeInfo(node.left);
        TreeInfo rightTreeInfo = getTreeInfo(node.right);

        boolean isBalanced = leftTreeInfo.isBalanced 
            && rightTreeInfo.isBalanced 
            && (Math.abs(leftTreeInfo.height - rightTreeInfo.height) <= 1);

        return new TreeInfo(Math.max(leftTreeInfo.height, rightTreeInfo.height) + 1, isBalanced);
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        root.left.right = new BinaryTree(5);
        root.right.right = new BinaryTree(6);
        root.left.right.left = new BinaryTree(7);
        root.left.right.right = new BinaryTree(8);
        boolean expected = true;
        boolean actual = heightBalancedBinaryTree(root);
        System.out.println(expected == actual);
    }
}
