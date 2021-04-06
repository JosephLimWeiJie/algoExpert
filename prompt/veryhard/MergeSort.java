package prompt.veryhard;

import java.io.*;
import java.util.*;

public class MergeSort {
    
    public static int[] mergeSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        
        int mid = array.length / 2;
        int[] leftArr = Arrays.copyOfRange(array, 0, mid);
        int[] rightArr = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(leftArr), mergeSort(rightArr));
    }

    public static int[] merge(int[] firstArr, int[] secondArr) {
        int[] mergedArr = new int[firstArr.length + secondArr.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < firstArr.length && j < secondArr.length) {
            if (firstArr[i] <= secondArr[j]) {
                mergedArr[k++] = firstArr[i++];
            } else {
                mergedArr[k++] = secondArr[j++];
            }
        }

        while (i < firstArr.length) {
            mergedArr[k++] = firstArr[i++];

        }

        while (j < secondArr.length) {
            mergedArr[k++] = secondArr[j++];
        }

        return mergedArr;
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("../../input/merge_sort.txt"))) {
            String line = br.readLine();
            List<Integer> arr = new ArrayList<>();

            for (String str : line.split(" ")) {
                arr.add(Integer.parseInt(str));
            }

            int[] array = arr.stream().mapToInt(i -> i).toArray();
            System.out.println(Arrays.toString(mergeSort(array)));
        } catch (FileNotFoundException foe) {
            System.out.println("Input file not found");
        }
    }
}
