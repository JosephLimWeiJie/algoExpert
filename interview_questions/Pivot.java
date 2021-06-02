package interview_questions;

import java.util.*;

public class Pivot {

    public static int countPossiblePivot(int[] array) {
        int[] runningMaxArr = new int[array.length];
        int[] runningMinArr = new int[array.length];

        // left to right
        runningMaxArr[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            runningMaxArr[i] = Math.max(runningMaxArr[i - 1], array[i - 1]);
        }

        // right to left
        runningMinArr[array.length - 1] = array[array.length - 1];
        for (int i = array.length - 2; i >= 0; i--) {
            runningMinArr[i] = Math.min(runningMinArr[i + 1], array[i + 1]);
        }

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (runningMaxArr[i] <= array[i] && array[i] <= runningMinArr[i]) {
                count++;
            }
        }

        return count;
    }

    public static void readAndParseInput() {
        Scanner sc = new Scanner(System.in);
        int[] array = null;
        int n = 0;
        
        int i = 0;
        while (sc.hasNextLine() && i < 2) {
            if (i == 0) {
                n = Integer.parseInt(sc.nextLine());
                array = new int[n];
                i++;
            } else if (i == 1) {
                String[] strArr = sc.nextLine().split(" ");
                for (int j = 0; j < array.length; j++) {
                    array[j] = Integer.parseInt(strArr[j]);
                }
                i++;
            }
        }

        System.out.println(countPossiblePivot(array));
    }

    public static void main(String[] args) {
        readAndParseInput();
    }
}