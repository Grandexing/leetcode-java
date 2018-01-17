package leetcode;

import classes.ListNode;

public class Q142LinkedListCycleII {
    public static ListNode detectCycle(ListNode head) {
        if (head == null) return head;
        ListNode slow, fast;
        slow = head;
        fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        return null;
    }
}
