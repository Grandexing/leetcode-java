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

//更省空间的版本
    public void push1(int number) {
        // write your code here
        stack.push(number);
        if (minStack.isEmpty()) {
            minStack.push(number);
        } else {
            if (minStack.peek() >= number) {
                // 相等的情况也要push
                minStack.push(number);
            }
        }
    }

    /*
     * @return: An integer
     */
    public int pop1() {
        // write your code here
        int num = stack.pop();
        if (minStack.peek() == num) {
            minStack.pop();
        }
        return num;
    }

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
