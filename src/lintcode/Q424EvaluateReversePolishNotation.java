package lintcode;

import java.util.Stack;

public class Q424EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        // write your code here
        String operators = "+-*/";
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (operators.contains(token)) {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(cal(left, right, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }


    private int cal(int left, int right, String operator) {
        int res = 0;
        if (operator.equals("+")) {
            res =  left + right;
        } else if (operator.equals("-")) {
            res =  left - right;
        } else if (operator.equals("*")) {
            res = left * right;
        } else {
            res = left / right;
        }
        return res;
    }
}
