package sword2offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Q59Part1 {
// 面试题59（一）：滑动窗口的最大值
// 题目：给定一个数组和滑动窗口的大小，请找出所有滑动窗口里的最大值。例如，
// 如果输入数组{2, 3, 4, 2, 6, 2, 5, 1}及滑动窗口的大小3，那么一共存在6个
// 滑动窗口，它们的最大值分别为{4, 4, 6, 6, 6, 5}，

    public ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> maxList = new ArrayList<>();
        if (num != null && size > 0 && num.length >= size) {
            Deque<Integer> queue = new ArrayDeque<>();
            for (int i = 0; i < size; i++) {
                //初始化，第一个窗口中的值
                while (!queue.isEmpty() && num[queue.peekLast()] <= num[i]) {
                    queue.pollLast();
                }
                queue.addLast(i);
            }
            for (int i = size; i < num.length; i++) {
                //队列的头元素是窗口的最大值
                maxList.add(num[queue.peekFirst()]);
                while (!queue.isEmpty() && num[queue.peekLast()] <= num[i]) {
                    //队列中小于数组第 i 个元素的，从队列尾部删除
                    queue.pollLast();
                }
                if (!queue.isEmpty() && queue.peekFirst() <= (i - size)) {
                    //如果头部元素超出窗口范围，把它从队列头部删除
                    queue.pollFirst();
                }
                queue.addLast(i);
            }
            maxList.add(num[queue.peekFirst()]);
        }
        return maxList;
    }
}
