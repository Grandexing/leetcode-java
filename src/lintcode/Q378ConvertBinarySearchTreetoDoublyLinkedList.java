package lintcode;

import classes.DoublyListNode;
import classes.TreeNode;

public class Q378ConvertBinarySearchTreetoDoublyLinkedList {
//    http://www.lintcode.com/en/problem/convert-binary-search-tree-to-doubly-linked-list/

    public DoublyListNode bstToDoublyList(TreeNode root) {
        // write your code here
        if (root == null) {
            return null;
        }
        ResultType rt = bst2dl(root);
        return rt.head;
    }


    private ResultType bst2dl(TreeNode root) {
        if (root == null) {
            return new ResultType(null, null);
        }
        DoublyListNode curt = new DoublyListNode(root.val);
        DoublyListNode head = curt;
        DoublyListNode tail = curt;
        if (root.left != null) {
            ResultType lrt = bst2dl(root.left);
            head = lrt.head;
            lrt.tail.next = curt;
            curt.prev = lrt.tail;
        }
        if (root.right != null) {
            ResultType rrt = bst2dl(root.right);
            curt.next = rrt.head;
            rrt.head.prev = curt;
            tail = rrt.tail;
        }
        return new ResultType(head, tail);
    }

    class ResultType {
        public DoublyListNode head;
        public DoublyListNode tail;
        public ResultType (DoublyListNode head, DoublyListNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }
}

