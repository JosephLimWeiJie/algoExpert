import java.util.*;

class Program {
    // Tip: You can use `element instanceof ArrayList` to check whether an item
    // is an array or an integer.

    public static int productSum(List<Object> array) {

        // Time: O(n)
        // Space: O(h) where h is the height of the tallest recursion tree.

        return productSum(array, 1);
    }

    public static int productSum(List<Object> array, int depth) {
        int ans = 0;

        for (Object obj : array) {
            if (obj instanceof ArrayList) {
                @SuppressWarnings("unchecked")
                ArrayList<Object> obj2 = (ArrayList<Object>) obj;
                ans += productSum(obj2, depth + 1);
            } else {
                ans += (Integer) obj;
            }
        }

        return ans * depth;
    }
}
