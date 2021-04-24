
import java.util.*;

public class SingleCycleCheck {
    
    public static boolean hasSingleCycle(int[] array) {
        
        int runningIdx = 0;

        while (true) {
            int steps = array[runningIdx];
            runningIdx = (runningIdx + steps) % array.length;
            if (runningIdx == 0) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(hasSingleCycle(new int[] {2, 3, 1, -4, -4, 2}));
    }
}
