import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Caculator1 {
    public static void main(String[] args) {
        List<Object> postfix = infixToPostfix("3+(2-5)*6/3");
        for (Object p:postfix
             ) {
            System.out.print(p);
        }
        System.out.println(calculate1("(6+6)*6"));
    }


    static int calculate1(String s) {
        return evaluatePostfix1(infixToPostfix1(s));
    }


    static int evaluatePostfix1(List<Object> postfix) {
        Stack<Integer> numbers = new Stack<>();
        int left;
        int right;
        for (Object o : postfix) {
            if (o instanceof Character) {
                char c = (Character) o;
                right = numbers.pop();
                left = numbers.pop();
                switch (c) {
                    case '+':
                        numbers.push(left + right);
                        break;
                    case '-':
                        numbers.push(left - right);
                        break;
                    case '*':
                        numbers.push(left * right);
                        break;
                    case '/':
                        numbers.push(left / right);
                        break;
                    default:
                        break;
                }
            } else {
                numbers.push((Integer) o);
            }
        }
        return numbers.pop();
    }


    static List<Object> infixToPostfix1(String s) {
        Stack<Character> operators = new Stack<>();
        List<Object> postfix = new LinkedList<>();
        int number = 0;
        boolean hasNumber = false;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                number = number * 10 + c - '0';
                hasNumber = true;
            } else {
                if (hasNumber) {
                    postfix.add(number);
                }
                number = 0;
                hasNumber = false;
                if (c == ' ' || c == '\t') {
                    continue;
                }
                if (c == '(') {
                    operators.push(c);
                } else if (c == ')') {
                    while (operators.peek() != '(') {
//                        pop operator
                        postfix.add(operators.pop());
                    }
//                    pop (
                    operators.pop();
                } else {
//                    operator
                    while (!operators.isEmpty() && rank(c) <= rank(operators.peek())) {
                        postfix.add(operators.pop());
                    }
                    operators.push(c);
                }
            }
        }
        if (hasNumber) {
            postfix.add(number);
        }
        while (!operators.isEmpty()) {
            postfix.add(operators.pop());
        }
        return postfix;
    }


    static int rank(char op){
        // the bigger the number, the higher the rank
        switch(op){
            case '+':return 1;
            case '-':return 1;
            case '*':return 2;
            case '/':return 2;
            default :return 0; // '('
        }
    }


    static int evaluatePostfix(List<Object> postfix) {
        Stack<Integer> operands = new Stack<Integer>();
        int a = 0, b = 0;
        for (Object s : postfix) {
            if(s instanceof Character){
                char c = (Character) s;
                b = operands.pop();
                a = operands.pop();
                switch (c) {
                    case '+': operands.push(a + b); break;
                    case '-': operands.push(a - b); break;
                    case '*': operands.push(a * b); break;
                    default : operands.push(a / b);
                }
            }else { // instanceof Integer
                operands.push((Integer)s);
            }
        }
        return operands.pop();
    }

    public static int calculate(String s) {
        return evaluatePostfix(infixToPostfix(s));
    }


    static List<Object> infixToPostfix(String s) {
        Stack<Character> operators = new Stack<Character>();
        List<Object> postfix = new LinkedList<Object>();

        int numberBuffer = 0;
        boolean bufferingOperand = false;
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                numberBuffer = numberBuffer * 10 + c - '0';
                bufferingOperand = true;
            } else {
                if(bufferingOperand)
                    postfix.add(numberBuffer);
                numberBuffer = 0;
                bufferingOperand = false;

                if (c == ' '|| c == '\t')
                    continue;

                if (c == '(') {
                    operators.push('(');
                } else if (c == ')') {
                    while (operators.peek() != '(')
                        postfix.add(operators.pop());
                    operators.pop(); // popping "("
                } else { // operator
                    while (!operators.isEmpty() && rank(c) <= rank(operators.peek()))
                        postfix.add(operators.pop());
                    operators.push(c);
                }
            }

        }
        if (bufferingOperand)
            postfix.add(numberBuffer);

        while (!operators.isEmpty())
            postfix.add(operators.pop());

        return postfix;
    }

    public static int simpleCalculate(String s) {
        int sum = 0;
        int cur = 0;
        int prd = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                cur = cur * 10 + c - '0';
            } else if (c == '+') {
                sum += prd * cur;
                cur = 0;
                prd = 1;
            } else if (c == '-') {
                sum += prd * cur;
                cur = 0;
                prd = -1;
            } else if (c == '*') {
                prd *= cur;
                cur = 0;
            }
        }
        return sum + prd * cur;
    }
//

//    private static int preOrder(char left, char right) {
//        if (left == '+' || left == '-') {
//            if (right == '*' || right == '/')
//        }
//    }
}
