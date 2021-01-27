package Medium;

import java.util.*;

class Program {

    public static ArrayList<ArrayList<Integer>> taskAssignment(int k, ArrayList<Integer> tasks) {

        // Time:  O(n * log(n))
        // Space: O(n)

        // k: tasks[i], v: id
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < tasks.size(); i++) {
            if (!map.containsKey(tasks.get(i))) {
                map.put(tasks.get(i), new LinkedList<Integer>());
            }
            map.get(tasks.get(i)).add(i);
        }

        Collections.sort(tasks);

        int leftIdx = 0;
        int rightIdx = tasks.size() - 1;
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        while (leftIdx < rightIdx) {
            ArrayList<Integer> toAdd = new ArrayList<>();
            toAdd.add(map.get(tasks.get(leftIdx)).poll());
            toAdd.add(map.get(tasks.get(rightIdx)).poll());
            ans.add(toAdd);
            leftIdx++;
            rightIdx--;
        }

        return ans;
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = new int[] {1, 3, 5, 3, 1, 4};
        ArrayList<Integer> tasks = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            tasks.add(arr[i]);
        }
        System.out.println(taskAssignment(k, tasks));
    }
}
