package sword2offer;

import java.util.Stack;

public class Q31 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        boolean possible = false;
        if (pushA != null && popA != null && pushA.length > 0 && pushA.length == popA.length) {
            int pushIndex = 0;
            int popIndex = 0;
            Stack<Integer> stack = new Stack<>();
            while (popIndex < popA.length) {
                while (stack.isEmpty() || stack.peek() != popA[popIndex]) {
                    if (pushIndex == pushA.length) {
                        break;
                    }
                    stack.push(pushA[pushIndex]);
                    pushIndex++;
                }
                if (stack.peek() != popA[popIndex]) {
                    break;
                }
                stack.pop();
                popIndex++;
            }
            if (stack.isEmpty() && popIndex == popA.length) {
                possible = true;
            }
        }
        return possible;
    }
}
