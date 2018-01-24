package sword2offer;

import classes.ListNode;

public class Q23 {
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
