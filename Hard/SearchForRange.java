package Hard;

import java.util.*;

class Program {

    public static int[] searchForRange(int[] array, int target) {

        // Time:  O(log(n))
        // Space: O(1)

        int targetIdx = BinarySearchRange(array, target, 0, array.length - 1);

        if (targetIdx == -1) {
            return new int[] {-1, -1};
        }

        int[] range = findRangeFromTargetIdx(array, targetIdx);

        return range;
    }

    public static int[] findRangeFromTargetIdx(int[] array, int targetIdx) {
        int val = array[targetIdx];
        int startRange = targetIdx;
        int endRange = targetIdx;

        while (true) {
            int nextStart = startRange - 1;
            if (nextStart < 0) {
                break;
            }

            if (array[nextStart] == val) {
                startRange--;
                continue;
            } else {
                break;
            }
        }

        while (true) {
            int nextEnd = endRange + 1;
            if (nextEnd > array.length - 1) {
                break;
            }

            if (array[nextEnd] == val) {
                endRange++;
                continue;
            } else {
                break;
            }
        }

        return new int[] {startRange, endRange};
    }

    public static int BinarySearchRange(int[] array, int target, int start, int end) {
        if (start > end) {
            return  -1;
        }

        int mid = (start + end) / 2;

        if (array[mid] == target) {
            return mid;
        } else if (array[mid] < target) {
            return BinarySearchRange(array, target, mid + 1, end);
        } else {
            return BinarySearchRange(array, target, start, mid - 1);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[] {5, 7, 7, 8, 8, 10};
        int target = 10;
        System.out.println(Arrays.toString(searchForRange(array, target)));
    }
}
