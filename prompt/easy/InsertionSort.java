package prompt.easy;

import java.util.*;
import java.io.*;
import java.util.stream.Stream;

public class InsertionSort {
    
    public static int[] insertionSort(int[] array) {
        int j;
        for (int i = 0; i < array.length; i++) {
            j = i;
            while (j > 0) {
                if (array[j] < array[j - 1]) {
                    swap(j, j - 1, array);
                }

                j--;
            }
        }
        
        return array;
    }

    public static void swap(int i, int j, int[] array) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    } 

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("../../input/insertion_sort.txt"))) {
            List<Integer> arr = new ArrayList<>();

            String line = br.readLine();
            String[] arrNums = line.split(" ");

            for (String num : arrNums) {
                arr.add(Integer.parseInt(num));
            }

            int[] array = arr.stream().mapToInt(i -> i).toArray();

            System.out.println(Arrays.toString(insertionSort(array)));
        } catch (FileNotFoundException foe) {
            System.out.println("Input file cannot be found.");
        }
    }
}
