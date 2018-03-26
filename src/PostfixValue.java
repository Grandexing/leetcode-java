import java.util.Stack;

public class PostfixValue {
    public static void main(String[] args) {
        System.out.println(profixValue("34+5*6-"));
    }


    public static int profixValue(String postfix) {
        if (postfix == null || postfix.isEmpty()) {
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        char c;
        int num = 0;
        for (int i = 0; i < postfix.length(); i++) {
            c = postfix.charAt(i);
            if (Character.isDigit(c)) {
                stack.push(c - '0');
            } else {
                int right = stack.pop();
                int left = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(left + right);
                        break;
                    case '-':
                        stack.push(left - right);
                        break;
                    case '*':
                        stack.push(left * right);
                        break;
                    case '/':
                        stack.push(left / right);
                        break;
                    default:
                        break;
                }
            }
        }
        return stack.pop();
    }
}
