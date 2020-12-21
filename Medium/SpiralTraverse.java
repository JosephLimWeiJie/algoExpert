package Medium;

import java.lang.reflect.Array;
import java.util.*;

class Program {

    public static List<Integer> spiralTraverse(int[][] array) {

        // Time:  O(n)
        // Space: O(n)

        List<Integer> ans = new ArrayList<>();

        if (array.length == 0) {
            return new ArrayList<Integer>();
        }

        int startRow = 0;
        int startCol = 0;
        int endRow = array.length - 1;
        int endCol = array[0].length - 1;

        while (startRow <= endRow && startCol <= endCol) {
            // Top left to top right
            for (int i = startCol; i <= endCol; i++) {
                ans.add(array[startRow][i]);
            }

            // Top right to bottom right
            for (int i = startRow + 1; i <= endRow; i++) {
                ans.add(array[i][endCol]);
            }

            // Bottom right to bottom left
            for (int i = endCol - 1; i >= startCol; i--) {
                if (startRow == endRow) {
                    break;
                }
                ans.add(array[endRow][i]);
            }

            // Bottom left to top left
            for (int i = endRow - 1; i > startRow; i--) {
                if (startCol == endCol) {
                    break;
                }
                ans.add(array[i][startCol]);

            }

            startRow++;
            endCol--;
            endRow--;
            startCol++;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[][] input = new int[][] {
                { 1,  2,  3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10,  9,  8, 7}};
        System.out.println(spiralTraverse(input));
    }
}
