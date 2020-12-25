package Medium;

import java.util.*;

class Program {

    public static int firstDuplicateValue(int[] array) {

        // Time:  O(n)
        // Space: O(n)

        Map<Integer, Integer> map = new HashMap<>();

        boolean hasFound = false;
        int ans = 0;
        for (int i = 0; i < array.length; i++) {
            if (map.containsKey(array[i])) {
                hasFound = true;
                ans = array[i];
                break;
            } else {
                map.put(array[i], 0);
            }
        }

        if (hasFound) {
            return ans;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[] {2, 1, 5, 2, 3, 3, 4};
        System.out.println(firstDuplicateValue(arr));
    }
}
