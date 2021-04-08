package prompt.medium;

import java.util.*;

public class MergeOverlappingIntervals {
    
    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        List<Integer[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(new Integer[] {
                Math.min(intervals[i][0], intervals[i][1]),
                Math.max(intervals[i][0], intervals[i][1])});
        }

        Collections.sort(list, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] first, Integer[] second) {
                return first[0].compareTo(second[0]);
            };
        });

        List<Integer[]> ans = new ArrayList<>();
        ans.add(list.get(0));

        for (int i = 1; i < list.size(); i++) {
            Integer[] currPair = list.get(i);
            Integer[] endPair = ans.get(ans.size() - 1);
            if (currPair[0] >= endPair[0] && currPair[0] <= endPair[1]) {
                // Overlapping occurs
                ans.remove(ans.size() - 1);
                ans.add(new Integer[] {endPair[0], Math.max(currPair[1], endPair[1])});
            } else {
                ans.add(currPair);
            }
        }

        int[][] convertedAns = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            Integer[] toConvert = ans.get(i);
            convertedAns[i] = new int[] {toConvert[0], toConvert[1]};
        }
        
        return convertedAns;
    }

    public static void main(String[] args) {
            int[][] intervals =
            new int[][] {
            {1, 22}, 
            {-20, 30},
            };
        int[][] expected =
            new int[][] {
            {-20, 30},
            };
        int[][] actual = mergeOverlappingIntervals(intervals);
        
        for (int i = 0; i < actual.length; i++) {
            for (int j = 0; j < actual[i].length; j++) {
                System.out.println(expected[i][j] == actual[i][j]);
            }
        }
    }
}
