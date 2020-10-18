import java.util.*;

class Program {
    public static int findClosestValueInBst(BST tree, int target) {

        // Time: O(logn) for average and O(n) for worst.
        // Space: O(logn) for average and O(n) for worst.

        return findClosestValueInBst(tree, target, tree.value);
    }

    public static int findClosestValueInBst(BST tree, int target, int closest) {
        if (Math.abs(target - closest) > Math.abs(target - tree.value)) {
            closest = tree.value;
        }

        if (target < tree.value && tree.left != null) {
            return findClosestValueInBst(tree.left, target, closest);
        } else if (target > tree.value && tree.right != null) {
            return findClosestValueInBst(tree.right, target, closest);
        } else {
            return closest;
        }

    }

    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
          this.value = value;
        }
    }
}
