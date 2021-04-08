package prompt.medium;

public class CycleInGraph {

    public static boolean cycleInGraph(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        boolean[] visiting = new boolean[edges.length];

        boolean hasCycle = false;
        for (int i = 0; i < edges.length; i++) {
            int nodeId = i;
            hasCycle = checkCycleForNode(nodeId, edges, visited, visiting);
            
            if (hasCycle) {
                break;
            }
        }

        return hasCycle;
    }

    public static boolean checkCycleForNode(int nodeId, int[][] edges, boolean[] visited, boolean[] visiting) {
        if (visiting[nodeId]) {
            return true;
        }

        if (visited[nodeId]) {
            return false;
        }

        visiting[nodeId] = true;
        int[] neighbors = edges[nodeId];

        for (int neighborId : neighbors) {
            if (checkCycleForNode(neighborId, edges, visited, visiting)) {
                return true;
            }
        }

        visiting[nodeId] = false;
        visited[nodeId] = true;

        return false;
    }

    public static void main(String[] args) {
        int[][] input =
            new int[][] {
                {1, 3},
                {2, 3, 4},
                {0},
                {},
                {2, 5},
                {}
            };
        boolean expected = true;
        var actual = cycleInGraph(input);
        System.out.println(expected == actual);
    }
    
}
