package Medium;

import java.util.*;

class Program {

    static class MinMaxStack {

        // All operations are done in time: O(1) and space: O(1)

        List<int[]> trackMinMax = new ArrayList<>();
        List<Integer> stack = new ArrayList<>();

        public int peek() {
            return stack.get(stack.size() - 1);
        }

        public int pop() {
            int eleToRemove = stack.remove(stack.size() - 1);
            trackMinMax.remove(trackMinMax.size() - 1);
            return eleToRemove;
        }

        public void push(Integer number) {
            if (stack.size() == 0) {
                trackMinMax.add(new int[] {number, number});
                stack.add(number);
            } else {
                int[] prevMinMax = trackMinMax.get(trackMinMax.size() - 1);
                int currMin = prevMinMax[0];
                int currMax = prevMinMax[1];
                int[] pairToAdd = new int[]{number < currMin ? number : currMin, number > currMax ? number : currMax};

                trackMinMax.add(pairToAdd);
                stack.add(number);
            }
        }

        public int getMin() {
            int[] lastPair = trackMinMax.get(trackMinMax.size() - 1);
            return lastPair[0];
        }

        public int getMax() {
            int[] lastPair = trackMinMax.get(trackMinMax.size() - 1);
            return lastPair[1];
        }

        public static void main(String[] args) {
            MinMaxStack stack = new MinMaxStack();
            stack.push(5);
            stack.getMin();
            stack.getMax();
            stack.push(7);
            stack.getMin();
            stack.getMax();
            stack.peek();
            stack.push(2);
            stack.getMin();
            stack.getMax();
            stack.peek();
            stack.pop();
            stack.pop();
            stack.getMin();
            stack.getMax();
            stack.peek();
        }
    }
}

