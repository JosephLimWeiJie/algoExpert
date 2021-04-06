package prompt.easy;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class BinarySearch {

    /** Note that binarySearch returns the index of a target when found, and -1 otherwise. */
    public static int binarySearch(int[] array, int target) {
        return binarySearch(array, target, 0, array.length - 1);
    }

    public static int binarySearch(int[] array, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        
        int mid = (start + end) / 2;
        if (array[mid] == target) {
            return mid;
        } else if (array[mid] > target) {
            return binarySearch(array, target, start, mid - 1);
        } else {
            return binarySearch(array, target, mid + 1, end);
        }
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("../../input/binary_search.txt"))) {
            String line = br.readLine();
            int target = Integer.parseInt(br.readLine());
            List<Integer> arr = new ArrayList<>();

            for (String str : line.split(" ")) {
                arr.add(Integer.parseInt(str));
            }

            int[] array = arr.stream().mapToInt(i -> i).toArray();
            System.out.println(binarySearch(array, target));
        } catch (FileNotFoundException foe) {
            System.out.println("Input file not found");
        }
    }
}