package prompt.hard;

import java.util.*;
import java.io.*;

public class Dijkstra {

    public static class Pair {
        int node;
        int edgeWeight;

        public Pair(int node, int edgeWeight) {
            this.node = node;
            this.edgeWeight = edgeWeight;
        }

        @Override
        public String toString() {
            return "(" + this.node + ", " + this.edgeWeight + ")";
        }
    }

    public static List<List<Pair>> readInput(BufferedReader br, int N) {
        List<List<Pair>> adjacentList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adjacentList.add(new ArrayList<Pair>());
            try {
                String[] args = br.readLine().split(" ");
                if (args.length > 1) {
                    int numOfEdges = Integer.parseInt(args[0]);
                    
                    int odd = 1;
                    int even = 2;
                    for (int j = 0; j < numOfEdges; j++) {
                        adjacentList.get(i).add(new Pair(Integer.parseInt(args[odd]), Integer.parseInt(args[even])));
                        odd += 2;
                        even += 2;
                    }
                } 
            } catch (IOException ioe) {
                // do nothing
            }
        }

        return adjacentList;
    }

    public static int dijkstra(List<List<Pair>> adjacentList, int N, int source, int end) {
        int[] distance = new int[N];
        for (int i = 0; i < N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        boolean[] resolved = new boolean[N];
        for (int j = 0; j < N; j++) {
            resolved[j] = false;
        }

        distance[source] = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(source);

        while (!pq.isEmpty()) {
            int node = pq.poll();
            resolved[node] = true;
            List<Pair> neighbors = adjacentList.get(node);
            for (Pair neighbor : neighbors) {
                int neighborNode = neighbor.node;
                int neighborEdgeWeight = neighbor.edgeWeight;

                // relaxation part
                if (!resolved[neighborNode] && (distance[node] + neighborEdgeWeight < distance[neighborNode])) {
                    distance[neighborNode] = distance[node] + neighborEdgeWeight;
                }

                pq.add(neighbor.node);
            }
        }

        return distance[end];
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("../../input/dijkstra.txt"))) {
            int N = Integer.parseInt(br.readLine());
            List<List<Pair>> adjacentList = readInput(br, N);
            int source = 0;
            int end = 3;
            System.out.println(dijkstra(adjacentList, N, source, end));
        } catch (FileNotFoundException foe) { 
            System.out.println("Input file not found.");
        }

    }

    /**
     * Input file has the following format:
     * 
     * First line represents the total number of nodes.
     * For each subsequent line, the first integer represents the number of edges for node i,
     * followed by the neighbor node and edge weight pair.
     * 
     * For example, line 2 means that node with ID 0 has 1 edge pair, which node 0 is linked
     * to node 1 with a weight of 7.
     */
}