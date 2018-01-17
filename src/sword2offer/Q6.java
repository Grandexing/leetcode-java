package sword2offer;

import classes.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class Q6 {
//使用stack
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) return list;
        Stack<Integer> stack = new Stack<>();
        ListNode p = listNode;
        while (p != null) {
            stack.push(p.val);
            p = p.next;
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

//    递归
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = null;
        if(listNode != null) {
            list = printListFromTailToHead(listNode.next);
            list.add(listNode.val);
            System.out.println(listNode.val);
        } else {
            list = new ArrayList<>();
        }
        return list;
    }
}
