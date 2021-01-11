package Medium;

import java.util.*;

class Program {

    public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {

        // Time:  O(n)
        // Space: O(n)

        ArrayList<Integer> result = new ArrayList<>();
        int[] runningHeight = new int[buildings.length];
        int currRunningHighestHeight;

        if (buildings.length == 0) {
            return result;
        }

        switch (direction) {
        case "EAST":
            result.add(buildings.length - 1);

            runningHeight[buildings.length - 1] = buildings[buildings.length - 1];
            currRunningHighestHeight = buildings[buildings.length - 1];

            for (int i = buildings.length - 2; i >= 0; i--) {
                if (buildings[i] > runningHeight[i + 1]) {
                    if (buildings[i] > currRunningHighestHeight) {
                        currRunningHighestHeight = buildings[i];
                        runningHeight[i] = currRunningHighestHeight;
                        result.add(i);
                    }
                }
            }

            Collections.reverse(result);
            break;
        case "WEST":
            result.add(0);

            runningHeight[0] = buildings[0];
            currRunningHighestHeight = buildings[0];

            for (int i = 1; i < buildings.length; i++) {
                if (buildings[i] > runningHeight[i - 1]) {
                    if (buildings[i] > currRunningHighestHeight) {
                        currRunningHighestHeight = buildings[i];
                        runningHeight[i] = currRunningHighestHeight;
                        result.add(i);
                    }
                }
            }
            break;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] buildings = new int[] {20, 2, 3, 1, 5, 6, 9, 1, 9, 9, 11, 10, 9, 12, 8};
        String direction = "EAST";
        System.out.println(sunsetViews(buildings, direction));
    }
}
