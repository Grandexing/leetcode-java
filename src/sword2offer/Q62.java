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


/*
假设问题是从n个人编号分别为0...n-1，取第k个，
则第k个人编号为k-1的淘汰，剩下的编号为  0,1,2,3...k-2,k,k+1,k+2...
此时因为从刚刚淘汰那个人的下一个开始数起，因此重新编号把k号设置为0,则
k    0
k+1 1
...
0 n-k
1 n-k+1
假设已经求得了n-1个人情况下的最终胜利者保存在f[n-1]中，
则毫无疑问，该胜利者还原到原来的真正编号即为 (f[n-1]+k)%n
（因为第二轮重新编号的时候，相当于把每个人的编号都减了k，因此重新+k即可恢复到原来编号）。
由此，我们可以想象，当最终只剩下一个人的时候，该人即为胜利者，此时重新编号，
因为只有一个人，所以此时f[1]=0这样f[2]=(f[1]+k)%2,这样就可以求出最终胜利者在2个人的时候的情况下的编号，
由递推公式f[n]=(f[n-1]+k)%n,可递推到最初编号序列中该胜利者的编号。因此用这个方法，只需一遍On的扫描，即可求出最终答案
 */
}
