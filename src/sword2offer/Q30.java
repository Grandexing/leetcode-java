package sword2offer;

import java.util.Stack;

public class Q30 {
    Stack<Integer> dataStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();
    public void push(int node) {
        dataStack.push(node);
        if (minStack.isEmpty() || node < minStack.peek()) {
            minStack.push(node);
        } else {
            minStack.push(minStack.peek());
        }
    }

    public void pop() {
        if (!dataStack.isEmpty() && !minStack.isEmpty()) {
            dataStack.pop();
            minStack.pop();
        }
    }

    public int top() {
        if (dataStack.isEmpty()) return 0;
        return dataStack.peek();
    }

    public int min() {
        if (minStack.isEmpty()) return 0;
        return minStack.peek();
    }
}
