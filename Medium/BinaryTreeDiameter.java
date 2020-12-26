package Medium;

import java.util.*;

class Program {

    // This is an input class. Do not edit.
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    static class TreeInfo {
        public int diameter;
        public int height;

        public TreeInfo(int diameter, int height) {
            this.diameter = diameter;
            this.height = height;
        }
    }

    public int binaryTreeDiameter(BinaryTree tree) {

        // Time:  O(n)
        // Space: O(h) where h is the depth of the tree

        return getTreeInfo(tree).diameter;
    }

    public TreeInfo getTreeInfo(BinaryTree tree) {
        if (tree == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo leftTreeData = getTreeInfo(tree.left);
        TreeInfo rightTreeData = getTreeInfo(tree.right);
        int maxDiameter =
                (leftTreeData.diameter > rightTreeData.diameter) ? leftTreeData.diameter : rightTreeData.diameter;
        int longestPath = leftTreeData.height + rightTreeData.height;
        int currDiameter = (maxDiameter > longestPath) ? maxDiameter : longestPath;
        int maxHeight = (leftTreeData.height > rightTreeData.height) ? leftTreeData.height : rightTreeData.height;

        return new TreeInfo(currDiameter, 1 + maxHeight);
    }
}

