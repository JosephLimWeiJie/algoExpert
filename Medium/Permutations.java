package Medium;

import java.util.*;

class Program {

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        // Time:  O(n x n!)
        // Space  O(n x n!)
        List<List<Integer>> allPerms = new ArrayList<>();
        getPermutations(array, new ArrayList<Integer>(), allPerms);
        return allPerms;

    }

    public static void getPermutations(List<Integer> arr, List<Integer> currPerm, List<List<Integer>> allPerms) {
        if (arr.size() == 0 && currPerm.size() > 0) {
            allPerms.add(currPerm);
        } else {
            for (int i = 0; i < arr.size(); i++) {
                List<Integer> newArr = new ArrayList<>(arr);
                newArr.remove(i);
                List<Integer> newPerm = new ArrayList<>(currPerm);
                newPerm.add(arr.get(i));
                getPermutations(newArr, newPerm, allPerms);
            }
        }
    }
}
