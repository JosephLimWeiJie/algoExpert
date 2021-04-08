package prompt.medium;

import java.util.*;

public class ThreeSums {

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> ans = new ArrayList<>();
        Arrays.sort(array);

        for (int i = 0; i < array.length; i++) {
            int leftIdx = i + 1;
            int rightIdx = array.length - 1;
            while (leftIdx < rightIdx) {
                int currSum = array[i] + array[leftIdx] + array[rightIdx];
                if (currSum == targetSum) {
                    ans.add(new Integer[] {array[i], array[leftIdx], array[rightIdx]});
                    leftIdx++;
                    rightIdx--;
                } else if (currSum < targetSum) {
                    leftIdx++;
                } else {
                    rightIdx--;
                }
            }

        }
        
        return ans;
    }
    
    private static boolean compare(List<Integer[]> triplets1, List<Integer[]> triplets2) {
        if (triplets1.size() != triplets2.size()) return false;
        for (int i = 0; i < triplets1.size(); i++) {
            if (!Arrays.equals(triplets1.get(i), triplets2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer[]> expected = new ArrayList<Integer[]>();
        expected.add(new Integer[] {-8, 2, 6});
        expected.add(new Integer[] {-8, 3, 5});
        expected.add(new Integer[] {-6, 1, 5});
        List<Integer[]> output = threeNumberSum(new int[] {12, 3, 1, 2, -6, 5, -8, 6}, 0);
        System.out.println(compare(output, expected));
    }
}
