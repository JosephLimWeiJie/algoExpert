package Medium;

import java.util.*;

// Do not edit the class below except for the buildHeap,
// siftDown, siftUp, peek, remove, and insert methods.
// Feel free to add new properties and methods to the class.
class Program {
    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        public List<Integer> buildHeap(List<Integer> array) {
            int firstParentIdx = (array.size() - 2) / 2;
            for (int currIdx = firstParentIdx; currIdx >= 0; currIdx--) {
                siftDown(currIdx, array.size() - 1, array);
            }
            return array;
        }

        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            int leftChildIdx = currentIdx * 2 + 1;

            while (leftChildIdx <= endIdx) {
                int rightChildIdx = currentIdx * 2 + 2;
                int idxToSwap = 0;
                // check if rightChild exists
                rightChildIdx = (rightChildIdx <= endIdx) ? rightChildIdx : -1;

                if (rightChildIdx != -1 && heap.get(rightChildIdx) < heap.get(leftChildIdx)) {
                    idxToSwap = rightChildIdx;
                } else {
                    idxToSwap = leftChildIdx;
                }

                if (heap.get(idxToSwap) < heap.get(currentIdx)) {
                    swap(idxToSwap, currentIdx, heap);
                    currentIdx = idxToSwap;
                    leftChildIdx = currentIdx * 2 + 1;
                } else {
                    break;
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
            // Write your code here.
            if (heap.size() == 0) {
                return -1;
            }
            return heap.get(0);
        }

        public int remove() {
            swap(0, heap.size() - 1, heap);
            int toRemove = heap.remove(heap.size() - 1);
            siftDown(0, heap.size() - 1, heap);
            return toRemove;
        }

        public void insert(int value) {
            heap.add(value);
            siftUp(heap.size() - 1, heap);
        }

        public void swap(int i, int j, List<Integer> heap) {
            Integer temp = heap.get(j);
            heap.set(j, heap.get(i));
            heap.set(i, temp);
        }
    }
}
