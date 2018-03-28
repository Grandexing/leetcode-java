package leetcode;

import classes.TreeNode;

public class Q124BinaryTreeMaximumPathSum {
//    不用 resulttype，但要用类变量
    private int max = Integer.MIN_VALUE;
    public int maxPathSum1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        helper(root);
        return max;
    }


    private int helper1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, helper1(root.left));
        int right = Math.max(0, helper1(root.right));
        max = Math.max(max, left + right + root.val);
        return root.val + Math.max(left, right);
    }


    class ResultType {
        int singlePath;
        int maxPath;
        ResultType (int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        ResultType rt = helper(root);
        return rt.maxPath;
    }


    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0);
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val);
        return new ResultType(singlePath, maxPath);
    }
}
