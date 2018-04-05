package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Q368ExpressionEvaluation {
//    http://www.lintcode.com/en/problem/expression-evaluation/

    public static void main(String[] args) {
        String[] expression = {"2","*","6","-","(","23","+","7",")","/","(","1","+","2",")"};
        Q368ExpressionEvaluation q = new Q368ExpressionEvaluation();
        System.out.println(q.infixToPostfix(expression));
    }

    public int evaluateExpression(String[] expression) {
        // write your code here
        if (expression == null || expression.length == 0) {
            return 0;
        }
        return evalPostfix(infixToPostfix(expression));
    }


    private int evalPostfix(List<String> postfix) {
        if (postfix.isEmpty()) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        for (String token : postfix) {
            if(!isOperator(token)) {
                stack.push(Integer.parseInt(token));
            } else {
                int right = stack.pop();
                int left = stack.pop();
                stack.push(cal(left, right, token));
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


    private List<String> infixToPostfix(String[] expression) {
        List<String> postfix = new ArrayList<>();
        Stack<String> operators = new Stack<>();

        for (String token : expression) {
            System.out.println(token);
            if (!operators.isEmpty()) {
                System.out.println("stack:"+operators.peek());
            }
            System.out.println();
            if (token.equals("(")) {
                operators.push(token);
            } else if (token.equals(")")) {
//                System.out.println(operators.peek());
                while (!operators.peek().equals("(")) {
                    postfix.add(operators.pop());
                }
                operators.pop();
            } else if (isOperator(token)) {
                while (!operators.isEmpty() && rank(token) <= rank(operators.peek())) {
                    postfix.add(operators.pop());
                }
                operators.push(token);
            } else {
//                数字
                postfix.add(token);
            }
        }
        while (!operators.isEmpty()) {
            postfix.add(operators.pop());
        }
        return postfix;
    }
    String operatorSet = "+-*/";
    private boolean isOperator(String s) {
        return operatorSet.contains(s);
    }


    private int rank(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
//            for "("
                return 0;
        }
    }
}
