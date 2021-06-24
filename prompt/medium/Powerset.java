package prompt.medium;

import java.util.*;

public class Powerset {
    
    public static List<List<Integer>> powerset(List<Integer> array) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        
        for (Integer ele : array) {
            int length = ans.size();
            for (int i = 0; i < length; i++) {
                List<Integer> currSubset = new ArrayList<>(ans.get(i));
                currSubset.add(ele);
                ans.add(currSubset);
            }
        }

        return ans;
    }

    public static void TestCase1() {
        List<List<Integer>> output = powerset(new ArrayList<Integer>(Arrays.asList(1, 2, 3)));
        System.out.println(output.size() == 8);
        System.out.println(contains(output, new int[] {}));
        System.out.println(contains(output, new int[] {1}));
        System.out.println(contains(output, new int[] {2}));
        System.out.println(contains(output, new int[] {1, 2}));
        System.out.println(contains(output, new int[] {3}));
        System.out.println(contains(output, new int[] {1, 3}));
        System.out.println(contains(output, new int[] {2, 3}));
        System.out.println(contains(output, new int[] {1, 2, 3}));
    }
    
    public static boolean contains(List<List<Integer>> arr1, int[] arr2) {
        for (List<Integer> subArr : arr1) {
            Collections.sort(subArr);
            if (compare(subArr, arr2)) {
                return true;
            }
        }
        return false;
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
        TestCase1();
    }
}
