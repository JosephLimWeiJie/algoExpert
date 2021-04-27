package interview_questions;

public class PartitionEqualSubsetSum {
    
    public static boolean partitionEqualSubsetSum(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        
        
        if (sum % 2 != 0) {
            return false;
        }

        sum /= 2;
        boolean[] board = new boolean[sum + 1];
        // base case for dynamic programming
        board[0] = true;

        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                if (board[sum] == true) {
                    return true;
                }

                board[j] = board[j] || board[j - nums[i]];
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 5, 11, 5};
        boolean actual = partitionEqualSubsetSum(arr);
        System.out.println(actual == true);

        int[] arr2 = new int[] {1, 2, 3, 5};
        boolean actual2 = partitionEqualSubsetSum(arr2);
        System.out.println(actual2 == false);
    }
}
