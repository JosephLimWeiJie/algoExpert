package prompt.misc;

import java.util.*;
import java.io.*;


public class CycleInGraph {
    
    public static List<List<Integer>> readInput(BufferedReader br, int N) {
        List<List<Integer>> adjacentList = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            try {
                String line = br.readLine();

                if (line.equals(" ")) {
                    adjacentList.add(new ArrayList<>());
                } else {
                    String[] args = line.split(" ");
                    if (args.length == 1) {
                        adjacentList.add(Arrays.asList(Integer.parseInt(args[0])));
                    } else if (args.length >= 1) {
                        List<Integer> neighbors = new ArrayList<>();
                        for (String arg : args) {
                            neighbors.add(Integer.parseInt(arg));
                        }

                        adjacentList.add(neighbors);
                    }
                } 
            } catch (IOException ioe) {
                // do nothing
            }
        }

        return adjacentList;
    }

    public static boolean cycleInGraph(List<List<Integer>> adjacentList, int N) {
        boolean[] visited = new boolean[N];
        boolean[] visiting = new boolean[N];
        boolean hasCycle = false;

        for (int i = 0; i < N; i++) {
            hasCycle = checkIsCyclic(adjacentList, N, visited, visiting, i);
            if (hasCycle) {
                break;
            }
        }

        return hasCycle;
    }

    public static boolean checkIsCyclic(List<List<Integer>> adjacentList, int N, boolean[] visited, 
                                        boolean[] visiting, int nodeId) {
        
        if (visiting[nodeId]) {
            return true;
        }
        
        if (visited[nodeId]) {
            return false;
        }

        visiting[nodeId] = true;
        visited[nodeId] = true;
        for (int neighbor : adjacentList.get(nodeId)) {
            if (checkIsCyclic(adjacentList, N, visited, visiting, neighbor)) {
                return true;
            }
        }

        visiting[nodeId] = false;
        visited[nodeId] = true;
        
        return false;
    }

    public static void main(String[] args) throws Exception {
        try (BufferedReader br = new BufferedReader(new FileReader("../../input/cycle_in_graph.txt"))) {
            int N = Integer.parseInt(br.readLine());
            List<List<Integer>> adjacentList = readInput(br, N);
            
            System.out.println(cycleInGraph(adjacentList, N));
        } catch (FileNotFoundException foe) {
            System.err.println("Input file not found");
        }
    }
}
