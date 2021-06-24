package prompt.medium;

import java.util.*;

public class Permutations {

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<>();
        getPermutations(array, new ArrayList<Integer>(), permutations);
        return permutations;
    }

    public static void getPermutations(List<Integer> array, List<Integer> currPermutations, List<List<Integer>> permutations) {
        if (array.size() == 0 && currPermutations.size() > 0) {
            permutations.add(currPermutations);
        } else {
            for (int i = 0; i < array.size(); i++) {
                List<Integer> tempArr = new ArrayList<>(array);
                tempArr.remove(i);
                List<Integer> newPermutation = new ArrayList<Integer>(currPermutations);
                newPermutation.add(array.get(i));
                getPermutations(tempArr, newPermutation, permutations);
            }
        }
    }
    
    public static void TestCase1() {
        List<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 2, 3));
        List<List<Integer>> perms = getPermutations(input);
        System.out.println(perms.size() == 6);
        System.out.println(contains(perms, new ArrayList<Integer>(Arrays.asList(1, 2, 3))));
        System.out.println(contains(perms, new ArrayList<Integer>(Arrays.asList(1, 3, 2))));
        System.out.println(contains(perms, new ArrayList<Integer>(Arrays.asList(2, 1, 3))));
        System.out.println(contains(perms, new ArrayList<Integer>(Arrays.asList(2, 3, 1))));
        System.out.println(contains(perms, new ArrayList<Integer>(Arrays.asList(3, 1, 2))));
        System.out.println(contains(perms, new ArrayList<Integer>(Arrays.asList(3, 2, 1))));
    }
    
    public static boolean contains(List<List<Integer>> arr1, List<Integer> arr2) {
        for (List<Integer> subArray : arr1) {
            if (subArray.equals(arr2)) {
            return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TestCase1();
    }
}
