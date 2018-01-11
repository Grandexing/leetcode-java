package leetcode;

import leetcode.classes.ListNode;

/**
 * Created by grande on 2018/1/9.
 */
public class Q206ReverseLinkedList {
    public static void main(String[] args) {

    }


//    递归
    public static ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode nextNode = head.next;
        ListNode newHeadNode = reverseList(nextNode);
        nextNode.next = head;
        head.next = null;
        return newHeadNode;
    }



//非递归2
    public static ListNode reverseList1(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode p, q;
        p = head.next;
        while(p.next != null) {
            q = p.next;
            p.next = q.next;
            q.next = head.next;
            head.next = q;
        }
        p.next = head;
        head = p.next.next;
        p.next.next = null;
        return head;
    }


//非递归
    public static ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode prov, cur, next;
        cur = head.next;
        head.next = null;
        prov = head;
        while(cur != null) {
            next = cur.next;
            cur.next = prov;
            prov = cur;
            cur = next;
        }
        head = prov;
        return head;
    }
}
