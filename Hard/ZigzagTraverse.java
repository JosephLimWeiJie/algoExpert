package Hard;

import java.util.*;

class Program {

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {

        // Time:  O(n)
        // Space: O(n)

        List<Integer> ans = new ArrayList<>();

        int row = 0;
        int col = 0;
        int height = array.size() - 1;
        int width = array.get(0).size() - 1;

        boolean goingDown = true;
        while (!isOutOfBounds(row, col, height, width)) {
            ans.add(array.get(row).get(col));

            if (goingDown) {
                if (col == 0 || row == height) {
                    goingDown = false;
                    if (row == height) {
                        // Going right
                        col++;
                    } else {
                        // Going down
                        row++;
                    }
                } else {
                    // go diagonally down-left
                    col--;
                    row++;
                }
            } else {
                if (row == 0 || col == width) {
                    goingDown = true;
                    if (col == width) {
                        row++;
                    } else {
                        col++;
                    }
                } else {
                    // go diagonally up-right
                    row--;
                    col++;
                }
            }
        }

        return ans;
    }

    public static boolean isOutOfBounds(int row, int col, int height, int width) {
        return row < 0 || row > height || col < 0 || col > width;
    }

    public static void main(String[] args) {
        List<List<Integer>> array = new ArrayList<>();
        array.add(Arrays.asList(1, 3, 4, 10));
        array.add(Arrays.asList(2, 5, 9, 11));
        array.add(Arrays.asList(6, 8, 12, 15));
        array.add(Arrays.asList(7, 13, 14, 16));
        System.out.println(zigzagTraverse(array));
    }
}
