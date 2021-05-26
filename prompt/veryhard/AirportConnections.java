package prompt.veryhard;

import java.util.*;

public class AirportConnections {

    public static int airportConnections(List<String> airports, List<List<String>> routes, String startingAirport) {
        
        Map<String, Integer> mapAirportsToId = new HashMap<>();
        for (int i = 0; i < airports.size(); i++) {
            mapAirportsToId.put(airports.get(i), i);
        }

        List<List<Integer>> graph = createGraph(routes, mapAirportsToId);
        int[] inDegreeForEachAirport = new int[airports.size()];
        int[] airportsRep = new int[airports.size()];

        getStronglyConnectedComponents(graph, airportsRep);
        getInDegreeForEachAirport(inDegreeForEachAirport, airportsRep, graph);

        int inDegreeToAdd = 0;
        for (int i = 0; i < airports.size(); i++) {
            if (airportsRep[i] == i && inDegreeForEachAirport[i] == 0 && i != airportsRep[mapAirportsToId.get(startingAirport)]) {
                inDegreeToAdd++;
            }
        }

        return inDegreeToAdd;
    }

    public static void getInDegreeForEachAirport(int[] inDegreeForEachAirport, int[] airportsRep, List<List<Integer>> graph) {
        for (int i = 0; i < graph.size(); i++) {
            // if belong to different "components"
            for (int neighbor : graph.get(i)) {
                if (airportsRep[i] != airportsRep[neighbor]) {
                    inDegreeForEachAirport[airportsRep[neighbor]]++;
                }
            }
        }
    }
    
    public static void getStronglyConnectedComponents(List<List<Integer>> graph, int[] airportsRep) {
        List<List<Integer>> reversedGraph = getReversedGraph(graph);
        boolean[] visited = new boolean[graph.size()];
        List<Integer> stack = fillStackOrder(graph, visited);

        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }

        while (!stack.isEmpty()) {
            int vertex = stack.remove(stack.size() - 1);
            if (!visited[vertex]) {
                getAirportsRep(vertex, vertex, reversedGraph, visited, airportsRep);
            }

        }
        
    }

    public static void getAirportsRep(int vertex, int rep, List<List<Integer>> reversedGraph, boolean[] visited, int[] airportsRep) {
        visited[vertex] = true;
        airportsRep[vertex] = rep;

        for (int neighbor : reversedGraph.get(vertex)) {
            if (!visited[neighbor]) {
                getAirportsRep(neighbor, rep, reversedGraph, visited, airportsRep);
            }
        }
    }

    public static List<Integer> fillStackOrder(List<List<Integer>> graph, boolean[] visited) {
        List<Integer> stack = new ArrayList<>();

        for (int i = 0; i < graph.size(); i++) {
            if (!visited[i]) {
                DFS(i, stack, graph, visited);
            }
        }
        
        return stack;
    }

    public static void DFS(int vertex, List<Integer> stack, List<List<Integer>> graph, boolean[] visited) {
        visited[vertex] = true;

        for (int neighbor : graph.get(vertex)) {
            if (!visited[neighbor]) {
                DFS(neighbor, stack, graph, visited);
            }
        }

        stack.add(vertex);
    }

    public static List<List<Integer>> getReversedGraph(List<List<Integer>> graph) {
        List<List<Integer>> reversedGraph = new ArrayList<>();

        for (int i = 0; i < graph.size(); i++) {
            reversedGraph.add(new ArrayList<>());
        }

        for (int j = 0; j < graph.size(); j++) {
            for (int neighbor : graph.get(j)) {
                reversedGraph.get(neighbor).add(j);
            }
        }

        return reversedGraph;
    }
    

    public static List<List<Integer>> createGraph(List<List<String>> routes, Map<String, Integer> mapAirportsToId) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < mapAirportsToId.size(); i++) {
            graph.add(new ArrayList<>());
        }

        for (List<String> route : routes) {
            int from  = mapAirportsToId.get(route.get(0));
            int to = mapAirportsToId.get(route.get(1));
            graph.get(from).add(to);
        }

        return graph;
    }

    public static void TestCase1() {
        List<String> AIRPORTS =
            new ArrayList<String>(
                Arrays.asList(
                    "BGI", "CDG", "DEL", "DOH", "DSM", "EWR", "EYW", "HND", "ICN", "JFK", "LGA", "LHR",
                    "ORD", "SAN", "SFO", "SIN", "TLV", "BUD"));

        String STARTING_AIRPORT = "LGA";

        List<List<String>> routes = new ArrayList<List<String>>();
        routes.add(new ArrayList<String>(Arrays.asList("DSM", "ORD")));
        routes.add(new ArrayList<String>(Arrays.asList("ORD", "BGI")));
        routes.add(new ArrayList<String>(Arrays.asList("BGI", "LGA")));
        routes.add(new ArrayList<String>(Arrays.asList("SIN", "CDG")));
        routes.add(new ArrayList<String>(Arrays.asList("CDG", "SIN")));
        routes.add(new ArrayList<String>(Arrays.asList("CDG", "BUD")));
        routes.add(new ArrayList<String>(Arrays.asList("DEL", "DOH")));
        routes.add(new ArrayList<String>(Arrays.asList("DEL", "CDG")));
        routes.add(new ArrayList<String>(Arrays.asList("TLV", "DEL")));
        routes.add(new ArrayList<String>(Arrays.asList("EWR", "HND")));
        routes.add(new ArrayList<String>(Arrays.asList("HND", "ICN")));
        routes.add(new ArrayList<String>(Arrays.asList("HND", "JFK")));
        routes.add(new ArrayList<String>(Arrays.asList("ICN", "JFK")));
        routes.add(new ArrayList<String>(Arrays.asList("JFK", "LGA")));
        routes.add(new ArrayList<String>(Arrays.asList("EYW", "LHR")));
        routes.add(new ArrayList<String>(Arrays.asList("LHR", "SFO")));
        routes.add(new ArrayList<String>(Arrays.asList("SFO", "SAN")));
        routes.add(new ArrayList<String>(Arrays.asList("SFO", "DSM")));
        routes.add(new ArrayList<String>(Arrays.asList("SAN", "EYW")));
        System.out.println(airportConnections(AIRPORTS, routes, STARTING_AIRPORT) == 3);
    }

    public static void main(String[] args) {
        TestCase1();
    }

}
