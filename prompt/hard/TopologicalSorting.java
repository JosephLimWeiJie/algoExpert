import java.util.*;

public class TopologicalSorting {
    
    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {
        boolean isZeroBasedIndexing = jobs.get(0) == 0;

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < jobs.size(); i++) {
            graph.add(new ArrayList<>());
        }

        // Convert to 0-based indexing if first element of jobs is 1.
        for (int i = 0; i < deps.size(); i++) {
            Integer[] toAdd = deps.get(i);
            if (jobs.get(0) == 1) {
                int vertexId = toAdd[0] - 1;
                int neighborId = toAdd[1] - 1;
                graph.get(vertexId).add(neighborId);
            } else {
                int vertexId = toAdd[0];
                int neighborId = toAdd[1];
                graph.get(vertexId).add(neighborId);
            }
        }

        // Check graph for valid topological sorting with no DAG
        if (isDAG(graph)) {
            return new ArrayList<>();
        }
        
        // DFS and get the ordering
        List<Integer> ans = new ArrayList<>();
        List<Integer> stack = new ArrayList<>();
        boolean[] visited = new boolean[jobs.size()];
        for (int k = 0; k < graph.size(); k++) {
            DFS(graph, stack, visited, k);
        }

        while (!stack.isEmpty()) {
            if (isZeroBasedIndexing) {
                ans.add(stack.remove(stack.size() - 1));
            } else {
                ans.add(stack.remove(stack.size() - 1) + 1);
            }
        }
        System.out.println(ans);
        return ans;
    }

    public static boolean isDAG(List<List<Integer>> graph) {
        boolean[] visited = new boolean[graph.size()];
        boolean[] visiting = new boolean[graph.size()];

        for (int i = 0; i < graph.size(); i++) {
            if (isCyclicUtil(graph, visited, visiting, i)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isCyclicUtil(List<List<Integer>> graph, boolean[] visited, boolean[] visiting, int node) {
        if (visiting[node]) {
            return true;
        }

        if (visited[node]) {
            return false;
        }

        visiting[node] = true;
        List<Integer> neighbors = graph.get(node);
        for (Integer neighbor : neighbors) {
            if (isCyclicUtil(graph, visited, visiting, neighbor)) {
                return true;
            }
        }

        visiting[node] = false;
        visited[node] = true;

        return false;
    }

    public static void DFS(List<List<Integer>> graph, List<Integer> stack, boolean[] visited, int node) {
        if (visited[node]) {
            return;
        }

        visited[node] = true;
        for (Integer neighbor : graph.get(node)) {
            if (!visited[neighbor]) {
                DFS(graph, stack, visited, neighbor);
            }
        }

        stack.add(node);
    }

    public static void fillDeps(Integer[][] depsArray, List<Integer[]> deps) {
        for (Integer[] depArray : depsArray) {
            deps.add(depArray);
        }
    }
    
    public static boolean isValidTopologicalOrder(List<Integer> order, List<Integer> jobs, List<Integer[]> deps) {
        Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
        for (Integer candidate : order) {
            for (Integer[] dep : deps) {
                if (candidate == dep[0] && visited.containsKey(dep[1])) return false;
            }
            visited.put(candidate, true);
        }
        for (Integer job : jobs) {
            if (!visited.containsKey(job)) return false;
        }
        return order.size() == jobs.size();
      }
    public static void main(String[] args) {
        List<Integer> jobs = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4));
        Integer[][] depsArray = new Integer[][] {{1, 2}, {1, 3}, {3, 2}, {4, 2}, {4, 3}};
        List<Integer[]> deps = new ArrayList<Integer[]>();
        fillDeps(depsArray, deps);
        List<Integer> order = topologicalSort(jobs, deps);
        System.out.println(isValidTopologicalOrder(order, jobs, deps) == true);
    }
}
