package Medium;

import java.util.*;

class Program {

    public static int[] searchInSortedMatrix(int[][] matrix, int target) {

        // Choose a starting point at top right and let it traverse diagonally to bottom left.
        // Time:  O(n + m) where n and m are the height and width of the matrix
        // Space: O(1)

        int rowIdx = 0;
        int colIdx = matrix[0].length - 1;

        while (rowIdx < matrix.length && colIdx >= 0) {
            if (matrix[rowIdx][colIdx] < target) {
                rowIdx++;
            } else if (matrix[rowIdx][colIdx] > target) {
                colIdx--;
            } else {
                return new int[] {rowIdx, colIdx};
            }
        }

        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 12, 15, 1000},
                          {2, 5, 19, 31, 32, 1001},
                          {3, 8, 24, 33, 35, 1002},
                          {40, 41, 42, 44, 45, 1003},
                          {99, 100, 103, 106, 128, 1004}};
        System.out.println(Arrays.toString(searchInSortedMatrix(matrix, 44)));
    }
}
