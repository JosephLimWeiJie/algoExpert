package VeryHard;

import java.util.*;

class Program {

    public static int airportConnections(
            List<String> airports, List<List<String>> routes, String startingAirport) {

        // Time: O(v + e)

        Map<String, Integer> airportsId = mapAirportsToId(airports);
        List<List<Integer>> adjList = getAdjList(routes, airportsId);
        int[] inDegree = new int[airports.size()];

        int ans = getStronglyConnectedComponents(adjList, airportsId, inDegree, startingAirport);

        return ans;
    }

    /** This method applies the Kosaraju's algorithm in O(v + e) time. */
    public static int getStronglyConnectedComponents(
            List<List<Integer>> adjList,
            Map<String, Integer> airportsId,
            int[] inDegree,
            String startingAirport) {

        Stack stack = new Stack();
        boolean[] visited = new boolean[airportsId.size()];

        for (int i = 0; i < airportsId.size(); i++) {
            if (!visited[i]) {
                fillOrder(i, visited, stack, adjList);
            }
        }

        List<List<Integer>> tAdjList = transposeAdjList(adjList);

        for (int i = 0; i < airportsId.size(); i++) {
            visited[i] = false;
        }

        int[] who = new int[airportsId.size()];
        while (!stack.isEmpty()) {
            int v = (int) stack.pop();
            if (!visited[v]) {
                DFSForRep(v, v, visited, tAdjList, who);
            }
        }

        // Get in-degree for each node
        for (int i = 0; i < airportsId.size(); i++) {
            for (Integer j : adjList.get(i)) {
                if (who[i] != who[j]) {
                    ++inDegree[who[j]];
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < airportsId.size(); i++) {
            if (who[i] == i && inDegree[i] == 0 && i != who[airportsId.get(startingAirport)]) {
                ans++;
            }
        }
        System.out.println(Arrays.toString(who));
        return ans;
    }

    public static void DFSForRep(int u, int rep, boolean[] visited, List<List<Integer>> tAdjList, int[] who) {
        visited[u] = true;
        who[u] = rep;

        for (Integer neighbor : tAdjList.get(u)) {
            if (!visited[neighbor]) {
                DFSForRep(neighbor, rep, visited, tAdjList, who);
            }
        }
    }

    public static void fillOrder(int v, boolean visited[], Stack stack, List<List<Integer>> adjList) {
        visited[v] = true;

        for (Integer neighbor : adjList.get(v)) {
            if (!visited[neighbor]) {
                fillOrder(neighbor, visited, stack, adjList);
            }
        }

        stack.push(v);
    }

    public static void DFS(
            int v, boolean[] visited, List<List<Integer>> adjList, List<Integer> connectedComponents) {

        visited[v] = true;
        connectedComponents.add(v);

        for (Integer neighbor : adjList.get(v)) {
            if (!visited[neighbor]) {
                DFS(neighbor, visited, adjList, connectedComponents);

            }
        }
    }

    public static List<List<Integer>> transposeAdjList(List<List<Integer>> adjList) {
        List<List<Integer>> transposedAdjList = new ArrayList<>();

        for (int i = 0; i < adjList.size(); i++) {
            transposedAdjList.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < adjList.size(); i++) {
            for (Integer neighbor : adjList.get(i)) {
                transposedAdjList.get(neighbor).add(i);
            }
        }

        return transposedAdjList;
    }

    public static List<List<Integer>> getAdjList(List<List<String>> routes, Map<String, Integer> airportsId) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < airportsId.size(); i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for (List<String> route : routes) {
            int from = airportsId.get(route.get(0));
            int to = airportsId.get(route.get(1));
            adjList.get(from).add(to);
        }

        return adjList;
    }

    public static void printGraph(List<List<Integer>> adjList) {
        for (int i = 0; i < adjList.size(); i++) {
            String line = (i + " | ");
            for (int j = 0; j < adjList.get(i).size(); j++) {
                line += (adjList.get(i).get(j) + " ,");
            }
            System.out.println(line);
        }
    }

    public static Map<String, Integer> mapAirportsToId(List<String> airports) {
        Map<String, Integer> airportsId = new HashMap<>();

        for (int i = 0; i < airports.size(); i++) {
            airportsId.put(airports.get(i), i);
        }

        return airportsId;
    }

    public static void main(String[] args) {
        List<String> airports = Arrays.asList(
                "BGI",
                "CDG",
                "DEL",
                "DOH",
                "DSM",
                "EWR",
                "EYW",
                "HND",
                "ICN",
                "JFK",
                "LGA",
                "LHR",
                "ORD",
                "SAN",
                "SFO",
                "SIN",
                "TLV",
                "BUD");

        List<List<String>> routes = new ArrayList<>();
        routes.add(Arrays.asList("DSM", "ORD"));
        routes.add(Arrays.asList("ORD", "BGI"));
        routes.add(Arrays.asList("BGI", "LGA"));
        routes.add(Arrays.asList("SIN", "CDG"));
        routes.add(Arrays.asList("CDG", "SIN"));
        routes.add(Arrays.asList("CDG", "BUD"));
        routes.add(Arrays.asList("DEL", "DOH"));
        routes.add(Arrays.asList("DEL", "CDG"));
        routes.add(Arrays.asList("TLV", "DEL"));
        routes.add(Arrays.asList("EWR", "HND"));
        routes.add(Arrays.asList("HND", "ICN"));
        routes.add(Arrays.asList("HND", "JFK"));
        routes.add(Arrays.asList("ICN", "JFK"));
        routes.add(Arrays.asList("JFK", "LGA"));
        routes.add(Arrays.asList("EYW", "LHR"));
        routes.add(Arrays.asList("LHR", "SFO"));
        routes.add(Arrays.asList("SFO", "SAN"));
        routes.add(Arrays.asList("SFO", "DSM"));
        routes.add(Arrays.asList("SAN", "EYW"));

        String startingAirports = "LGA";

        System.out.println(airportConnections(airports, routes, startingAirports));
    }
}
