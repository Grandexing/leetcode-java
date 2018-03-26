package leetcode;

import classes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q101SymmetricTree {
//    https://leetcode.com/problems/symmetric-tree/description/

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);
    }


    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == right;
        }
        return left.val == right.val && helper(left.left, right.right) && helper(left.right, right.left);
    }


    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
    }
}
