package Medium;

import java.util.*;

class Program {

    // Time:  O(wh)
    // Space: O(wh) where w is the width and h is the height of the river board.

    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> riverSizesList = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (visited[i][j] == true) {
                    continue;
                } else {
                    traverseRiver(matrix, i, j, visited, riverSizesList);
                }
            }
        }

        return riverSizesList;
    }

    public static void traverseRiver(
            int[][] matrix, int rowIdx, int colIdx, boolean[][] visited, List<Integer> riverSizesList) {

        int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        visited[rowIdx][colIdx] = true;

        if (matrix[rowIdx][colIdx] == 0) {
            return;
        }

        Queue<Integer[]> queue = new LinkedList<>();
        queue.add(new Integer[] {rowIdx,colIdx});
        int riverLength = 1;

        while (!queue.isEmpty()) {
            Integer[] currNode = queue.poll();
            int currNodeRow = currNode[0];
            int currNodeCol = currNode[1];

            for (int[] dir : directions) {
                int newRowIdx = currNodeRow + dir[0];
                int newColIdx = currNodeCol + dir[1];

                if (newRowIdx < 0 || newRowIdx >= matrix.length) {
                    continue;
                }

                if (newColIdx < 0 || newColIdx >= matrix[0].length) {
                    continue;
                }

                if (matrix[newRowIdx][newColIdx] == 1 && !visited[newRowIdx][newColIdx]) {
                    visited[newRowIdx][newColIdx] = true;
                    riverLength++;
                    queue.add(new Integer[] {newRowIdx, newColIdx});
                }

            }
        }

        if (riverLength > 0) {
            riverSizesList.add(riverLength);
        }

    }

    public static void main(String[] java) {
        int[][] matrixOne = new int[][] {{1, 0, 0, 1, 0},
                                         {1, 0, 1, 0, 0},
                                         {0, 0, 1, 0, 1},
                                         {1, 0, 1, 0, 1},
                                         {1, 0, 1, 1, 0}};

        int[][] matrixTwo = new int[][]{{1, 1, 0},
                                        {1, 0, 1},
                                        {1, 1, 1},
                                        {1, 1, 0},
                                        {1, 0, 1},
                                        {0, 1, 0},
                                        {1, 0, 0},
                                        {1, 0, 0},
                                        {0, 0, 0},
                                        {1, 0, 0},
                                        {1, 0, 1},
                                        {1, 1, 1}};
        System.out.println(riverSizes(matrixTwo));
    }
}

