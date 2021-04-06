package prompt.easy;

import java.util.*;

public class TandemBicycle {
    
    public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        int totalSpeed = 0;

        if (fastest) {
            int[] reverseBlueShirtSpeeds = new int[blueShirtSpeeds.length];
            for (int i = 0; i < blueShirtSpeeds.length; i++) {
                reverseBlueShirtSpeeds[blueShirtSpeeds.length - 1 - i] = blueShirtSpeeds[i];
            }

            for (int j = 0; j < blueShirtSpeeds.length; j++) {
                totalSpeed += (Math.max(reverseBlueShirtSpeeds[j], redShirtSpeeds[j]));
            }

        } else {
            for (int k = 0; k < blueShirtSpeeds.length; k++) {
                totalSpeed += (Math.max(blueShirtSpeeds[k], redShirtSpeeds[k]));
            } 
        }

        return totalSpeed;
    }

    public static void main(String[] args) {
        int[] redShirtSpeeds = new int[] {5, 5, 3, 9, 2};
        int[] blueShirtSpeeds = new int[] {3, 6, 7, 2, 1};
        boolean fastest = true;
        int expected = 32;
        var actual = tandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest);
        System.out.println(expected == actual);
    }
}
