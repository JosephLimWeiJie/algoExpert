package prompt.hard;

import java.util.*;

public class ContinuousMedian {

    public static class ContinuousMedianHandler {
        public double median = 0;
        public PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        public PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        public void insert(int number) {
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
            if ((maxHeap.size() == minHeap.size())) {
                median = ((double) maxHeap.peek() + (double) minHeap.peek()) / 2;
            } else if (maxHeap.size() > minHeap.size()) {
                median = (double) maxHeap.peek();
            } else {
                median = (double) minHeap.peek();
            }
        }
     
        public double getMedian() {
          return median;
        }
    }

    public static void TestCase1() {
        ContinuousMedianHandler handler = new ContinuousMedianHandler();
        handler.insert(5);
        handler.insert(10);
        System.out.println(handler.getMedian() == 7.5);
        handler.insert(100);
        System.out.println(handler.getMedian() == 10);
    }

    public static void main(String[] args) {
        TestCase1();
    }
}
