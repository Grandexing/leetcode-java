package leetcode;

import leetcode.classes.ListNode;

public class Q92ReverseLinkedListII {
    public static void main(String[] args) {

    }


    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if((n - m) == 0) return head;
        ListNode p, q, r;
        int k = n - m;
        p = head;
        m--;
        while (m > 0) {
            p = p.next;
            m--;
        }

        while (k > 0) {
            q = p.next;
            p.next = q.next;
            q.next = p;
        }
    }
}
