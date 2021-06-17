package prompt.medium;

public class ValidStartingCity {
    
    public static int validStartingCity(int[] distances, int[] fuel, int mpg) {
        int cityIndex = 0;
        int runningDistance = 0;
        int minimumDistance = Integer.MAX_VALUE;

        for (int i = 1; i < distances.length; i++) {
            runningDistance += (fuel[i - 1] * mpg - distances[i - 1]);

            if (runningDistance < minimumDistance) {
                minimumDistance = runningDistance;
                cityIndex = i;
            }
        }

        return cityIndex;
    }

    public static void TestCase1() {
        int[] distances = new int[] {5, 25, 15, 10, 15};
        int[] fuel = new int[] {1, 2, 1, 0, 3};
        int mpg = 10;
        int expected = 4;
        var actual = validStartingCity(distances, fuel, mpg);
        System.out.println(expected == actual);
    }

    public static void main(String[] args) {
        TestCase1();
    }
}
