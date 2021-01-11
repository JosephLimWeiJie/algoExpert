package Medium;

import java.util.*;

class Program {

    public static int[][] removeIslands(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                boolean rowIsBorder = (i == 0) || (i == matrix.length - 1);
                boolean colIsBorder = (j == 0) || (j == matrix[i].length - 1);
                boolean isBorder = rowIsBorder || colIsBorder;

                if (!isBorder) {
                    continue;
                }

                if (matrix[i][j] != 1) {
                    continue;
                }

                changeOnesConnectedToBorderToTwos(matrix, i, j);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] = 0;
                } else if (matrix[i][j] == 2) {
                    matrix[i][j] = 1;
                }
            }
        }

        return matrix;
    }

    public static void changeOnesConnectedToBorderToTwos(int[][] matrix, int row, int col) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {row, col});

        while (!stack.isEmpty()) {
            int[] currPos = stack.pop();
            int currRow = currPos[0];
            int currCol = currPos[1];

            matrix[currRow][currCol] = 2;
            int[][] neighbors = getNeighbours(matrix, currRow, currCol);
            for (int[] neighbor : neighbors) {
                int nextRow = neighbor[0];
                int nextCol = neighbor[1];

                if (matrix[nextRow][nextCol] != 1) {
                    continue;
                }

                stack.push(new int[] {nextRow, nextCol});
            }
        }
    }

    public static int[][] getNeighbours(int[][] matrix, int row, int col) {
        int numRows = matrix.length;
        int numCols = matrix[row].length;
        ArrayList<int[]> temp = new ArrayList<>();

        if (row - 1 >= 0) {
            temp.add(new int[] {row - 1, col}); // UP
        }

        if (row + 1 < numRows) {
            temp.add(new int[] {row + 1, col}); // DOWN
        }

        if (col - 1 >= 0) {
            temp.add(new int[] {row, col - 1}); // LEFT
        }

        if (col + 1 < numCols) {
            temp.add(new int[] {row, col + 1}); // RIGHT
        }

        int[][] neighbors = new int[temp.size()][2];

        for (int i = 0; i < temp.size(); i++) {
            neighbors[i] = temp.get(i);
        }

        return neighbors;
    }

    public static String printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            sb.append("{");
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j]);
                sb.append(", ");
            }
            sb.append("}");
            sb.append("\n");
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 0, 0, 0, 0},
                          {0, 1, 0, 1, 1, 1},
                          {0, 0, 1, 0, 1, 0},
                          {1, 1, 0, 0, 1, 0},
                          {1, 0, 1, 1, 0, 0},
                          {1, 0, 0, 0, 0, 1}};
        System.out.println(printMatrix(removeIslands(matrix)));
        //System.out.println(printMatrix(matrix));
    }
}
