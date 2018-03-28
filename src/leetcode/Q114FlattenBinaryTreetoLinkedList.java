package leetcode;

import classes.TreeNode;

import java.util.Stack;

public class Q114FlattenBinaryTreetoLinkedList {
//    https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
//非递归
    public void flatten2 (TreeNode root) {
        // helper(root);
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curt = stack.pop();
            if (curt.right != null) {
                stack.push(curt.right);
            }
            if (curt.left != null) {
                stack.push(curt.left);
            }
            // curt.right = curt.left;
            curt.left = null;
            if (!stack.isEmpty()) {
                curt.right = stack.peek();
            } else {
                curt.right = null;
            }
        }
    }


    //分治法
    public void flatten1(TreeNode root) {
        helper(root);
    }


    private TreeNode helper1(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftLast = helper1(root.left);
        TreeNode rightLast = helper1(root.right);
        if (leftLast != null) {
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (rightLast != null) {
            return rightLast;
        }
        if (leftLast != null) {
            return leftLast;
        }
        return root;
    }


    class ResultType {
        TreeNode head;
        TreeNode tail;
        ResultType(TreeNode head, TreeNode tail) {
            this.head = head;
            this.tail = tail;
        }
    }
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root);
        // return rt.head;
    }


    private ResultType helper(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return new ResultType(root, root);
        }
        TreeNode head = root;
        TreeNode tail = root;
        ResultType lr = helper(root.left);
        ResultType rr = helper(root.right);
        root.left = null;
        if (lr != null && rr != null) {
            head.right = lr.head;
            lr.tail.right = rr.head;
            tail = rr.tail;
        } else if (lr != null) {
            head.right = lr.head;
            tail = lr.tail;
        } else {
            head.right = rr.head;
            tail = rr.tail;
        }
        return new ResultType(head, tail);
    }
}
