package prompt.easy;

import java.io.FileNotFoundException;
import java.util.*;
import java.io.*;

public class SelectionSort {
    
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int currMinIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[currMinIndex]) {
                    currMinIndex = j;
                }
            }
            swap(i, currMinIndex, array);
        }

        return array;
    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("../../input/selection.sort"))) {
            String line = br.readLine();
            List<Integer> arr = new ArrayList<>();

            for (String num : line.split(" ")) {
                arr.add(Integer.parseInt(num));
            }

            int[] array = arr.stream().mapToInt(i -> i).toArray();
            System.out.println(Arrays.toString(selectionSort(array)));
        } catch (FileNotFoundException foe) {
            System.out.println("Input file not found.");
        }
    }
}
