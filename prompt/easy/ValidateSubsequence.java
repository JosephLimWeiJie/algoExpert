package prompt.easy;

import java.util.*;
import java.io.*;

public class ValidateSubsequence {

    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int runningSequencePointer = 0;

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == sequence.get(runningSequencePointer)) {
                runningSequencePointer++;
                if (runningSequencePointer == sequence.size()) {
                    return true;
                }
            }
        }

        return false;
    }
    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("../input/validate_subsequence.txt"))) {
            String line = br.readLine();
            List<Integer> arr = new ArrayList<>();
            List<Integer> seq = new ArrayList<>();

            for (String str : line.split(" ")) {
                arr.add(Integer.parseInt(str));
            }

            String lineTwo = br.readLine();
            for (String str : line.split(" ")) {
                seq.add(Integer.parseInt(str));
            }

            System.out.println(isValidSubsequence(arr, seq));
        } catch (FileNotFoundException foe) {
            foe.printStackTrace();
        }
    }
}