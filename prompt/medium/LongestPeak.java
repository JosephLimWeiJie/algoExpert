package prompt.medium;

public class LongestPeak {
    
    public static int longestPeak(int[] array) {
        if (array.length < 3) {
            return 0;
        }

        int longestPeak = 0;

        for (int i = 1; i < array.length - 1; i++) {
            if (array[i - 1] < array[i] && array[i] > array[i + 1]) {
                // found peak
                int currPeak = 1;
                int left = i;
                while (left > 0 && array[left] > array[left - 1]) {
                    currPeak++;
                    left--;
                }

                int right = i;
                while (right < array.length - 1 && array[right] > array[right + 1]) {
                    currPeak++;
                    right++;
                }

                longestPeak = (currPeak > longestPeak) ? currPeak : longestPeak;
            }
        }

        return longestPeak;
    }

    public static void main(String[] args) {
        var input = new int[] {1, 2, 3, 3, 4, 0, 10, 6, 5, -1, -3, 2, 3};
        var expected = 6;
        var actual = longestPeak(input);
        System.out.println(expected == actual);
    }
}
