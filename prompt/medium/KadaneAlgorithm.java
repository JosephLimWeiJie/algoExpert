package prompt.medium;

public class KadaneAlgorithm {

    public static int kadanesAlgorithm(int[] array) {
        int runningSum = 0;
        int maxSum = 0; 

        for (int i = 0; i < array.length; i++) {
            runningSum = Math.max(runningSum + array[i], array[i]);
            maxSum = Math.max(maxSum, runningSum);
        }

        return maxSum;
    }

    public static void TestCase1() {
        int[] input = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        System.out.println(kadanesAlgorithm(input) == 19);
    }

    public static void main(String[] args) {
        TestCase1();
    }
}
