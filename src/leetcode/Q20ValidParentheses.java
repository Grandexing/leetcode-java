package leetcode;

import java.util.Stack;

public class Q20ValidParentheses {
//    https://leetcode.com/problems/valid-parentheses/description/

    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        String left = "({[";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (left.contains(String.valueOf(c))) {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && isValid(stack.peek(), c)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }


    private boolean isValid(char left, char right) {
        return (left == '(' && right == ')') || (left == '[' && right == ']') || (left == '{' && right == '}');
    }
}
