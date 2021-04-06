package prompt.easy;

import java.util.*;
import java.io.*;

public class TournamentWinner {

    public static String tournamentWinner(ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < competitions.size(); i++) {
            ArrayList<String> competition = competitions.get(i);

            if (results.get(i) == 1) {
                // home team wins
                map.put(competition.get(0), map.getOrDefault(competition.get(0), 0) + 3);
            } else {
                // away team wins
                map.put(competition.get(1), map.getOrDefault(competition.get(1), 0) + 3);
            }
        }

        int maxScore = 0;
        String winner = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxScore) {
                maxScore = entry.getValue();
                winner = entry.getKey();
            }
        }

        return winner;
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
        String expected = "Python";

        System.out.println(expected.equals(tournamentWinner(competitions, results)));
    }
}
