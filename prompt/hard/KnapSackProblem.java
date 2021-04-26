package prompt.hard;

import java.util.*;

public class KnapSackProblem {
    
    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity) {
        List<List<Integer>> result = new ArrayList<>();

        int[][] values = new int[items.length + 1][capacity + 1];
        for (int i = 1; i < values.length; i++) {
            int itemValue = items[i - 1][0];
            int itemWeight = items[i - 1][1];
            for (int j = 0; j < values[i].length; j++) {
                // if can add current item into knapsack
                if (itemWeight <= j) {
                    int currRunningMaxValue = values[i - 1][j];
                    int newCurrRunningMaxValue = Math.max(values[i - 1][j - itemWeight] + itemValue, currRunningMaxValue);
                    values[i][j] = newCurrRunningMaxValue;
                } else {
                    values[i][j] = values[i - 1][j];
                }
            }
        }

        // printArray(values);
        int maxCapacityUsed = values[values.length - 1][values[0].length - 1];
        result.add(Arrays.asList(maxCapacityUsed));
        return getKnapSacks(values, result, items);
    }

    public static List<List<Integer>> getKnapSacks(int[][] values, List<List<Integer>> result, int[][] items) {
        int row = values.length - 1;
        int col = values[0].length - 1;
        List<Integer> toAdd = new ArrayList<>();

        while (row > 0) {
            // if value same as its row above, means current knapsack is not added so can move up one row
            if (values[row][col] == values[row - 1][col]) {
                row--;
            } else {
                int itemWeight = items[row - 1][1];
                row--;
                col -= itemWeight;
                toAdd.add(row);
            }
        }

        result.add(toAdd);
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
    
    public static void TestCase1() {
        int[][] input = {{1, 2}, {4, 3}, {5, 6}, {6, 7}};
        int[][] expected = {{10}, {1, 3}};
        System.out.println(compare(knapsackProblem(input, 10), expected));
    }
    
    private static boolean compare(List<List<Integer>> arr1, int[][] arr2) {
        Collections.sort(arr1.get(1));
        if (arr1.get(0).get(0) != arr2[0][0]) {
            return false;
        }
        if (arr1.get(1).size() != arr2[1].length) {
            return false;
        }
        for (int i = 0; i < arr1.get(1).size(); i++) {
            if (arr1.get(1).get(i) != arr2[1][i]) {
                return false;
            }
        }
        return true;
      }

    public static void main(String[] args) {
        TestCase1();
    }
}
