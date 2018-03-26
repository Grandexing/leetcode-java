package leetcode;

import classes.TreeNode;

import java.util.Stack;

public class Q98ValidateBinarySearchTree {
//    https://leetcode.com/problems/validate-binary-search-tree/description/

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }


    private boolean helper(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }

    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curt = root;
        TreeNode prev = null;
        while (curt != null || !stack.isEmpty()) {
            while (curt != null) {
                stack.push(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            if (prev != null && prev.val >= curt.val) {
                return false;
            }
            prev = curt;
            curt = curt.right;
        }
        return true;
    }
}
