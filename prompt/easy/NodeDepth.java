package prompt.easy;

public class NodeDepth {
    
    public static int nodeDepths(BinaryTree root) {
        return nodeDepths(root, 0);
    }

    public static int nodeDepths(BinaryTree root, int level) {
        if (root == null) {
            return 0;
        }

        return level + nodeDepths(root.left, level + 1) + nodeDepths(root.right, level + 1);
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
    public static void main(String[] args) {
        var root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.left.left = new BinaryTree(4);
        root.left.left.left = new BinaryTree(8);
        root.left.left.right = new BinaryTree(9);
        root.left.right = new BinaryTree(5);
        root.right = new BinaryTree(3);
        root.right.left = new BinaryTree(6);
        root.right.right = new BinaryTree(7);
        int actual = nodeDepths(root);
        System.out.println(actual);
        System.out.println(16 == actual);
    }
}
