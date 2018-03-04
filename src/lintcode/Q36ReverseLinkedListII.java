package lintcode;

import classes.ListNode;

public class Q36ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        if (head == null || m >= n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        ListNode nodeBeforeReverse = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode curt = mNode.next;
        for (int i = m; i < n; i++) {
            if (curt == null) {
                return null;
            }
            ListNode next = curt.next;
            curt.next = nNode;
            nNode = curt;
            curt = next;
        }
        mNode.next = curt;
        nodeBeforeReverse.next = nNode;
        return dummy.next;
    }
}
