package prompt.veryhard;

import java.util.*;

public class ApartmentHunting {
    
    public static int apartmentHunting(List<Map<String, Boolean>> blocks, String[] reqs) {
        int[][] data = new int[reqs.length][blocks.size()];
        Map<Integer, String> facilitiesToId = new HashMap<>();
        Map<String, Integer> reqsMap = new HashMap<>();

        for (int i = 0; i < reqs.length; i++) {
            reqsMap.put(reqs[i], 0);
        }

        int id = 0;
        for (Map.Entry<String, Boolean> entry : blocks.get(0).entrySet()) {
            if (reqsMap.containsKey(entry.getKey())) {
                facilitiesToId.put(id, entry.getKey());
                id++;
            }
        }
        
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                boolean isFacilityThere = blocks.get(j).get(facilitiesToId.get(i));
                if (isFacilityThere) {
                    data[i][j] = 1;
                }
            }
        }

        int[][] distanceFromLeft = getDistanceFromLeft(data);
        int[][] distanceFromRight = getDistanceFromRight(data);
        int[][] maxDistanceLeftRight = getMaxDistanceFromLeftRight(distanceFromLeft, distanceFromRight);
        int[] maxDistanceOfEachBlock = runningMaxDistance(maxDistanceLeftRight);
        
        return getBlockIndex(maxDistanceOfEachBlock);
    }

    public static int getBlockIndex(int[] maxDistanceOfEachBlock) {
        int index = -1;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < maxDistanceOfEachBlock.length; i++) {
            if (maxDistanceOfEachBlock[i] < minDist) {
                minDist = maxDistanceOfEachBlock[i];
                index = i;
            }
        }

        return index;
    }

    public static int[] runningMaxDistance(int[][] data) {
        int[] maxDistanceOfEachBlock = new int[data[0].length];
        
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                maxDistanceOfEachBlock[j] = Math.max(data[i][j], maxDistanceOfEachBlock[j]);
            }
        }

        return maxDistanceOfEachBlock;
    }

    public static int[][] getMaxDistanceFromLeftRight(int[][] leftData, int[][] rightData) {
        int[][] newData = new int[leftData.length][rightData[0].length];

        for (int i = 0; i < leftData.length; i++) {
            for (int j = 0; j < leftData[i].length; j++) {
                if (leftData[i][j] == 0) {
                    newData[i][j] = rightData[i][j];
                } else if (rightData[i][j] == 0) {
                    newData[i][j] = leftData[i][j];
                } else {
                    newData[i][j] = Math.min(leftData[i][j], rightData[i][j]);
                }
            }
        }

        return newData;
    }

    public static int[][] getDistanceFromLeft(int[][] data) {
        int[][] newData = new int[data.length][data[0].length];

        for (int i = 0; i < data.length; i++) {
            int runningLeftIdx = -1;
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] == 1) {
                    newData[i][j] = 0;
                    runningLeftIdx = j;
                } else {
                    if (runningLeftIdx == -1) {
                        newData[i][j] = 0;
                    } else {
                        newData[i][j] = Math.abs(j - runningLeftIdx);
                    }
                }
            }
        }

        return newData;
    } 

    public static int[][] getDistanceFromRight(int[][] data) {
        int[][] newData = new int[data.length][data[0].length];

        for (int i = data.length - 1; i >= 0; i--) {
            int runningRightIdx = -1;
            for (int j = data[i].length - 1; j >= 0; j--) {
                if (data[i][j] == 1) {
                    newData[i][j] = 0;
                    runningRightIdx = j;
                } else {
                    if (runningRightIdx == -1) {
                        newData[i][j] = 0;
                    } else {
                        newData[i][j] = Math.abs(j - runningRightIdx);
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
