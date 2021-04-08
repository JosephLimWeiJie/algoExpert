package prompt.medium;

public class MonotonicArray {
    
    public static boolean isMonotonic(int[] array) {
        if (array.length == 0 || array.length == 1) {
            return true;
        }

        // -1 -> negative 
        // 1 -> positive
        int setDirection = getDirection(array, 0, array.length - 1); 
        for (int i = 1; i < array.length - 1; i++) {
            int currDirection = getDirection(array, i, i + 1);
            if (currDirection == 0) {
                continue;
            }
            
            if (currDirection != setDirection) {
                return false;
            }
        }

        return true;
    }

    public static int getDirection(int[] array, int i, int j) {
        if (array[i] > array[j]) {
            return -1;
        } else if (array[i] < array[j]) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        var array = new int[] {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        var expected = true;
        var actual = isMonotonic(array);
        System.out.println(expected == actual);
    }
}
