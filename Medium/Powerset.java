package Medium;

import java.lang.reflect.Array;
import java.util.*;

class Program {

    public static List<List<Integer>> powerset(List<Integer> array) {

        // Note that the total number of subsets in a set is mathematically (2 ^ n)
        // Time:  O(n * (2 ^ n))
        // Space: O(n * (2 ^ n))

        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // add empty set
        ans.add(new ArrayList<>());

        for (Integer num : array) {
            int length = ans.size();
            for (int i = 0; i < length; i++) {
                List<Integer> currSubset = new ArrayList<>(ans.get(i));
                currSubset.add(num);
                ans.add(currSubset);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>() {{
                                        add(1);
                                        add(2);
                                        add(3);
                            }};
        System.out.println(powerset(array));
    }
}

