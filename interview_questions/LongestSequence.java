package interview_questions;

import java.util.*;
import java.io.*;

public class LongestSequence {
    
    public static List<List<String>> readInput(BufferedReader br) {
        List<List<String>> input = new ArrayList<>();

        try {
            List<String> availableColors = new ArrayList<>();
            String[] colorArgs = br.readLine().split(", ");
            for (int i = 0; i < colorArgs.length; i++) {
                availableColors.add(colorArgs[i]);
            }

            List<String> array = new ArrayList<>();
            String[] args = br.readLine().split(", ");
            for (int i = 0; i < args.length; i++) {
                array.add(args[i]);
            }

            input.add(availableColors);
            input.add(array);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        return input;
    }

    public static List<String> longestSequence(List<String> availableColors, List<String> array) {
        List<String> colorsWithLongestSequence = new ArrayList<>();
        int max = 0;

        Map<String, Integer> colors = new HashMap<>();
        for (int i = 0; i < availableColors.size(); i++) {
            colors.put(availableColors.get(i), 0);
        }

        int runningCount = 0;
        for (int j = 1; j < array.size(); j++) {
            if (array.get(j).equals(array.get(j - 1))) {
                runningCount++;
            } else {
                if (runningCount >= max) {
                    max = runningCount;
                    colors.put(array.get(j - 1), runningCount);
                    runningCount = 0;
                }
            }
        }

        for (Map.Entry<String, Integer> entry : colors.entrySet()) {
            if (entry.getValue() == max) {
                colorsWithLongestSequence.add(entry.getKey());
            }
        }

        return colorsWithLongestSequence;
    }


    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("../input/longest_sequence.txt"))) {
            List<List<String>> input = readInput(br);
            List<String> availableColors = input.get(0);
            List<String> array = input.get(1); 
            System.out.println(longestSequence(availableColors, array)); 
        } catch (FileNotFoundException foe) { 
            System.out.println("Input file not found.");
        }
    }
}
