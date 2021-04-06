package prompt.misc;

import java.util.*;
import java.io.*;

public class BellmanFord {
    
    public static class Tuple {
        int node;
        int edgeNode;
        int edgeWeight;

        public Tuple(int node, int edgeNode, int edgeWeight) {
            this.node = node;
            this.edgeNode = edgeNode;
            this.edgeWeight = edgeWeight;
        }

        @Override
        public String toString() {
            return "(" + this.node + ", " + this.edgeNode + ", " + this.edgeWeight + ")";
        }
    }

    public static List<Tuple> readInput(BufferedReader br, int N) {
        List<Tuple> edgeList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            try {
                String[] arr = br.readLine().split(" ");
                if (arr.length > 1) {
                    int numOfEdges = Integer.parseInt(arr[0]);

                    int odd = 1;
                    int even = 2;
                    for (int j = 0; j < numOfEdges; j++) {
                        edgeList.add(new Tuple(i, Integer.parseInt(arr[odd]), Integer.parseInt(arr[even])));
                        odd += 2;
                        even += 2;
                    }
                } 
            } catch (IOException ioe) {
                // do nothing
            }
        }

        return edgeList;
    }

    public static int bellmanFord(List<Tuple> edgeList, int N, int sourceNode, int endNode) {
        int[] distance = new int[N];
        for (int i = 0; i < N; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[sourceNode] = 0;
        for (int i = 0; i < N; i++) {
            for (Tuple edge : edgeList) {
                int node = edge.node;
                int edgeNode = edge.edgeNode;
                int edgeWeight = edge.edgeWeight;
    
                // relaxation part
                if (distance[node] + edgeWeight < distance[edgeNode]) {
                    distance[edgeNode] = distance[node] + edgeWeight;
                }
            }
        }

        // Just to double check if there's negative cycle.
        for (Tuple edge : edgeList) {
            int node = edge.node;
            int edgeNode = edge.edgeNode;
            int edgeWeight = edge.edgeWeight;

            // relaxation part
            if (distance[node] + edgeWeight < distance[edgeNode]) {
                System.out.println("Graph contains cycle");
                return -1;
            }
        }

        return distance[endNode];
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("../../input/bellman_ford.txt"))) {
            int N = Integer.parseInt(br.readLine());
            List<Tuple> edgeList = readInput(br, N);
            int sourceNode = 0;
            int endNode = 3;
            System.out.println(bellmanFord(edgeList, N, sourceNode, endNode));
        } catch (FileNotFoundException foe) {
            System.out.println("Input file not found");
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
