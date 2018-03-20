package lintcode;

import classes.TreeNode;

public class Q94BinaryTreeMaximumPathSum {
//    http://www.lintcode.com/en/problem/binary-tree-maximum-path-sum/

    class ResultType {
        int singlePath;
        int maxPath;
        ResultType(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
    public int maxPathSum(TreeNode root) {
        // write your code here
        ResultType rt = helper(root);
        return rt.maxPath;
    }


    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        int singlePath = root.val + Math.max(left.singlePath, right.singlePath);
        singlePath = Math.max(singlePath, 0);
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);
        return new ResultType(singlePath, maxPath);
    }
}
