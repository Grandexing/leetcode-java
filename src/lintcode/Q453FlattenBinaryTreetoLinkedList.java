package lintcode;

import classes.TreeNode;

import java.util.Stack;

public class Q453FlattenBinaryTreetoLinkedList {
//    http://www.lintcode.com/en/problem/flatten-binary-tree-to-linked-list/

    private TreeNode lastNode = null;
    public void flatten(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        if (lastNode != null) {
            lastNode.left = null;
            lastNode.right = root;
        }
        lastNode = root;
        TreeNode right = root.right;
        flatten(root.left);
        flatten(right);
    }


    public void flatten1(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        flat(root);
    }


    private TreeNode flat(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftLast = flat(root.left);
        TreeNode rightLast = flat(root.right);
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

// 非递归
    public void flatten2(TreeNode root) {
        // write your code here
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
            node.left = null;
            if (stack.isEmpty()) {
                node.right = null;
            } else {
                node.right = stack.peek();
            }
        }
        root.left = null;
    }
}
