package prompt.medium;

import java.util.*;

public class RiverSizes {

    public static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static List<Integer> riverSizes(int[][] matrix) {
        List<Integer> rivers = new ArrayList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    int currRiverLength = 0;
                    int riverLength = getRiverLength(matrix, visited, i, j, currRiverLength);
                    rivers.add(riverLength);
                }
            }
        }
        System.out.println(rivers);
        return rivers;
    }

    public static int getRiverLength(int[][] matrix, boolean[][] visited, int row, int col, int currRiverLength) {
        Queue<Pair> queue = new LinkedList<>();
        
        queue.add(new Pair(row, col));
        visited[row][col] = true;
        currRiverLength++;

        while (!queue.isEmpty()) {
            Pair currNode = queue.poll();
            List<Pair> neighbors = getNeighbors(currNode, matrix);
            for (Pair neighbor : neighbors) {
                if (!visited[neighbor.first][neighbor.second] && matrix[neighbor.first][neighbor.second] == 1) {
                    visited[neighbor.first][neighbor.second] = true;
                    queue.add(neighbor);
                    currRiverLength++;
                }
            }
        }

        return currRiverLength;
    }

    public static List<Pair> getNeighbors(Pair currNode, int[][] matrix) {
        List<Pair> neighbors = new ArrayList<>();
        
        int nodeRow = currNode.first;
        int nodeCol = currNode.second;
        
        // Top
        neighbors.add(new Pair(Math.max(0, nodeRow - 1), nodeCol));
        // Bottom
        neighbors.add(new Pair(Math.min(nodeRow + 1, matrix.length - 1), nodeCol));
        // Left
        neighbors.add(new Pair(nodeRow, (Math.max(0, nodeCol - 1))));
        // Right
        neighbors.add(new Pair(nodeRow, (Math.min(nodeCol + 1, matrix[0].length - 1))));

        return neighbors;
    }
    
    public static boolean compare(List<Integer> arr1, int[] arr2) {
        if (arr1.size() != arr2.length) {
            return false;
        }

        for (int i = 0; i < arr1.size(); i++) {
            if (arr1.get(i) != arr2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[][] input = {
            {1, 0, 0, 1, 0},
            {1, 0, 1, 0, 0},
            {0, 0, 1, 0, 1},
            {1, 0, 1, 0, 1},
            {1, 0, 1, 1, 0},
        };
        int[] expected = {1, 2, 2, 2, 5};
        List<Integer> output = riverSizes(input);
        Collections.sort(output);
        System.out.println(compare(output, expected));
    }
}
