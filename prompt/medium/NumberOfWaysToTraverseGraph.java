package prompt.medium;

public class NumberOfWaysToTraverseGraph {
    
    public static int numberOfWaysToTraverseGraph(int width, int height) {
        int[][] table = new int[height][width];
        table[0][0] = 1;

        // Fill top row with 1
        for (int i = 0; i < width; i++) {
            table[0][i] = 1;
        }

        // Fill leftmost col with 1
        for (int i = 0; i < height; i++) {
            table[i][0] = 1;
        }

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                table[i][j] = table[i - 1][j] + table[i][j - 1];
            }
        }

        return table[height -1][width - 1];
    }


    public static void TestCase1() {
        int width = 4;
        int height = 3;
        int expected = 10;
        var actual = numberOfWaysToTraverseGraph(width, height);
        System.out.println(expected == actual);
    }

    public static void main(String[] args) {
        TestCase1();
    }
}
