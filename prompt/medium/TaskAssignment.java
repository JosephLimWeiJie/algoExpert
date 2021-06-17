package prompt.medium;

import java.util.*;

public class TaskAssignment {
    
    public static ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {
        Map<Integer, Queue<Integer>> map = new HashMap<>();

        for (int i = 0; i < tasks.size(); i++) {
            if (!map.containsKey(tasks.get(i))) {
                map.put(tasks.get(i), new LinkedList<Integer>());
            }
            map.get(tasks.get(i)).add(i);
        }

        Collections.sort(tasks);

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int left = 0;
        int right = tasks.size() - 1;

        while (left < right) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(map.get(tasks.get(left)).poll());
            temp.add(map.get(tasks.get(right)).poll());
            left++;
            right--;
            ans.add(temp);
        }

        return ans;
    }

    public static void TestCase1() {
        var k = 3;
        var tasks = new ArrayList<Integer>(Arrays.asList(1, 3, 5, 3, 1, 4));
        var expected = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> subarr = new ArrayList<Integer>(Arrays.asList(4, 2));
        ArrayList<Integer> subarr2 = new ArrayList<Integer>(Arrays.asList(0, 5));
        ArrayList<Integer> subarr3 = new ArrayList<Integer>(Arrays.asList(3, 1));
        expected.add(subarr);
        expected.add(subarr2);
        expected.add(subarr3);
        var actual = taskAssignment(k, tasks);
        System.out.println(expected.equals(actual));
    }

    public static void main(String[] args) {
        TestCase1();
    }

}
