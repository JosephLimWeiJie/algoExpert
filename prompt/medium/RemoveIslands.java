package prompt.medium;

import java.util.*;

public class RemoveIslands {
    
    public static int[][] removeIslands(int[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        // Top border
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 1) {
                visitNonImage(0, i, matrix, visited);
            }
        }

        // Bottom border
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[matrix.length - 1][i] == 1) {
                visitNonImage(matrix.length - 1, i, matrix, visited);
            }
        }

        // Left border
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 1) {
                visitNonImage(i, 0, matrix, visited);
            }
        }

        // Right border
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][matrix[0].length - 1] == 1) {
                visitNonImage(i, matrix[0].length - 1, matrix, visited);
            }
        }

        // Convert all '1's within the border to '0'
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[i].length - 1; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    matrix[i][j] = 0;
                }
            }
        }
        printMatrix(matrix);
        return matrix;
    }

    public static void visitNonImage(int row, int col, int[][] matrix, boolean[][] visited) {
        Queue<Integer[]> queue = new LinkedList();
        queue.add(new Integer[] {row, col});;
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            Integer[] currNode = queue.poll();
            visited[currNode[0]][currNode[1]] = true;
            List<Integer[]> neighbors = getNeighbors(currNode, matrix);
            
            for (Integer[] neighbor : neighbors) {
                if (!visited[neighbor[0]][neighbor[1]]) {
                    queue.add(neighbor);
                }
            }
        }
    }

    public static List<Integer[]> getNeighbors(Integer[] currNode, int[][] matrix) {
        List<Integer[]> neighbors = new ArrayList<>();
        int nodeRow = currNode[0];
        int nodeCol = currNode[1];

        // Add top
        if  (nodeRow - 1 >= 0 && matrix[nodeRow - 1][nodeCol] == 1) {
            neighbors.add(new Integer[] {nodeRow - 1, nodeCol});
        }

        // Add bottom
        if (nodeRow + 1 <= matrix.length - 1 && matrix[nodeRow + 1][nodeCol] == 1) {
            neighbors.add(new Integer[] {nodeRow + 1, nodeCol});
        }

        // Add left
        if (nodeCol - 1 >= 0 && matrix[nodeRow][nodeCol - 1] == 1) {
            neighbors.add(new Integer[] {nodeRow, nodeCol - 1});
        }

        // Add right
        if (nodeCol + 1 <= matrix[0].length - 1 && matrix[nodeRow][nodeCol + 1] == 1) {
            neighbors.add(new Integer[] {nodeRow, nodeCol + 1});
        }

        return neighbors;
    }

    public static void printMatrix(int[][] matrix) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(matrix[i][j] + ", ");
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void TestCase1() {
        int[][] input =
            new int[][] {
              {1, 0, 0, 0, 0, 0},
              {0, 1, 0, 1, 1, 1},
              {0, 0, 1, 0, 1, 0},
              {1, 1, 0, 0, 1, 0},
              {1, 0, 1, 1, 0, 0},
              {1, 0, 0, 0, 0, 1},
            };
        int[][] expected =
            new int[][] {
              {1, 0, 0, 0, 0, 0},
              {0, 0, 0, 1, 1, 1},
              {0, 0, 0, 0, 1, 0},
              {1, 1, 0, 0, 1, 0},
              {1, 0, 0, 0, 0, 0},
              {1, 0, 0, 0, 0, 1},
            };
        int[][] actual = removeIslands(input);

        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[i].length; j++) {
                System.out.println(actual[i][j] == expected[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        TestCase1();
    }
}
