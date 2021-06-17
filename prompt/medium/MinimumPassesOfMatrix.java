package prompt.medium;

import java.util.*;

public class MinimumPassesOfMatrix {
    
    public static int minimumPassesOfMatrix(int[][] matrix) {
        int passes = 0;
        Queue<Integer[]> queue = new LinkedList();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > 0) {
                    queue.add(new Integer[] {i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int currQueueSize = queue.size();

            while (currQueueSize > 0) {
                Integer[] node = queue.poll();

                List<Integer[]> neighbors = getNeighbors(node[0], node[1], matrix);
                for (Integer[] neighbor : neighbors) {
                    if (matrix[neighbor[0]][neighbor[1]] < 0) {
                        matrix[neighbor[0]][neighbor[1]] = -1 * matrix[neighbor[0]][neighbor[1]];
                        queue.add(new Integer[] {neighbor[0], neighbor[1]});
                    }
                }

                currQueueSize -= 1;
            }

            passes++;
        }
        
        boolean isAllPositive = containsAllPositive(matrix);
        System.out.println(passes);
        if (isAllPositive) {
            return passes - 1;
        } else {
            return - 1;
        }
    }

    public static List<Integer[]> getNeighbors(int row, int col, int[][] matrix) {
        List<Integer[]> neighbors = new ArrayList<>();

        if (row > 0) {
            neighbors.add(new Integer[] {row - 1, col});
        } 

        if (row < matrix.length - 1) {
            neighbors.add(new Integer[] {row + 1, col});
        }

        if (col > 0) {
            neighbors.add(new Integer[] {row, col - 1});
        }

        if (col < matrix[row].length - 1) {
            neighbors.add(new Integer[] {row, col + 1});
        }

        return neighbors;
    }

    public static boolean containsAllPositive(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] < 0) {
                    return false;
                }
            }
        }

        return true;
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
        int[][] matrix = new int[][] {{0, -1, -3, 2, 0}, {1, -2, -5, -1, -3}, {3, 0, 0, -4, -1}};
        int expected = 3;
        int actual = minimumPassesOfMatrix(matrix);
        System.out.println(expected == actual);
    }

    public static void main(String[] args) {
        TestCase1();
    }
}
