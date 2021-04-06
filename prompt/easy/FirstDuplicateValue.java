package prompt.easy;

import java.util.*;
import java.io.*;

public class FirstDuplicateValue {
    
    public static int firstDuplicateValue(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : array) {
            if (map.containsKey(num)) {
                return num;
            } else {
                map.put(num, 0);
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("../input/first_duplicate_value.txt"))) {
            String line = br.readLine();
            List<Integer> arr = new ArrayList<>();

            for (String str: line.split(" ")) {
                arr.add(Integer.parseInt(str));
            }

            int[] array = arr.stream().mapToInt(i -> i).toArray();
            System.out.println(firstDuplicateValue(array));
        } catch (FileNotFoundException foe) {
            System.err.println("Input file not found");
        }

    }
}
