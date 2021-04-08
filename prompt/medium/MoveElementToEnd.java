package prompt.medium;

import java.util.*;

public class MoveElementToEnd {

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        int startIdx = 0;
        int endIdx = array.size() - 1;

        while (startIdx < endIdx) {
            if (array.get(startIdx) == toMove) {
                swap(array, startIdx, endIdx);
                endIdx--;
            } else {
                startIdx++;
            }
        }

        return array;
    }

    public static void swap(List<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<Integer>(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2));
        int toMove = 2;
        List<Integer> expectedStart = new ArrayList<Integer>(Arrays.asList(1, 3, 4));
        List<Integer> expectedEnd = new ArrayList<Integer>(Arrays.asList(2, 2, 2, 2, 2));
        List<Integer> output = moveElementToEnd(array, toMove);
        List<Integer> outputStart = output.subList(0, 3);
        outputStart.sort(Comparator.naturalOrder());
        List<Integer> outputEnd = output.subList(3, output.size());
        System.out.println(outputStart.equals(expectedStart));
        System.out.println(outputEnd.equals(expectedEnd));
    }
}
