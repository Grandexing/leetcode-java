package lintcode;

import classes.ListNode;

public class Q35ReverseLinkedList {
//    http://www.lintcode.com/en/problem/reverse-linked-list/#

    public ListNode reverse(ListNode head) {
        // write your code here
        ListNode prev = null;
        ListNode curt = head;
        while (curt != null) {
            ListNode next = curt.next;
            curt.next = prev;
            prev = curt;
            curt = next;
        }
        return prev;
    }
}
