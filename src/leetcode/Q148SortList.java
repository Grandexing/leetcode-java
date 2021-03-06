package leetcode;

import classes.ListNode;

public class Q148SortList {
    public ListNode sortList(ListNode head) {
        return mergeSort(head);
    }


    ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
//         find middle
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
//         break from middle
        prev.next = null;
        ListNode l1 = mergeSort(head);
        ListNode l2 = mergeSort(slow);
        return merge(l1, l2);
    }


    ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        while (l1 != null) {
            cur.next = l1;
            l1 = l1.next;
            cur = cur.next;
        }
        while (l2 != null) {
            cur.next = l2;
            l2 = l2.next;
            cur = cur.next;
        }
        return dummy.next;
    }
}
