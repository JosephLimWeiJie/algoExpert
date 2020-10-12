import java.util.*;

class Program {
    public static int getNthFib(int n) {

        // Time: O(n)
        // Space: O(1)

        // Write your code here.
        int[] res = new int[] {1, 0};

        while (n >= 0) {
            if (n == 0) {
                return res[0];
            } else if (n == 1) {
                return res[1];
            }

            int sum = res[1] + res[0];
            int second = res[1];
            res[0] = second;
            res[1] = sum;
            n--;
        }

        return res[0];
    }

    public static void main(String[] args) {
        System.out.println(getNthFib(5));
    }
}
