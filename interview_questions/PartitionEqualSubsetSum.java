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
        int[][] board = new int[nums.length + 1][sum + 1];

        for (int i = 1; i < board.length; i++) {
            int currNum = nums[i - 1];
            boolean hasConsideredCurrNum = false;
            for (int j = 1; j < board[i].length; j++) {
                if (currNum <= j) {
                    int prevNum = board[Math.max(i - 1, 0)][j];
                    if (currNum + prevNum <= j) {
                        board[i][j] = currNum + prevNum;
                    } else {
                        board[i][j] = currNum;
                    }
                } else {
                    board[i][j] = board[i][j - 1];
                }
                
                if (board[i][j] == sum) {
                    return true;
                }
            }
        }
        printArray(board);
        return false;
    }

    public static void printArray(int[][] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sb.append(arr[i][j] + ", ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
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
