package interview_questions;

import java.util.*;

public class BinaryTreeZigZagTraverse {
    
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        boolean isLeftToRight = true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();
            Deque<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode toRemove = queue.poll();

                if (toRemove.left != null) {
                    queue.add(toRemove.left);
                }

                if (toRemove.right != null) {
                    queue.add(toRemove.right);
                }

                if (isLeftToRight) {
                    levelList.addLast(toRemove.val);
                } else {
                    levelList.addFirst(toRemove.val);
                }
            }

            ans.add((List) levelList);
            isLeftToRight = !isLeftToRight;
        }

        return ans;
    }

    public static boolean compare(List<List<Integer>> list1, List<List<Integer>> list2) {
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list1.get(i).size(); j++) {
                if (list1.get(i).get(j) != list2.get(i).get(j)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        List<List<Integer>> expected = new ArrayList<>();
        expected.add(Arrays.asList(3));
        expected.add(Arrays.asList(20, 9));
        expected.add(Arrays.asList(15, 7));

        System.out.println(compare(expected, zigzagLevelOrder(tree)));
    }
}
