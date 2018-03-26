package leetcode;

import classes.TreeNode;

public class Q104MaximumDepthofBinaryTree {
//    https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}

