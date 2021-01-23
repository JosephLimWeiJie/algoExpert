package Hard;

import java.util.*;

class Program {

    public static int minRewards(int[] scores) {

        // Time:  O(n)
        // Space: O(n)

        int[] height = new int[scores.length];

        if (scores.length == 1) {
            return 1;
        }

        if (scores.length == 2) {
            return 3;
        }

        // Check if first/last element is a trough.
        if (scores[1] > scores[0]) {
            height[0] = 1;
        }

        if (scores[scores.length - 1] < scores[scores.length - 2]) {
            height[scores.length - 1] = 1;
        }

        for (int i = 1; i < scores.length - 1; i++) {
            if (scores[i - 1] > scores[i] && scores[i] < scores[i + 1]) {
                height[i] = 1;
            }
        }

        List<Integer> troughIdx = new ArrayList<>();
        for (int i = 0; i < height.length; i++) {
            if (height[i] == 1 && i == 0) {
                continue;
            }

            if (height[i] == 1 && i == height.length - 1) {
                continue;
            }

            if (height[i] == 1) {
                troughIdx.add(i);
            }
        }

        for (Integer idx : troughIdx) {
            expandTrough(idx, scores, height);
        }

        System.out.println(Arrays.toString(height));
        int minScores = 0;
        for (int i = 0; i < height.length; i++) {
            minScores += (height[i]);
        }

        return minScores;
    }

    public static void expandTrough(int idx, int[] scores, int[] height) {
        int leftIdx = idx;
        while (leftIdx - 1 >= 0 && (scores[leftIdx - 1] > scores[leftIdx])) {
            height[leftIdx - 1] = Math.max(height[leftIdx - 1], height[leftIdx] + 1);
            leftIdx--;
        }

        int rightIdx = idx;
        while (rightIdx + 1 < height.length && scores[rightIdx] < scores[rightIdx + 1]) {
            height[rightIdx + 1] = Math.max(height[rightIdx + 1], height[rightIdx] + 1);
            rightIdx++;
        }
    }

    public static void main(String[] args) {
        int[] scores = new int[] {800, 400, 20, 10, 30, 61, 70, 90,
                17, 21, 22, 13, 12, 11, 8, 4, 2, 1, 3, 6, 7, 9, 0,
                68, 55, 67, 57, 60, 51, 661, 50, 65, 53};
        System.out.println(minRewards(scores));
    }
}
