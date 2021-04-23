package prompt.misc;

import java.util.*;
import java.io.*;

public class KosarajuAlgorithm {

    public static class Pair {
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + this.node + ", " + this.weight + ")";
        }
    }

    public static List<List<Pair>> readInput(BufferedReader br, int N) {
        List<List<Pair>> adjacentList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            adjacentList.add(new ArrayList<>());
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

    public static List<List<Integer>> kosarajuAlgorithm(List<List<Pair>> adjacentList) {
        List<List<Integer>> stronglyConnectedComponents = new ArrayList<>();
        List<Integer> stack = new ArrayList<>();

        boolean[] visited = new boolean[adjacentList.size()];

        for (int i = 0; i < adjacentList.size(); i++) {
            if (!visited[i]) {
                fillOrder(i, visited, stack, adjacentList);
            }
        }

        List<List<Pair>> transposedGraph = transposeGraph(adjacentList);
        boolean[] visited2 = new boolean[adjacentList.size()];
        
        while (!stack.isEmpty()) {
            int node = stack.remove(stack.size() - 1);
            List<Integer> connectedComponents = new ArrayList<>();
            if (!visited2[node]) {
                DFSUtil(node, visited2, transposedGraph, connectedComponents);
                
            }

            stronglyConnectedComponents.add(connectedComponents);
        }

        return stronglyConnectedComponents;
    }

    public static void DFSUtil(int node, boolean[] visited2, List<List<Pair>> 
        transposedGraph, List<Integer> connectedComponents) {
            
            connectedComponents.add(node);
            visited2[node] = true;
            List<Pair> neighbors = transposedGraph.get(node);
            for (Pair neighbor : neighbors) {
                if (!visited2[neighbor.node]) {
                    DFSUtil(neighbor.node, visited2, transposedGraph, connectedComponents);
                }
            }
        
    }

    public static void fillOrder(int node, boolean[] visited, List<Integer> stack, List<List<Pair>> adjacentList) {
        visited[node] = true;

        List<Pair> neighbors = adjacentList.get(node);
        for (Pair neighbor : neighbors) {
            if (!visited[neighbor.node]) {
                fillOrder(neighbor.node, visited, stack, adjacentList);
            }
        }

        stack.add(node);
    }

    public static List<List<Pair>> transposeGraph(List<List<Pair>> adjacentList) {
        List<List<Pair>> transposedGraph = new ArrayList<>();

        for (int i = 0; i < adjacentList.size(); i++) {
            transposedGraph.add(new ArrayList<>());
        }

        for (int j = 0; j < adjacentList.size(); j++) {
            List<Pair> neighbors = adjacentList.get(j);
            for (Pair p : neighbors) {
                int neighborId = p.node;
                int neighborWeight = p.weight;
                transposedGraph.get(neighborId).add(new Pair(j, neighborWeight));
            }
        }

        return transposedGraph;
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("../../input/kosaraju_algorithm.txt"))) {
            int N = Integer.parseInt(br.readLine());
            List<List<Pair>> adjacentList = readInput(br, N);
            System.out.println(kosarajuAlgorithm(adjacentList));
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
