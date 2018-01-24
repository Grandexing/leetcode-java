package sword2offer;

import classes.ListNode;

public class Q23 {
    public ListNode EntryNodeOfLoop1(ListNode pHead)
    {
        ListNode nodeInLoop = meetingNode(pHead);
        if (nodeInLoop == null) return null;
//        这里从1开始
        int loopCount = 1;
        ListNode node1 = nodeInLoop;
        while (node1.next != nodeInLoop) {
            loopCount++;
            node1 = node1.next;
        }
//        第一个指针先走 loop 步
        node1 = pHead;
        for (int i = 0; i < loopCount; i++) {
            node1 = node1.next;
        }
//        假设head到loop起点距离是a，此时node1距离起点和node2距离起点的距离都是a，二者相遇时，就是起点
        ListNode node2 = pHead;
        while (node1 != node2) {
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1;
    }


    ListNode meetingNode(ListNode pHead) {
        if (pHead == null) return null;
        ListNode slow = pHead;
        ListNode fast = pHead;
        //fast 每次走两格，slow每次走一格，如果有环，两个节点最终会相遇
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return fast;
        }
        return null;
    }


    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null) return pHead;
        ListNode slow, fast;
        slow = pHead;
        fast = pHead;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                while (pHead != slow) {
                    pHead = pHead.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
