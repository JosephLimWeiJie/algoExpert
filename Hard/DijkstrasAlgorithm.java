package Hard;

import java.util.*;

class Program {

    public static int[] dijkstrasAlgorithm(int start, int[][][] edges) {

        // Using Lazy Deletion
        // Time:  O((v + e) log(v))
        // Space: O(v)

        int numVertices = edges.length;

        boolean[] resolved = new boolean[numVertices];
        int[] distance = new int[numVertices];
        PriorityQueue<Node> pq = new PriorityQueue<>(new NodeComparator());

        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
            if (i == start) {
                pq.add(new Node(i, 0));
            } else {
                pq.add(new Node(i, distance[i]));
            }
        }
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node toRemove = pq.poll();
            if (resolved[toRemove.id]) {
                continue;
            }

            resolved[toRemove.id] = true;
            int dU = toRemove.weight;

            for (int[] neighbor : edges[toRemove.id]) {
                int v = neighbor[0];
                int dV = dU + neighbor[1];

                // Handle edge case when starting a new SSP from a new connected component.
                if (dV < 0) {
                    continue;
                }

                if (!resolved[v] && dV < distance[v]) {
                    pq.add(new Node(v, dV));
                    distance[v] = dV;
                }
            }


        }

        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }

        return distance;
    }

    public static class NodeComparator implements Comparator<Node> {
        @Override
        public int compare(Node nodeOne, Node nodeTwo) {
            if (nodeOne.weight < nodeTwo.weight) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public static class Node {
        public int id;
        public int weight;

        public Node(int id, int weight) {
            this.id = id;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + this.id + ", " + this.weight + ")";
        }
    }


    public static void main(String[] args) {
        int[][][] edges = {{{1, 2}}, {{0, 1}}, {{3, 1}}, {{2, 2}}};
        int start = 1;
        System.out.println(Arrays.toString(dijkstrasAlgorithm(start, edges)));
    }
}
