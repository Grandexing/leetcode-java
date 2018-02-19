package lintcode;

import classes.TreeNode;

public class Q97MaximumDepthofBinaryTree {
//    http://www.lintcode.com/en/problem/maximum-depth-of-binary-tree/

    public int maxDepth(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
