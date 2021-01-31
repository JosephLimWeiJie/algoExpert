package VeryHard;

import java.util.*;

class Program {

    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {

        // Time:  O(b * r) where b is the length of blocks and r is length of reqs
        // Space: O(b * r)

        int[][] data = new int[reqs.length][blocks.size()];
        Map<String, Integer> mapReqsToIds = new HashMap<>();

        for (int i = 0; i < reqs.length; i++) {
            mapReqsToIds.put(reqs[i], i);
        }

        for (int j = 0; j < reqs.length; j++) {
            for (int k = 0; k < blocks.size(); k++) {
                Map<String, Boolean> map = blocks.get(k);
                for (String str : reqs) {
                    if (map.containsKey(str)) {
                        int strId = mapReqsToIds.get(str);
                        data[strId][k] = map.get(str) == true ? 1 : 0;
                    }
                }
            }

        }
        int[][] newDataOne = minDistanceFromLeft(data);
        int[][] newDataTwo = minDistanceFromRight(data);
        int[][] newMinDistanceData = minDistanceFromLeftRight(newDataOne, newDataTwo);

        printData(newDataOne);
        printData(newDataTwo);
        printData(newMinDistanceData);

        return findShortestDistance(newMinDistanceData);
    }

    public static int findShortestDistance(int[][] data) {
        int minDistance = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < data[0].length; i++) {
            int currMaxDistance = Integer.MIN_VALUE;

            for (int j = 0; j < data.length; j++) {
                if (data[j][i] == 0) {
                    continue;
                }

                currMaxDistance = Math.max(currMaxDistance, data[j][i]);
            }

            if (currMaxDistance < minDistance) {
                minDistance = currMaxDistance;
            }

            if (currMaxDistance == minDistance) {
                index = i;
            }

        }

        return index;
    }

    public static int[][] minDistanceFromLeftRight(int[][] dataOne, int[][] dataTwo) {
        int[][] newData = new int[dataOne.length][dataOne[0].length];

        for (int i = 0; i < newData.length; i++) {
            for (int j = 0; j < newData[i].length; j++) {
                if (dataOne[i][j] == 0) {
                    newData[i][j] = dataTwo[i][j];
                } else if (dataTwo[i][j] == 0) {
                    newData[i][j] = dataOne[i][j];
                } else {
                    newData[i][j] = Math.min(dataOne[i][j], dataTwo[i][j]);
                }
            }
        }

        return newData;
    }

    public static int[][] minDistanceFromLeft(int[][] data) {
        int[][] newData = new int[data.length][data[0].length];

        for (int i = 0; i < data.length; i++) {
            int minIdx = -1;
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] == 1) {
                    minIdx = j;
                    newData[i][j] = 0;
                } else {
                    if (minIdx == -1) {
                        newData[i][j] = 0;
                    } else {
                        newData[i][j] = Math.abs(j - minIdx);
                    }
                }
            }
        }

        return newData;
    }

    public static int[][] minDistanceFromRight(int[][] data) {
        int[][] newData = new int[data.length][data[0].length];

        for (int i = 0; i < data.length; i++) {
            int minIdx = -1;
            for (int j = data[i].length - 1; j >= 0; j--) {
                if (data[i][j] == 1) {
                    minIdx = j;
                    newData[i][j] = 0;
                } else {
                    if (minIdx == -1) {
                        newData[i][j] = 0;
                    } else {
                        newData[i][j] = Math.abs(j - minIdx);
                    }
                }
            }
        }

        return newData;
    }

    public static void printData(int[][] data) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                sb.append(data[i][j] + ",");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        List<Map<String, Boolean>> blocks = new ArrayList<Map<String, Boolean>>();

        blocks.add(0, new HashMap<String, Boolean>());
        blocks.get(0).put("gym", false);
        blocks.get(0).put("school", true);
        blocks.get(0).put("store", false);

        blocks.add(1, new HashMap<String, Boolean>());
        blocks.get(1).put("gym", true);
        blocks.get(1).put("school", false);
        blocks.get(1).put("store", false);

        blocks.add(2, new HashMap<String, Boolean>());
        blocks.get(2).put("gym", true);
        blocks.get(2).put("school", true);
        blocks.get(2).put("store", false);

        blocks.add(3, new HashMap<String, Boolean>());
        blocks.get(3).put("gym", false);
        blocks.get(3).put("school", true);
        blocks.get(3).put("store", false);

        blocks.add(4, new HashMap<String, Boolean>());
        blocks.get(4).put("gym", false);
        blocks.get(4).put("school", true);
        blocks.get(4).put("store", true);

        String[] reqs = new String[] {"gym", "school", "store"};
        System.out.println(apartmentHunting(blocks, reqs));
    }
}
