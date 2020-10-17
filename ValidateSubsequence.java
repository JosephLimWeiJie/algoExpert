import java.util.*;

class Program {
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {

        // Time: O(n)
        // Space: O(1)

        int currSeqIndex = 0;
        int validCount = 0;

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == sequence.get(currSeqIndex)) {
                validCount++;
                currSeqIndex++;
            }

            if (validCount == sequence.size()) {
                return true;
            }
        }

        return false;
    }
}
