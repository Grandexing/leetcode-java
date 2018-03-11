package lintcode;

import java.util.Stack;

public class Q122LargestRectangleinHistogram {
    /**
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     * 解析：
     * http://www.cnblogs.com/zl1991/p/7071930.html
     *
     * http://www.lintcode.com/zh-cn/problem/largest-rectangle-in-histogram/
     *
     * bugfree
     * 1. stack.pop() 应该是 height[stack.pop()]
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        if (height == null || height.length == 0) {
            return 0;
        }
        int max = 0;
        // 存储满足升序条件的 index
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <= height.length; i++) {
            // 边界是小于等于而不是小于，最后压入一个 -1，保证出现一次降序
            int curt = i == height.length ? -1 : height[i];
            while (!stack.isEmpty() && curt <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        return max;
    }
}
