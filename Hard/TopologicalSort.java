package Hard;

import java.util.*;

class Program {

    public static List<Integer> topologicalSort(List<Integer> jobs, List<Integer[]> deps) {

        // Time:  O(v + e), where v and e are length of jobs and deps respectively.
        // Space: O(v + e)

        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < jobs.size(); i++) {
            adjList.add(new ArrayList<>());
        }

        // Convert to 0-based indexing if first element of jobs is 1.
        for (int i = 0; i < deps.size(); i++) {
            Integer[] toAdd = deps.get(i);
            if (jobs.get(0) == 1) {
                int vertexId = toAdd[0] - 1;
                int neighborId = toAdd[1] - 1;
                adjList.get(vertexId).add(neighborId);
            } else {
                int vertexId = toAdd[0];
                int neighborId = toAdd[1];
                adjList.get(vertexId).add(neighborId);
            }
        }

        // Check for DAG to determine if graph has valid topological ordering.
        // Time:  O(v + e)
        // Space: O(v + e)
        if (containsDAG(adjList)) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[adjList.size()];

        for (int i = 0; i < adjList.size(); i++) {
            DFS(adjList, stack, visited, i);
        }

        while (!stack.isEmpty()) {
            // Convert back to 1 based indexing if first element of jobs is 1.
            if (jobs.get(0) == 1) {
                result.add(stack.pop() + 1);
            } else {
                result.add(stack.pop());
            }
        }

        return result;
    }

    public static void DFS(List<List<Integer>> adjList, Stack<Integer> stack, boolean[] visited, int currIdx) {

        if (visited[currIdx]) {
            return;
        }

        visited[currIdx] = true;

        for (Integer neighborIdx : adjList.get(currIdx)) {
            if (visited[neighborIdx]) {
                continue;
            }
            DFS(adjList, stack, visited, neighborIdx);
        }

        stack.push(currIdx);
    }

    public static boolean containsDAG(List<List<Integer>> adjList) {
        boolean[] visited = new boolean[adjList.size()];
        boolean[] recStack = new boolean[adjList.size()];

        for (int i = 0; i < adjList.size(); i++) {
            if (isCyclicUtil(i, visited, recStack, adjList)) {
                return true;
            }
        }

        return false;
    }

    public static boolean isCyclicUtil(int idx, boolean[] visited, boolean[] recStack, List<List<Integer>> adjList) {
        if (recStack[idx]) {
            return true;
        }

        if (visited[idx]) {
            return false;
        }

        visited[idx] = true;
        recStack[idx] = true;
        List<Integer> children = adjList.get(idx);

        for (Integer child : children) {
            if (isCyclicUtil(child, visited, recStack, adjList)) {
                return true;
            }
        }

        recStack[idx] = false;

        return false;
    }

    public static void main(String[] args) {
        List<Integer> jobs = Arrays.asList(new Integer[] {1, 2, 3, 4, 5, 6, 7, 8});
        List<Integer[]> deps = new ArrayList<>();

        deps.add(new Integer[] {3, 1});
        deps.add(new Integer[] {8, 1});
        deps.add(new Integer[] {8, 7});
        deps.add(new Integer[] {5, 7});
        deps.add(new Integer[] {5, 2});
        deps.add(new Integer[] {1, 4});
        deps.add(new Integer[] {6, 7});
        deps.add(new Integer[] {1, 2});
        deps.add(new Integer[] {7, 6});

        System.out.println(topologicalSort(jobs, deps));
    }
}
