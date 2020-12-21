package Medium;

import java.util.*;

class Program {

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {

        // Time:  O(n^2)
        // Space: O(n)
        List<Integer[]> ans = new ArrayList<>();

        Arrays.sort(array);

        for (int i = 0; i < array.length - 2; i++) {
            int left = i + 1;
            int right = array.length - 1;

            while (left < right) {
                int currSum = array[i] + array[left] + array[right];
                if (currSum > targetSum) {
                    right--;
                } else if (currSum < targetSum) {
                    left++;
                } else if (currSum == targetSum) {
                    Integer[] subAns = new Integer[]{array[i], array[left], array[right]};
                    ans.add(subAns);
                    left++;
                    right--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr =  new int[]{12, 3, 1, 2, -6, 5, -8, 6};
        System.out.println(threeNumberSum(arr, 0));
    }

}

