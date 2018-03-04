package lintcode;

import classes.ListNode;

public class Q450ReverseNodesinkGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        if (head == null || k <= 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev != null) {
            prev = reverseKNode(prev, k);
        }
        return dummy.next;
    }

    // input: head->n1...->nk->nk+1
    // output: head->nk...->n1->nk+1
    private ListNode reverseKNode(ListNode head, int k) {
        // confirm have k nodes
        ListNode curt = head;
        ListNode nodeOne = head.next;
        for (int i = 0; i < k; i++) {
            curt = curt.next;
            if (curt == null) {
                return null;
            }
        }
        ListNode nodeK = curt;
        ListNode nodeKPlusOne = nodeK.next;
        curt = head.next;
        ListNode prev = null;
        while (curt != nodeKPlusOne) {
            ListNode next = curt.next;
            curt.next = prev;
            prev = curt;
            curt = next;
        }
        head.next = nodeK;
        nodeOne.next = nodeKPlusOne;
        return nodeOne;
    }
}
