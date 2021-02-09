package Easy;

import java.util.*;
import static java.util.stream.Collectors.toCollection;

class Program {

    public static String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {

        // Time:  O(n)
        // Space: O(k) where k is the number of teams

        // k: team name, v: score
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < competitions.size(); i++) {
            ArrayList<String> curr = competitions.get(i);
            int winner = results.get(i);

            if (winner == 1) {
                if (map.containsKey(curr.get(0))) {
                    map.put(curr.get(0), map.get(curr.get(0)) + 3);
                } else {
                    map.put(curr.get(0), 0);
                }
            } else if (winner == 0) {
                if (map.containsKey(curr.get(1))) {
                    map.put(curr.get(1), map.get(curr.get(1)) + 3);
                } else {
                    map.put(curr.get(1), 0);
                }
            }
        }

        int highestCount = Integer.MIN_VALUE;
        String winningTeam = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > highestCount) {
                highestCount = entry.getValue();
                winningTeam = entry.getKey();
            }
        }

        return winningTeam;
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<String>> competitions = new ArrayList<ArrayList<String>>();
        ArrayList<String> competition1 = new ArrayList<String>(Arrays.asList("HTML", "C#"));
        ArrayList<String> competition2 = new ArrayList<String>(Arrays.asList("C#", "Python"));
        ArrayList<String> competition3 = new ArrayList<String>(Arrays.asList("Python", "HTML"));
        competitions.add(competition1);
        competitions.add(competition2);
        competitions.add(competition3);
        ArrayList<Integer> results = new ArrayList<Integer>(Arrays.asList(0, 0, 1));
        System.out.println(tournamentWinner(competitions, results));
    }
}
