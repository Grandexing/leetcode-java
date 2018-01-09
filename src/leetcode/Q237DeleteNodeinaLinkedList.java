package leetcode;

import leetcode.classes.ListNode;

/**
 * Created by grande on 2018/1/9.
 */
public class Q237DeleteNodeinaLinkedList {
    public static void main(String[] args) {

    }


    public void deleteNode(ListNode node) {
        if(node == null || node.next == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
