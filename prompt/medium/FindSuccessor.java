package prompt.medium;

import java.util.*;

public class FindSuccessor {
    
    static class BinaryTree {
        public int value;
        public BinaryTree left = null;
        public BinaryTree right = null;
        public BinaryTree parent = null;
    
        public BinaryTree(int value) {
            this.value = value;
        }
    }
    
    public static BinaryTree findSuccessor(BinaryTree tree, BinaryTree node) {
        // If right subtree exists, find left-most child
        if (node.right != null) {
            return getLeftMostChild(node.right);
        } else {
            // find first parent with a left child
            return getFirstParentWithLeftChild(node);
        }
    }

    public static BinaryTree getLeftMostChild(BinaryTree node) {
        BinaryTree currNode = node;

        while (currNode.left != null) {
            currNode = currNode.left;
        }

        return currNode;
    }

    public static BinaryTree getFirstParentWithLeftChild(BinaryTree node) {
        BinaryTree currNode = node;

        while (currNode.parent != null && currNode.parent.right == currNode) {
            currNode = currNode.parent;
        }

        return currNode.parent;
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.parent = root;
        root.right = new BinaryTree(3);
        root.right.parent = root;
        root.left.left = new BinaryTree(4);
        root.left.left.parent = root.left;
        root.left.right = new BinaryTree(5);
        root.left.right.parent = root.left;
        root.left.left.left = new BinaryTree(6);
        root.left.left.left.parent = root.left.left;
        BinaryTree node = root.left.right;
        BinaryTree expected = root;
        BinaryTree output = findSuccessor(root, node);
        System.out.println(expected == output);     
    }
}
