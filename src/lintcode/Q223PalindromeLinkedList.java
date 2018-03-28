package lintcode;

import classes.ListNode;

import java.util.List;

public class Q223PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return true;
        }
        ListNode middle = findMiddle(head);
        middle.next = reverse(middle.next);
        ListNode p1 = head;
        ListNode p2 = middle.next;
        while (p1 != null && p2 != null && p1.val == p2.val) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2 == null;
    }


    private ListNode findMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
