package leetcode;

import leetcode.classes.ListNode;

public class Q92ReverseLinkedListII {
    public static void main(String[] args) {

    }


    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m == n) return head;
        ListNode dummy, start, p, q;
        dummy = new ListNode(0);
        p = dummy;
        dummy.next = head;
        for (int i = 0; i < m - 1; i++) {
            p = p.next;
        }
        start = p;
        System.out.println(p.val);
        p = p.next;
        for (int i = 0; i < n - m; i++) {
            q = p.next;
            p.next = q.next;
            q.next = start.next;
            start.next = q;
        }
        return dummy.next;
    }
}
