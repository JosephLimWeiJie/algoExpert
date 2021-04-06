package prompt.easy;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class TwoSums {

    public static int[] twoSums(int[] array, int targetSum) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int currSum = array[left] + array[right];
            if (currSum == targetSum) {
                return new int[] {array[left], array[right]};
            } else if (currSum < targetSum) {
                left++;
            } else {
                right--;
            }
        }

        return new int[] {};
    }
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("../../input/two_sums.txt"))) {
            String arrLine = br.readLine();
            int targetSum = Integer.parseInt(br.readLine());
            
            String[] arrLineNums = arrLine.split(" ");
            List<Integer> arr = new ArrayList<>();
            for (String str : arrLineNums) {
                arr.add(Integer.parseInt(str));
            }
            
            int[] array = new int[arr.size()];
            for (int i = 0; i < arr.size(); i++) {
                array[i] = arr.get(i);
            }

            System.out.println(Arrays.toString(twoSums(array, targetSum)));
        } catch (FileNotFoundException foe) {
            System.out.println("Input file not found.");
        }


    }
}