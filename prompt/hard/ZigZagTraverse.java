package prompt.hard;

import java.util.*;

public class ZigZagTraverse {

    public static List<Integer> zigzagTraverse(List<List<Integer>> array) {
        List<Integer> ans = new ArrayList<>();

        int height = array.size() - 1;
        int width = array.get(0).size() - 1;

        int row = 0;
        int col = 0;
        boolean isGoingDown = true;
        while (!isOutOfBounds(row, col, height, width)) {
            ans.add(array.get(row).get(col));

            if (isGoingDown) {
                if (col == 0 || row == height) {
                    isGoingDown = !isGoingDown;
                    if (row == height) {
                        // go right
                        col++;
                    } else {
                        row++;
                    }           
                } else {
                    // go diagonally down-left
                    row++;
                    col--;
                }
            } else {
                if (row == 0 || col == width) {
                    isGoingDown = !isGoingDown;
                    if (col == width) {
                        // go down
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
 
    public static void TestCase1() {
        List<List<Integer>> test = new ArrayList<List<Integer>>();
        test.add(new ArrayList<Integer>(Arrays.asList(1, 3, 4, 10)));
        test.add(new ArrayList<Integer>(Arrays.asList(2, 5, 9, 11)));
        test.add(new ArrayList<Integer>(Arrays.asList(6, 8, 12, 15)));
        test.add(new ArrayList<Integer>(Arrays.asList(7, 13, 14, 16)));
        List<Integer> expected =
            new ArrayList<Integer>(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16));
        System.out.println(zigzagTraverse(test).equals(expected));
    }

    public static void main(String[] args) {
        TestCase1();
    }
}