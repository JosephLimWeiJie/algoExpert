import java.util.*;

public class DijkstraVersionTwo {

    public static class Pair implements Comparable<Pair> {
        public int nodeId;
        public int edgeDist;

        public Pair(int nodeId, int edgeDist) {
            this.nodeId = nodeId;
            this.edgeDist = edgeDist;
        }

        @Override
        public int compareTo(Pair otherPair) {
            return Integer.compare(this.edgeDist, otherPair.edgeDist);
        }
    }

    public static int[] dijkstrasAlgorithm(int start, int[][][] edges) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[edges.length];
        boolean[] visited = new boolean[edges.length];

        for (int i = 0; i < dist.length; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        pq.add(new Pair(start, 0));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Pair currNode = pq.poll();

            if (visited[currNode.nodeId]) {
                continue;
            }

            visited[currNode.nodeId] = true;
            int[][] neighbors = edges[currNode.nodeId];
            for (int[] neighbor : neighbors) {
                int neighborEdge = neighbor[1];
                if (!visited[neighbor[0]] && dist[currNode.nodeId] + neighborEdge < dist[neighbor[0]]) {
                    dist[neighbor[0]] = dist[currNode.nodeId] + neighborEdge;
                    pq.add(new Pair(neighbor[0], neighbor[1]));      
                }

            }
        }

        for (int i = 0; i < dist.length; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }
    
    public static void main(String[] args) {
        int start = 0;
        int[][][] edges = {
          {{1, 7}},
          {{2, 6}, {3, 20}, {4, 3}},
          {{3, 14}},
          {{4, 2}},
          {},
          {}
        };
        int[] expected = {0, 7, 13, 27, 10, -1};
        int[] actual = dijkstrasAlgorithm(start, edges);
        System.out.println(expected.length == actual.length);
            for (int i = 0; i < expected.length; i++) {
            System.out.println(expected[i] == actual[i]);
        }
    }

    /** 
     * Note that this version of Dijkstra uses lazy removal method.
     * 
     * Disadvantage of Dijkstra's algoritm:
     * Possible to get wrong answers when run on graphs with negative edges/cycles
     */
}
