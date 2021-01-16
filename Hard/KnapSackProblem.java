package Hard;

import java.util.*;

class Program {

    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {

        // Time:  O(n * c) where n is length of items and c is capacity.
        // Space: O(n * c)

        List<List<Integer>> result = new ArrayList<>();

                                  //  num of row | num of col
        int[][] arr  = new int[items.length + 1][capacity + 1];

        for (int i = 1; i < arr.length; i++) {
            int itemVal = items[i - 1][0];
            int itemWeight = items[i - 1][1];
            for (int j = 0; j < arr[i].length; j++) {
                if (itemWeight <= j) {
                    int currVal = arr[i - 1][j];
                    int maxVal = Math.max(arr[i - 1][j - itemWeight] + itemVal, currVal);
                    arr[i][j] = maxVal;
                } else {
                    arr[i][j] = arr[i - 1][j];
                }
            }
        }

        int maxCapacityUsed = arr[arr.length - 1][arr[0].length - 1];
        result.add(Arrays.asList(maxCapacityUsed));

        // printArray(arr);
        return getKnapSacks(result, arr, items);
    }

    public static List<List<Integer>> getKnapSacks(List<List<Integer>> result, int[][] arr, int[][] items) {
        int i = arr.length - 1;
        int j = arr[0].length - 1;
        List<Integer> arrayOfIndices = new ArrayList<>();
        while (i > 0) {
            if (arr[i][j] == arr[i - 1][j]) {
                i--;
                continue;
            } else {
                int itemValue = items[i - 1][0];
                int itemWeight = items[i - 1][1];
                i--;
                j -= itemWeight;
                arrayOfIndices.add(i);
            }
        }

        result.add(arrayOfIndices);
        return result;
    }

    public static void printArray(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j] + ", ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        int[][] items = new int[][] {{1, 2}, {4, 3}, {5, 6}, {6, 7}};
        int capacity = 10;
        System.out.println(knapsackProblem(items, capacity));
    }
}
