package Medium;

import java.util.*;

class Program {

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {

        // Time:  O(n)
        // Space: O(1)

        int startIdx = 0;
        int endIdx = array.size() - 1;

        while (startIdx < endIdx) {
            int currNum = array.get(startIdx);
            if (currNum == toMove) {
                int temp = array.get(endIdx);
                array.set(endIdx, array.get(startIdx));
                array.set(startIdx, temp);
                endIdx--;
            } else {
                startIdx++;
            }
        }

        return array;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[] {2, 1, 2, 2, 2, 3, 4, 2};
        List<Integer> inputArr = new ArrayList<Integer>(Arrays.asList(arr));
        System.out.println(moveElementToEnd(inputArr, 2));
    }
}

