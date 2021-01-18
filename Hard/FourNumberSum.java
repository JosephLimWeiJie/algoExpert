package VeryHard;

import java.util.*;

class Program {

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum) {

        // Time:  O(n ^ 2) on avg, O(n ^ 3) on worst
        // Space: O(n ^ 2) on avg, O(n ^ 3) on worst

        List<Integer[]> result = new ArrayList<>();
        Map<Integer, List<Integer[]>> map = new HashMap<>();

        for (int i = 1; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int currSum = array[i] + array[j];
                int diff = targetSum - currSum;
                if (map.containsKey(diff)) {
                    for (Integer[] pair : map.get(diff)) {
                        result.add(new Integer[] {pair[0], pair[1], array[i], array[j]});
                    }
                }
            }
            for (int k = 0; k < i; k++) {
                int currSum = array[i] + array[k];
                if (!map.containsKey(currSum)) {
                    List<Integer[]> toAdd = new ArrayList<>();
                    toAdd.add(new Integer[] {array[k], array[i]});
                    map.put(currSum, toAdd);
                } else {
                    map.get(currSum).add(new Integer[] {array[k], array[i]});
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[] {7, 6, 4, -1, 1, 2};
        int targetSum = 16;
        System.out.println(fourNumberSum(array, targetSum));
    }
}
