package prompt.easy;

public class NthFibonacci {
    
    public static int getNthFib(int n) {
        int[] start = new int[] {0 , 1};

        if (n == 0) {
            return start[0];
        } else if (n == 1) {
            return start[0];
        } else {
            while (n >= 2) {
                int temp = start[0] + start[1];
                start[0] = start[1];
                start[1] = temp;
                n--;
            }
        }   
        
        return start[0];
    }

    public static void main(String[] args) {
        System.out.println(getNthFib(6) == 5);
    }
}
