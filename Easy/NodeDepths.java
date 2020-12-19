package Easy;

import java.util.*;

class Program {

    public static int nodeDepths(BinaryTree root) {

        // Time:  O(n)
        // Space: O(h) where h is the size of the BinaryTree

        List<Level> stack = new ArrayList<>();
        stack.add(new Level(root, 0));
        int sumOfDepth = 0;

        while (!stack.isEmpty()) {
            Level top = stack.remove(stack.size() - 1);
            BinaryTree node = top.tree;
            int depth = top.level;
            if (node == null) {
                continue;
            }

            sumOfDepth += (top.level);
            if (node.left != null) {
                stack.add(new Level(node.left, depth + 1));
            }
            if (node.right != null) {
                stack.add(new Level(node.right, depth + 1));
            }
        }

        return sumOfDepth;
    }

    static class Level {
        BinaryTree tree;
        int level;

        public Level(BinaryTree tree, int level) {
            this.tree = tree;
            this.level = level;
        }
    }

    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
}