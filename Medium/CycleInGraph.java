package Medium;

import java.util.*;

class Program {

    public static boolean cycleInGraph(int[][] edges) {

        // Time:  O(v + e);
        // Space: O(v + e);

        boolean[] visited = new boolean[edges.length];
        boolean[] visiting = new boolean[edges.length];
        boolean hasCycle = false;

        for (int i = 0; i < edges.length; i++) {
            hasCycle = isCyclic(i, edges, visited, visiting);

            if (hasCycle) {
                break;
            }
        }

        return hasCycle;
    }

    public static boolean isCyclic(int val, int[][] edges, boolean[] visited, boolean[] visiting) {
        if (visiting[val]) {
            return true;
        }

        if (visited[val]) {
            return false;
        }

        visiting[val] = true;
        visited[val] = true;

        for (int neighbor : edges[val]) {
            if(isCyclic(neighbor, edges, visited, visiting)) {
                return true;
            }
        }

        visiting[val] = false;
        return false;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][] {{1, 3}, {2, 3, 4}, {0}, {}, {2, 5}, {}};
        System.out.println(cycleInGraph(edges));
    }
}