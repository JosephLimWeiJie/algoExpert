package Hard;

import java.util.*;

// Do not edit the class below except for
// the insert method. Feel free to add new
// properties and methods to the class.
class Program {
    static class ContinuousMedianHandler {
        double median = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        public void insert(int number) {

            // Time:  O(log(n))
            // Space: O(n)

            if (maxHeap.size() == 0 || number < maxHeap.peek()) {
                maxHeap.add(number);
            } else {
                minHeap.add(number);
            }

            rebalanceHeaps();
            updateMedian();
        }

        public void rebalanceHeaps() {
            if (maxHeap.size() - minHeap.size() >= 2) {
                minHeap.add(maxHeap.remove());
            } else if (minHeap.size() - maxHeap.size() >= 2) {
                maxHeap.add(minHeap.remove());
            }
        }

        public void updateMedian() {
            if (maxHeap.size() == minHeap.size()) {
                median = ((double) maxHeap.peek() + (double) minHeap.peek()) / 2;
            } else if (maxHeap.size() > minHeap.size()) {
                median = maxHeap.peek();
            } else {
                median = minHeap.peek();
            }
        }

        public double getMedian() {
            return median;
        }
    }
}
