import java.util.*;

class Program {
    // This is the class of the input root. Do not edit it.
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
          this.value = value;
          this.left = null;
          this.right = null;
        }
    }

    public static List<Integer> branchSums(BinaryTree root) {

        // Time: O(N) -> case where BST is skewed into linear
        // Space: O(N) -> case where 1/2 of tree are leaves, so O(0.5N) -> O(N)
        // where N is the number of nodes in the tree.

        return getBranchSum(root, 0, new ArrayList<Integer>());
    }

    public static List<Integer> getBranchSum(BinaryTree tree, int sum, List<Integer> ans) {
        if (tree == null) {
            // do nothing
        } else if (checkTreeIsLeaf(tree)) {
            ans.add(sum + tree.value);
        } else {
            getBranchSum(tree.left, (sum + tree.value), ans);
            getBranchSum(tree.right, (sum + tree.value), ans);
        }

        return ans;
    }

    public static boolean checkTreeIsLeaf(BinaryTree tree) {
        if (tree.left == null && tree.right == null) {
            return true;
        } else {
            return false;
        }
    }
}
