package sword2offer;

import classes.ListNode;

public class Q22 {
    public ListNode FindKthToTail(ListNode head, int k) {
//        k从1开始，k=1代表倒数第一个节点
        if (head == null || k <= 0) return null;
        ListNode pNode1, pNode2;
        pNode1 = head;
        for (int i = 0; i < k - 1; i++) {
//            k-2 的下一个节点不能是null，保证链表至少有k个节点
            if (pNode1.next != null) {
                pNode1 = pNode1.next;
            } else {
                return null;
            }
        }
        pNode2 = head;
        while (pNode1.next != null) {
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }
        return pNode2;
    }
}
