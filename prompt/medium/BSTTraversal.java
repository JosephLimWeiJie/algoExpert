package prompt.medium;

import java.util.*;

public class BSTTraversal {

    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array) {
        
        if (tree.left != null) {
            inOrderTraverse(tree.left, array);
        }

        array.add(tree.value);

        if (tree.right != null) {
            inOrderTraverse(tree.right, array);
        }

        return array;
    }
    
    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array) {
        array.add(tree.value);

        if (tree.left != null) {
            preOrderTraverse(tree.left, array);
        } 

        if (tree.right != null) {
            preOrderTraverse(tree.right, array);
        }

        return array;
    }
    
    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array) {
        if (tree.left != null) {
            preOrderTraverse(tree.left, array);
        } 

        if (tree.right != null) {
            preOrderTraverse(tree.right, array);
        }

        array.add(tree.value);
        
        return array;
    }
    
    public static class BST {
        public int value;
        public BST left;
        public BST right;
    
        public BST(int value) {
             this.value = value;
        }
    }


    public static void main(String[] args) {
        BST root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.right = new BST(22);

        System.out.println(preOrderTraverse(root, new ArrayList<>()));
        System.out.println(inOrderTraverse(root, new ArrayList<>()));
        System.out.println(postOrderTraverse(root, new ArrayList<>()));

    }
}