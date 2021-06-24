package prompt.medium;

import java.util.*;

public class BalancedBrackets {
    
    public static boolean balancedBrackets(String str) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('{', '}');
        map.put('(', ')');

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!isBracket(c)) {
                continue;
            }

            if (isClosingBracket(c)) {
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.peek();
                if (map.get(top) == c) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? true : false;
    }

    public static boolean isClosingBracket(char c) {
        if (c == ')' || c == ']' || c == '}') {
            return true;
        }

        return false;
    }

    public static boolean isBracket(char c) {
        if (c == '(' || c == '[' || c == '{' || c == ')' || c == ']' || c == '}') {
            return true;
        } else {
            return false;
        }
    }

    public static void TestCase1() {
        String input = "([])(){}(())()()";
        System.out.println(balancedBrackets(input));
    }

    public static void main(String[] args) {
        TestCase1();
    }
}
