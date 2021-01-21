package VeryHard;

import java.util.*;

class Program {

    public static List<Integer> mergeSortedArrays(List<List<Integer>> arrays) {

        // Time:  O(n * log(k) + k) where n is the total elements and k is the number of internal arrays.
        // Space: O(n * log(k) + k)

        List<Integer> result = new ArrayList<>();
        int[] idxMarker = new int[arrays.size()];

        PriorityQueue<Tuple> pq = new PriorityQueue<>(new TupleComparator());

        for (int i = 0; i < arrays.size(); i++) {
            pq.add(new Tuple(arrays.get(i).get(0), i, 0));
        }

        while (!pq.isEmpty()) {
            Tuple toRemove = pq.remove();
            int val = toRemove.val;
            int arrId = toRemove.arrId;
            int posId = toRemove.posId;

            result.add(val);
            System.out.println(result);

            idxMarker[arrId]++;
            int newPosId = idxMarker[arrId];

            if (newPosId >= arrays.get(arrId).size()) {
                continue;
            }

            Tuple toAdd = new Tuple(arrays.get(arrId).get(newPosId), arrId, newPosId);
            pq.add(toAdd);
        }

        return result;
    }

    public static class TupleComparator implements Comparator<Tuple> {
        public int compare(Tuple t1, Tuple t2) {
            if (t1.val < t2.val) {
                return -1;
            } else if (t1.val == t2.val) {
                return 0;
            } else {
                return 1;
            }
        }
    }

    public static class Tuple {
        int val;
        int arrId;
        int posId;

        public Tuple(int val, int arrId, int posId) {
            this.val = val;
            this.arrId = arrId;
            this.posId = posId;
        }

        public String toString() {
            return "(" + this.val + ", " + this.arrId + ", " + this.posId + ")";
        }
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 5, 9, 21);
        List<Integer> arr2 = Arrays.asList(-1, 0);
        List<Integer> arr3 = Arrays.asList(-124, 81, 121);
        List<Integer> arr4 = Arrays.asList(3, 6, 12, 20, 150);
        List<List<Integer>> test = new ArrayList<>();

        test.add(arr);
        test.add(arr2);
        test.add(arr3);
        test.add(arr4);

        System.out.println(mergeSortedArrays(test));
    }
}
