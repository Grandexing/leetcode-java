package leetcode;

import java.util.Stack;

public class Q224BasicCalculator {
//    https://leetcode.com/problems/basic-calculator/description/


    public static void main(String[] args) {
        System.out.println(calculate("(9568+(9040-(380+(2042-(7115)+(6294)-(4395-(5183+9744+(7746-(1099+2718))-(9370-(8561+(9302)-(7632+(8451-(1759+(7760))-(3377+5363+9093+(8332-(4492-(1151+(1165-8833+(775+(3749)+9399))+9112+(6273+(7285-(6112-(668-(7756-4316-(582+1835-(6644+690+1204-(7197+(7897))+(7009-(7262))-7782-(7858+(7644+(9461+(2224)-(7531-1095-(891+1022)+2197-(9855)))+(6663-(7417-(6158-(3610))+(1481))-(4182+(4761)))+(5017))+(9990)+(6218)))-(2904)+(5631)-(8888)+3401+(3569))+(1135))-(3695-(7713+(3479)-(9813+(8171+(8616-8026+(4634-(6973))-(9761-(623-4782)+(2514)+(6233)))))+(6140))-(6641)-8611+(8389)+8074-(4412))-(3703)+(9688+(9513))))-(4987)))+(9647)))))))))-(2299))-(4785))))))"));
    }
    public static int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int number = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
            } else if (s.charAt(i) == '+') {
                result += number * sign;
                sign = 1;
                number = 0;
            } else if (s.charAt(i) == '-') {
                result += number * sign;
                sign = -1;
                number = 0;
            } else if (s.charAt(i) == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (s.charAt(i) == ')') {
                result += sign * number;
                result = result * stack.pop() + stack.pop();
                number = 0;
            }
        }
        if (number != 0) {
            result += sign * number;
        }
        return result;
    }
}
