package Medium;

import java.util.*;

class Program {

    public static BST minHeightBst(List<Integer> array) {

        // Time:  O(n)
        // Space: O(n)

        return constructMinHeightBST(array, 0, array.size() - 1);
    }

    public static BST constructMinHeightBST(List<Integer> array, int startIdx, int endIdx) {
        if (startIdx > endIdx) {
            return null;
        }

        int midIdx = (startIdx + endIdx) / 2;
        BST bst = new BST(array.get(midIdx));
        bst.left = constructMinHeightBST(array, startIdx, midIdx - 1);
        bst.right = constructMinHeightBST(array, midIdx + 1, endIdx);

        return bst;
    }


    static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
            left = null;
            right = null;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (left == null) {
                    left = new BST(value);
                } else {
                    left.insert(value);
                }
            } else {
                if (right == null) {
                    right = new BST(value);
                } else {
                    right.insert(value);
                }
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[] {1, 2, 5, 7, 10, 13, 14, 15, 22};
        List<Integer> list = Arrays.asList(arr);
        System.out.println(minHeightBst(list).toString());
    }
}

