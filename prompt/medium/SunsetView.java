package prompt.medium;

import java.util.*;

public class SunsetView {
    
    public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        ArrayList<Integer> result = new ArrayList<>();

        if (buildings.length == 0) {
            return result;
        }

        int[] runningHeight = new int[buildings.length];
        int currHighestHeight = Integer.MIN_VALUE;
        if (direction.equals("EAST")) {
            runningHeight[buildings.length - 1] = buildings[buildings.length - 1];
            currHighestHeight = buildings[buildings.length - 1];
            result.add(buildings.length - 1);
            for (int i = buildings.length - 2; i >= 0; i--) {
                if (buildings[i] > runningHeight[i + 1]) {
                    if (buildings[i] > currHighestHeight) {
                        currHighestHeight = buildings[i];
                        runningHeight[i] = currHighestHeight;
                        result.add(i);
                    }
                }
            }
            Collections.reverse(result);
        } else {
            result.add(0);
            currHighestHeight = buildings[0];
            runningHeight[0] = buildings[0];
            for (int i = 1; i < buildings.length; i++) {
                if (buildings[i] > runningHeight[i - 1]) {
                    if (buildings[i] > currHighestHeight) {
                        currHighestHeight = buildings[i];
                        runningHeight[i] = currHighestHeight;
                        result.add(i);
                    }
                }
            }
        }

        return result;
    }

    public static void TestCase1() {
        int[] buildings = new int[] {3, 5, 4, 4, 3, 1, 3, 2};
        String direction = "EAST";
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(3);
        expected.add(6);
        expected.add(7);
        var actual = sunsetViews(buildings, direction);
        System.out.println(expected.equals(actual));
      }

    public static void main(String[] args) {
        TestCase1();
    }

}
