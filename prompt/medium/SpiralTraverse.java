package prompt.medium;

import java.util.*;

public class SpiralTraverse {

    public static List<Integer> spiralTraverse(int[][] array) {
        List<Integer> ans = new ArrayList<>();

        int startCol = 0;
        int endCol = array[0].length - 1;
        int startRow = 0;
        int endRow = array.length - 1;
        
        while (startCol <= endCol && startRow <= endRow) {

            // Left to Right
            for (int i = startCol; i <= endCol; i++) {
                ans.add(array[startRow][i]);
            }
            
            // Right to Down
            for (int j = startRow + 1; j <= endRow; j++) {
                ans.add(array[j][endCol]);
            }
            
            // Down to Left
            for (int k = endCol - 1; k >= startCol; k--) {
                if (startRow == endRow) {
                    break;
                }
                ans.add(array[endRow][k]);
            }

            // Left to Up
            for (int l = endRow - 1; l > startRow; l--) {
                if (startCol == endCol) {
                    break;
                }
                ans.add(array[l][startCol]);
            }

            endCol--;
            startRow++;
            endRow--;
            startCol++;
            
        }
        System.out.println(ans);
        return ans;
    }
    
    public static void main(String[] args) {
        var input =
            new int[][] {
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7},
                };
        var expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16);
        var actual = spiralTraverse(input);
        System.out.println(expected.equals(actual));
    }
}   
