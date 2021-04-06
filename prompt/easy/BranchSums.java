package prompt.easy;

import java.util.*;

public class BranchSums {

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

    public static class TestBinaryTree extends BinaryTree {
        TestBinaryTree(int value) {
            super(value);
        }
    
        TestBinaryTree insert(List<Integer> values) {
            return insert(values, 0);
        }
    
        TestBinaryTree insert(List<Integer> values, int i) {
            if (i >= values.size()) return null;
    
            List<TestBinaryTree> queue = new ArrayList<TestBinaryTree>();
            queue.add(this);
            while (queue.size() > 0) {
                TestBinaryTree current = queue.get(0);
                queue.remove(0);
                if (current.left == null) {
                    current.left = new TestBinaryTree(values.get(i));
                    break;
                }
                queue.add((TestBinaryTree) current.left);
                    if (current.right == null) {
                    current.right = new TestBinaryTree(values.get(i));
                    break;
                }
                queue.add((TestBinaryTree) current.right);
            }
            insert(values, i + 1);
            return this;
        }
      }
    
    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> sums = new ArrayList<>();
        
        branchSums(root, sums, 0);
        return sums;
    }

    public static void branchSums(BinaryTree root, List<Integer> sums, int runningSum) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            sums.add(root.value + runningSum);
            return;
        }

        branchSums(root.left, sums, root.value + runningSum);
        branchSums(root.right, sums, root.value + runningSum);
    }

    public static void main(String[] args) {
        TestBinaryTree tree = new TestBinaryTree(1).insert(Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10));
        List<Integer> expected = new ArrayList<Integer>(Arrays.asList(15, 16, 18, 10, 11));
        System.out.println(branchSums(tree));
        System.out.println(branchSums(tree).equals(expected));
    }
}
