package prompt.easy;

import java.util.*;

public class ProductSum {
    
    public static int productSum(List<Object> array) {
        return productSum(array, 1);
    }

    public static int productSum(List<Object> array, int depth) {
        int sum = 0;
        
        for (Object obj : array) {
            if (obj instanceof ArrayList) {
                @SuppressWarnings("unchecked")
                ArrayList<Object> ls = (ArrayList) obj;
                sum += productSum(ls, depth + 1);
            } else {
                sum += (int) obj;
            }
        }

        return sum * depth;
    }

    public static void main(String[] args) {
        List<Object> test =
        new ArrayList<Object>(
            Arrays.asList(
                5,
                2,
                new ArrayList<Object>(Arrays.asList(7, -1)),
                3,
                new ArrayList<Object>(
                    Arrays.asList(6, new ArrayList<Object>(Arrays.asList(-13, 8)), 4))));
        
        System.out.println(productSum(test) == 12);
  }

}
