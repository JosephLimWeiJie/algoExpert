package interview_questions;

import java.util.*;

public class ClosestTargetSum {
    
    public static int[] closestTargetSum(List<Integer> arr, int target) {
        Map<Integer, Integer> mapElementsToIdx = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            mapElementsToIdx.put(arr.get(i), i);
        }

        List<Integer> arrCopy = new ArrayList<>();
        arrCopy.addAll(arr);
        Collections.sort(arrCopy);
        int left = 0;
        int right = arr.size() - 1;

        int maxSum = Integer.MIN_VALUE;
        int leftValue = 0;
        int rightValue = 0;
        while (left < right) {
            int currSum = arrCopy.get(left) + arrCopy.get(right);
            if (currSum == target) {
                leftValue = arrCopy.get(left);
                rightValue = arrCopy.get(right);
                break;
            } else if (currSum < target) {
                if (currSum > maxSum) {
                    leftValue = arrCopy.get(left);
                    rightValue = arrCopy.get(right);
                    maxSum = currSum;
                }
                left++;
            } else {
                if (currSum > target) {
                    leftValue = arrCopy.get(left);
                    rightValue = arrCopy.get(right);
                    maxSum = currSum;
                }
                right--;
            }
        }

        int leftIdx = mapElementsToIdx.get(leftValue);
        int rightIdx = mapElementsToIdx.get(rightValue);
        return new int[] {leftIdx, rightIdx};
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(90, 80, 75, 110, 120, 160);
        int target = 250;
        int[] ans = closestTargetSum(arr, target);
        System.out.println(ans[0] == 0 && ans[1] == 5);

        List<Integer> arr2 = Arrays.asList(50, 80, 75);
        int target2 = 127;
        int[] ans2 = closestTargetSum(arr2, target2);
        System.out.println(ans2[0] == 0 && ans2[1] == 1);
    }
}
