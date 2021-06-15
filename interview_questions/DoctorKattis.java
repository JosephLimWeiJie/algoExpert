package interview_questions;

import java.util.*;
import java.io.*;

public class DoctorKattis {

    static class Kattio extends PrintWriter {
        public Kattio(InputStream i) {
            super(new BufferedOutputStream(System.out));
            r = new BufferedReader(new InputStreamReader(i));
        }
        public Kattio(InputStream i, OutputStream o) {
            super(new BufferedOutputStream(o));
            r = new BufferedReader(new InputStreamReader(i));
        }
    
        public boolean hasMoreTokens() {
            return peekToken() != null;
        }
    
        public int getInt() {
            return Integer.parseInt(nextToken());
        }
    
        public double getDouble() {
            return Double.parseDouble(nextToken());
        }
    
        public long getLong() {
            return Long.parseLong(nextToken());
        }
    
        public String getWord() {
            return nextToken();
        }
    
    
    
        private BufferedReader r;
        private String line;
        private StringTokenizer st;
        private String token;
    
        private String peekToken() {
            if (token == null)
                try {
                    while (st == null || !st.hasMoreTokens()) {
                        line = r.readLine();
                        if (line == null) return null;
                        st = new StringTokenizer(line);
                    }
                    token = st.nextToken();
                } catch (IOException e) { }
            return token;
        }
    
        private String nextToken() {
            String ans = peekToken();
            token = null;
            return ans;
        }
    }
    

    static class Pair {
        String name;
        int infectionLevel;

        public Pair(String name, int infectionLevel) {
            this.name = name;
            this.infectionLevel = infectionLevel;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    static class PairComparator implements Comparator<Pair> {
        @Override
        public int compare(Pair p1, Pair p2) {
            if (p2.infectionLevel < p1.infectionLevel) {
                return -1;
            } else if (p2.infectionLevel > p1.infectionLevel) {
                return 1;
            } else {
                return p1.name.compareTo(p2.name);
            }
        }
    }

    public static void addCatToQueue(String catNameToAdd, int infectionLevel, PriorityQueue<Pair> pq, Map<String, Integer> map) {
        pq.add(new Pair(catNameToAdd, infectionLevel));
        map.put(catNameToAdd, infectionLevel);
    }

    public static void updateCatInfection(String catNameToUpdate, int infectionLevelToAdd, PriorityQueue<Pair> pq, Map<String, Integer> map) {
        int currInfectionLevel = map.get(catNameToUpdate);
        int newInfectionLevel = Math.min(100, infectionLevelToAdd + currInfectionLevel);

        map.put(catNameToUpdate, newInfectionLevel);
        pq.add(new Pair(catNameToUpdate, newInfectionLevel));
    }

    public static void treatCat(String catNameToTreat, PriorityQueue<Pair> pq, Map<String, Integer> map) {
        List<Pair> temp = new ArrayList<>();

        while (true) {
            Pair firstInPq = pq.poll();
            if (firstInPq.name.equals(catNameToTreat)) {
                break;
            } else {
                temp.add(firstInPq);
            }
        }

        map.remove(catNameToTreat);
        while (!temp.isEmpty()) {
            pq.add(temp.remove(temp.size() - 1));
        }
    }

    public static void queryQueue(Kattio io, PriorityQueue<Pair> pq, Map<String, Integer> map) {
        // lazy delete
        while (true && !pq.isEmpty()) {
            if (!map.containsKey(pq.peek().name)) {
                pq.poll();
            } else {
                break;
            }
        }

        if (pq.isEmpty()) {
            io.println("The clinic is empty");
        } else {
            io.println(pq.peek());
        }
    }

    public static void printQueue(PriorityQueue<Pair> pq) {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Current Queue: ===");

        while (!pq.isEmpty()) {
            sb.append("\n" + pq.poll());

        }

        sb.append("\n" + "=== End of Queue ===");
        System.out.println(sb.toString());
    }

    public static void executeCommand(Kattio io, int command, PriorityQueue<Pair> pq, Map<String, Integer> map) {
        switch (command) {
            case 0: 
                String catNameToAdd = io.getWord();
                int infectionLevel = io.getInt();
                addCatToQueue(catNameToAdd, infectionLevel, pq, map);
                break;
            case 1:
                String catNameToUpdate = io.getWord();
                int infectionLevelToAdd = io.getInt();
                updateCatInfection(catNameToUpdate, infectionLevelToAdd, pq, map);
                break;
            case 2:
                String catNameToTreat = io.getWord();
                treatCat(catNameToTreat, pq, map);
                break;
            default:
                // printQueue(pq);
                queryQueue(io, pq, map);
        }
    }
    
    public static void main(String[] args) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
        Map<String, Integer> map = new HashMap<>();

        Kattio io = new Kattio(System.in, System.out);
        int n = io.getInt();

        while (n > 0) {
            int command = io.getInt();
            executeCommand(io, command, pq, map);
            n--;
        }

        io.close();
    }
}
