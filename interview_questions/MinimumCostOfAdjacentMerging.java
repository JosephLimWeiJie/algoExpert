package interview_questions;

import java.util.*;

public class MinimumCostOfAdjacentMerging {

    public static int minimumCostOfAdjacentMerging(List<Integer> array) {
        int cost = 0;

        Deque<Integer> deque = new LinkedList<>();
        deque.addAll(array);

        boolean isLeftSide = false;
        while (deque.size() >= 2) {
            int firstLeft = deque.pollFirst();
            int secondLeft = deque.pollFirst();
            int leftCombined = firstLeft + secondLeft;
            deque.addFirst(secondLeft);
            deque.addFirst(firstLeft);

            int firstRight = deque.pollLast();
            int secondRight = deque.pollLast();
            int rightCombined = firstRight + secondRight;
            deque.addLast(secondRight);
            deque.addLast(firstRight);

            int toAdd = Math.min(leftCombined, rightCombined);
            isLeftSide = (toAdd == leftCombined) ? true : false;
            if (isLeftSide) {
                cost += leftCombined;
                deque.pollFirst();
                deque.pollFirst();
                deque.addFirst(leftCombined);
            } else {
                cost += rightCombined;
                deque.pollLast();
                deque.pollLast();
                deque.addLast(rightCombined);
            }
        }
        
        return cost;
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3);
        List<Integer> arr2 = Arrays.asList(1, 3, 5, 2);

        System.out.println(minimumCostOfAdjacentMerging(arr) == 9);
        System.out.println(minimumCostOfAdjacentMerging(arr2) == 22);
    }
}
