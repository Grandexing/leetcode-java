package lintcode;

import java.util.Stack;

public class Q12MinStack {
//    http://www.lintcode.com/en/problem/min-stack/


    public Q12MinStack() {
        // do intialization if necessary
        minStack = new Stack<>();
        stack = new Stack<>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */

    private Stack<Integer> minStack;
    private Stack<Integer> stack;


    public void push(int number) {
        // write your code here
        stack.push(number);
        if (minStack.isEmpty()) {
            minStack.push(number);
        } else {
            minStack.push(Math.min(minStack.peek(), number));
        }
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        minStack.pop();
        return stack.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return minStack.peek();
    }
}
