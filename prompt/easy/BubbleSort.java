package prompt.easy;

import java.io.*;
import java.util.*;

public class BubbleSort {
    
    public static int[] bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean hasSwapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    swap(array, j, j + 1);
                    hasSwapped = true;
                }
            }

            if (!hasSwapped) {
                break;
            }
        }

        return array;
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("../../input/bubble_sort.txt"))) {
            String line = br.readLine();
            List<Integer> arr = new ArrayList<>();

            for (String str : line.split(" ")) {
                arr.add(Integer.parseInt(str));
            }

            int[] array = arr.stream().mapToInt(i -> i).toArray();
            System.out.println(Arrays.toString(bubbleSort(array)));
        } catch (FileNotFoundException foe) {
            System.out.println("Input file not found.");
        }


    }
}
