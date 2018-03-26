package leetcode;

import java.util.Stack;

public class Q227BasicCalculatorII {
//    https://leetcode.com/problems/basic-calculator-ii/description/

    public int calculate(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if ((c != ' ' && !Character.isDigit(c)) || i + 1 == s.length()){
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }


    public int calculate1(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        s = s.trim();
        char preOp = '+';
        long preNum = 0;
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            }
            if (Character.isDigit(c)) {
                int val = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    val = val * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                if (preOp == '+') {
                    sum += preNum;
                    preNum = val;
                } else if (preOp == '-') {
                    sum += preNum;
                    preNum = -val;
                } else if (preOp == '*') {
                    preNum = preNum * val;
                } else if (preOp == '/') {
                    preNum /= val;
                }
            } else {
                preOp = c;
            }
        }
        sum += preNum;
        return sum;
    }
}
