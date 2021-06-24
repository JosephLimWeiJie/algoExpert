package prompt.medium;

import java.util.*;

public class MinMaxStackConstruction {
    
    static class MinMaxStack {
        Stack<Integer[]> minMaxStack = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        
        public int peek() {
            return stack.peek();
        }
    
        public int pop() {
            minMaxStack.pop();
            return stack.pop();
        }
    
        public void push(Integer number) {
            stack.push(number);

            if (minMaxStack.empty()) {
                minMaxStack.push(new Integer[] {number, number});
            } else {
                Integer[] prevMinMaxPair = minMaxStack.peek();
                int prevMin = prevMinMaxPair[0];
                int prevMax = prevMinMaxPair[1];
    
                if (number < prevMin) {
                    minMaxStack.push(new Integer[] {number, prevMax});
                } else if (number > prevMax) {
                    minMaxStack.push(new Integer[] {prevMin, number});
                } else {
                  minMaxStack.push(prevMinMaxPair);
                }
            }
        }
    
        public int getMin() {
            Integer[] top = minMaxStack.peek();
            return top[0];
        }
    
        public int getMax() {
            Integer[] top = minMaxStack.peek();
            return top[1];
        }
    }

    public static void testMinMaxPeek(int min, int max, int peek, MinMaxStack stack) {
        System.out.println(stack.getMin() == min);
        System.out.println(stack.getMax() == max);
        System.out.println(stack.peek() == peek);
    }

    public static void TestCase1() {
        MinMaxStack stack = new MinMaxStack();
        stack.push(5);
        testMinMaxPeek(5, 5, 5, stack);
        stack.push(7);
        testMinMaxPeek(5, 7, 7, stack);
        stack.push(2);
        testMinMaxPeek(2, 7, 2, stack);
        System.out.println(stack.pop() == 2);
        System.out.println(stack.pop() == 7);
        testMinMaxPeek(5, 5, 5, stack);
    }

    public static void main(String[] args) {
        TestCase1();
    }
}
