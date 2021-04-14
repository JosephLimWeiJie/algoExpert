package prompt.medium;

public class ValidateBST {

    public static boolean validateBst(BST tree) {
        return validateBst(tree, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    public static boolean validateBst(BST tree, int max, int min) {
        if (tree.value >= max || tree.value < min) {
            return false;
        }

        if (tree.left != null && !validateBst(tree.left, tree.value, min)) {
            return false;
        }

        if (tree.right != null && !validateBst(tree.right, max, tree.value)) {
            return false;
        }

        return true;
    }
    
    static class BST {
        public int value;
        public BST left;
        public BST right;
    
        public BST(int value) {
        this.value = value;
        }
    }

    public static void main(String[] args) {
        var root = new BST(10);
        root.left = new BST(5);
        root.left.left = new BST(2);
        root.left.left.left = new BST(1);
        root.left.right = new BST(5);
        root.right = new BST(15);
        root.right.left = new BST(13);
        root.right.left.right = new BST(14);
        root.right.right = new BST(22);
    
        System.out.println(validateBst(root));
    }
}
