package prompt.medium;

import java.util.*;

public class MinMaxStackConstruction {
    
    static class MinMaxStack {
        public int peek() {
          // Write your code here.
            return -1;
        }
    
        public int pop() {
          // Write your code here.
            return -1;
        }
    
        public void push(Integer number) {
          // Write your code here.
        }
    
        public int getMin() {
          // Write your code here.
            return -1;
        }
    
        public int getMax() {
          // Write your code here.
            return -1;
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
