package prompt.easy;

import java.util.*;

public class ClassPhotos {
    
    public static boolean classPhotos(
        ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);

        boolean startRed = (redShirtHeights.get(0) < blueShirtHeights.get(0)) ? true : false;
        for (int i = 0; i < redShirtHeights.size(); i++) {
            if (startRed) {
                if (redShirtHeights.get(i) > blueShirtHeights.get(i)) {
                    return false;
                }
            } else {
                if (redShirtHeights.get(i) <= blueShirtHeights.get(i)) {
                    return false;
                }
            }
        }
        
        return true;
    }

    public static void main(String[] args) {
        ArrayList<Integer> redShirtHeights = new ArrayList<Integer>(Arrays.asList(5, 8, 1, 3, 4));
        ArrayList<Integer> blueShirtHeights = new ArrayList<Integer>(Arrays.asList(6, 9, 2, 4, 5));
        boolean expected = true;
        boolean actual = classPhotos(redShirtHeights, blueShirtHeights);
        System.out.println(expected == actual);
    }
}
