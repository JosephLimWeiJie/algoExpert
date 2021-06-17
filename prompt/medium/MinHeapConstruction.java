package prompt.medium;

import java.util.*;

public class MinHeapConstruction {

    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();
    
        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }
    
        public List<Integer> buildHeap(List<Integer> array) {
            int lastNonLeafNodeIdx = (array.size() / 2) - 1;
            for (int i = lastNonLeafNodeIdx; i >= 0; i--) {
                siftDown(i, array.size() - 1, array);
            }

            return array;
        }
    
        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            int leftChildIdx = (currentIdx * 2) + 1;
            
            while (leftChildIdx <= endIdx) {
                int rightChildIdx = (currentIdx * 2) + 2;
                
                if (rightChildIdx > endIdx) {
                    rightChildIdx = -1;
                }

                int idxToSwap = 0;
                if (rightChildIdx != -1 && heap.get(rightChildIdx) < heap.get(leftChildIdx)) {
                    idxToSwap = rightChildIdx;
                } else {
                    idxToSwap = leftChildIdx;
                }

                if (heap.get(currentIdx) > heap.get(idxToSwap)) {
                    swap(currentIdx, idxToSwap, heap);
                    currentIdx = idxToSwap;
                    leftChildIdx = (currentIdx * 2) + 1;
                } else {
                    return;
                }

            }
        }
    
        public void siftUp(int currentIdx, List<Integer> heap) {
            int parentIdx = (currentIdx - 1) / 2;

            while (parentIdx > 0 && heap.get(currentIdx) < heap.get(parentIdx)) {
                swap(currentIdx, parentIdx, heap);
                currentIdx = parentIdx;
                parentIdx = (currentIdx - 1) / 2;
            }
        }
    
        public int peek() {
            if (this.heap.size() == 0) {
                return -1;
            }
            return this.heap.get(0);
        }
    
        public int remove() {
            swap(0, this.heap.size() - 1, this.heap);
            int toRemove = this.heap.remove(this.heap.size() - 1);
            this.siftDown(0, this.heap.size() - 1, this.heap);
            return toRemove;
        }
    
        public void insert(int value) {
            this.heap.add(value);
            this.siftUp(this.heap.size() - 1, this.heap);
        }

        public void swap(int to, int from, List<Integer> heap) {
            int temp = heap.get(from);
            heap.set(from, heap.get(to));
            heap.set(to, temp);
        }
    }

    public static void TestCase1() {
        MinHeap minHeap =
            new MinHeap(
                new ArrayList<Integer>(
                    Arrays.asList(48, 12, 24, 7, 8, -5, 24, 391, 24, 56, 2, 6, 8, 41)));
        minHeap.insert(76);
        System.out.println(isMinHeapPropertySatisfied(minHeap.heap));
        System.out.println(minHeap.peek() == -5);
        System.out.println(minHeap.remove() == -5);
        System.out.println(isMinHeapPropertySatisfied(minHeap.heap));
        System.out.println(minHeap.peek() == 2);
        System.out.println(minHeap.remove() == 2);
        System.out.println(isMinHeapPropertySatisfied(minHeap.heap));
        System.out.println(minHeap.peek() == 6);
        minHeap.insert(87);
        System.out.println(isMinHeapPropertySatisfied(minHeap.heap));
    }
    
    static boolean isMinHeapPropertySatisfied(List<Integer> array) {
        for (int currentIdx = 1; currentIdx < array.size(); currentIdx++) {
            int parentIdx = (currentIdx - 1) / 2;
            if (parentIdx < 0) {
                return true;
            }
            if (array.get(parentIdx) > array.get(currentIdx)) {
                return false;
            }
        }
    
        return true;
    }

    public static void main(String[] args) {
        TestCase1();
    }
    
}
