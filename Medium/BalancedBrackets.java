package Medium;

import java.util.*;

class Program {

    public static boolean balancedBrackets(String str) {

        // Time:  O(n)
        // Space: O(n)

        List<Character> stack = new ArrayList<>();
        Map<Character, Character> matchingBrackets = new HashMap<>();
        matchingBrackets.put(')', '(');
        matchingBrackets.put('}', '{');
        matchingBrackets.put(']', '[');

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.add(c);
                continue;
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.size() == 0) {
                    return false;
                }

                if (stack.get(stack.size() - 1) == matchingBrackets.get(c)) {
                    stack.remove(stack.size() - 1);
                } else {
                    return false;
                }
            }

        }

        if (stack.size() == 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String str = "([])(){}(())()()";
        System.out.println(balancedBrackets(str));
    }
}
