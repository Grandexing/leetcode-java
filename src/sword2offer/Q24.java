package sword2offer;

import classes.ListNode;

public class Q24 {
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode prev, curr, next;
        prev = null;
        curr = head;
        while(curr != null) {
            next = curr.next;
            if (next == null) {
                head = curr;
            }
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }
}
