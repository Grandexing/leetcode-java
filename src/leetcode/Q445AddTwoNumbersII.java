package leetcode;

import classes.ListNode;

import java.util.Stack;

public class Q445AddTwoNumbersII {
//    https://leetcode.com/problems/add-two-numbers-ii/description/

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }
        ListNode head = new ListNode(0);
        int sum = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty()) {
                sum += stack1.pop().val;
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop().val;
            }
            head.val = sum % 10;
            ListNode node = new ListNode(sum / 10);
            node.next = head;
            head = node;
            sum /= 10;
        }
//         考虑进位
        return head.val == 0 ? head.next : head;
    }
}
