package interview_questions;

import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class AdjacentDifference {

    public static List<List<Integer>> readInput(BufferedReader br) {
        List<List<Integer>> input = new ArrayList<>();
        try {
            String line = br.readLine();
            String[] lineArgs = line.split(",");
            String arrArgs = lineArgs[0];
            int order = Integer.parseInt(lineArgs[1]);

            String[] arr = arrArgs.split(" ");
            List<Integer> array = new ArrayList<>();
            for (int i = 0; i < arr.length; i++) {
                array.add(Integer.parseInt(arr[i]));
            }
            input.add(array);
            input.add(Arrays.asList(order));
            
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        
        return input;
    }

    public static List<Integer> adjacentDifference(List<Integer> array, int order) {
        for (int i = 0; i < order; i++) {
            if (array.size() <= 1) {
                break;
            }

            int runningIdx = 0;
            for (int j = 1; j < array.size(); j++) {
                int diff = array.get(j) - array.get(j - 1);
                array.set(runningIdx, diff);
                runningIdx++;
                
            }

            array.remove(array.size() - 1);
        }

        return array;
    }

    public static void printOutput(List<Integer> array) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < array.size(); i++) {
            if (i == array.size()) {
                sb.append(array.get(i));
            } else {
                sb.append(array.get(i) + " ");
            }
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("../input/adjacent_difference.txt"))) {
            List<List<Integer>> input = readInput(br);
            List<Integer> array = input.get(0);
            int order = input.get(1).get(0); 
            printOutput(adjacentDifference(array, order));
            
        } catch (FileNotFoundException foe) { 
            System.out.println("Input file not found.");
        }
    }
}  
