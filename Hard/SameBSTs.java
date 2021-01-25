package Hard;

import java.util.*;

class Program {

    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo) {

        // Time:  O(n ^ 2)
        // Space: O(d) where d is the depth of the BST

        return areSameBsts(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean areSameBsts(
            List<Integer> arrayOne, List<Integer> arrayTwo, int rootIdxOne, int rootIdxTwo, int minVal, int maxVal) {

        if (rootIdxOne == -1 || rootIdxTwo == -1) {
            return rootIdxOne == rootIdxTwo;
        }

        if (arrayOne.get(rootIdxOne) != arrayTwo.get(rootIdxTwo)) {
            return false;
        }

        int leftRootIdxOne = getIdxOfFirstSmaller(arrayOne, rootIdxOne, minVal);
        int leftRootIdxTwo = getIdxOfFirstSmaller(arrayTwo, rootIdxTwo, minVal);
        int rightRootIdxOne = getIdxOfFirstBiggerOrEqual(arrayOne, rootIdxOne, maxVal);
        int rightRootIdxTwo = getIdxOfFirstBiggerOrEqual(arrayTwo, rootIdxTwo, maxVal);

        int currVal = arrayOne.get(rootIdxOne);
        boolean leftAreSame = areSameBsts(arrayOne, arrayTwo, leftRootIdxOne, leftRootIdxTwo, minVal, currVal);
        boolean rightAreSame = areSameBsts(arrayOne, arrayTwo, rightRootIdxOne, rightRootIdxTwo, currVal, maxVal);

        return leftAreSame && rightAreSame;
    }

    public static int getIdxOfFirstSmaller(List<Integer> array, int startingIdx, int minVal) {
        for (int i = startingIdx + 1; i < array.size(); i++) {
            if (array.get(i) < array.get(startingIdx) && array.get(i) >= minVal) {
                return i;
            }
        }
        return -1;
    }

    public static int getIdxOfFirstBiggerOrEqual(List<Integer> array, int startingIdx, int maxVal) {
        for (int i = startingIdx + 1; i < array.size(); i++) {
            if (array.get(i) >= array.get(startingIdx) && array.get(i) < maxVal) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> arrayOne = Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11);
        List<Integer> arrayTwo = Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81);
        System.out.println(sameBsts(arrayOne, arrayTwo));
    }
}
