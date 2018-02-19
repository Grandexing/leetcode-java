package lintcode;

import classes.TreeNode;

public class Q88LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null || root == A || root == B) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        if (right != null) {
            return right;
        }
        return null;
    }


    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        if (root == null || root == A || root == B) {
            return root;
        }
        ResultType rt = lca(root, A, B);
        if (rt.visitedA && rt.visitedB) {
            return rt.lca;
        }
        return null;
    }


    public ResultType lca(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new ResultType(false, false, null);
        }
        ResultType left = lca(root.left, A, B);
        ResultType right = lca(root.right, A, B);
        boolean visitedA = left.visitedA || right.visitedA || root == A;
        boolean visitedB = left.visitedB || right.visitedB || root == B;
        if (root == A || root == B) {
            return new ResultType(visitedA, visitedB, root);
        }
        if (left.lca != null && right.lca != null) {
            return new ResultType(visitedA, visitedB, root);
        }
        TreeNode lca = null;
        if (left.lca != null) {
            lca = left.lca;
        }
        if (right.lca != null) {
            lca = right.lca;
        }
        return new ResultType(visitedA, visitedB, lca);
    }
}

class ResultType {
    boolean visitedA;
    boolean visitedB;
    TreeNode lca;


    public ResultType(boolean visitedA, boolean visitedB, TreeNode lca) {
        this.visitedA = visitedA;
        this.visitedB = visitedB;
        this.lca = lca;
    }
}