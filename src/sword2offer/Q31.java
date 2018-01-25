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
//                如果栈是空的，或栈顶元素不等于弹出序列的元素
                while (stack.isEmpty() || stack.peek() != popA[popIndex]) {
                    if (pushIndex == pushA.length) {
                        break;
                    }
                    stack.push(pushA[pushIndex]);
                    pushIndex++;
                }
//                如果栈顶元素不等于弹出序列元素，说明不匹配，直接break
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
