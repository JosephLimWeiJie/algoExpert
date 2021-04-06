package prompt.easy;

import java.util.*;

public class GenerateDocument {

    public static boolean generateDocument(String characters, String document) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < characters.length(); i++) {
            map.put(characters.charAt(i), map.getOrDefault(characters.charAt(i), 0) + 1);
        }

        for (int j = 0; j < document.length(); j++) {
            if (!map.containsKey(document.charAt(j)) || map.get(document.charAt(j)) <= 0) {
                return false;
            }

            map.put(document.charAt(j), map.get(document.charAt(j)) - 1);
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String characters = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";
        boolean expected = true;
        var actual = generateDocument(characters, document);
        System.out.println(expected == actual);
    }
 
}
