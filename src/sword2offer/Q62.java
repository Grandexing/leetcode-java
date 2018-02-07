package sword2offer;

import java.util.LinkedList;

public class Q62 {
// 面试题62：圆圈中最后剩下的数字
// 题目：0, 1, …, n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里
// 删除第m个数字。求出这个圆圈里剩下的最后一个数字。

    public int LastRemaining_Solution(int n, int m) {
//        使用环形链表
        if (n < 1 || m < 1) return -1;
        LinkedList<Integer> circle = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            circle.add(i);
        }
        int current = 0;
        int size = circle.size();
        while (size > 1) {
//            移动 current m步，如果超过size，则取余，相当于从链表头部再次进入，实现环形链表
            current = (current + m - 1) % size;
            circle.remove(current);
            size--;
        }
        return circle.getFirst();
    }


    public int LastRemaining_Solution1(int n, int m) {
//        非递归解法
        if (n < 1 || m < 1) return -1;
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
