package leetcode;

import classes.TreeNode;

public class Q105ConstructBinaryTreefromPreorderandInorderTraversal {
//    https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }


    private TreeNode buildTree(int[] preorder, int pStart, int pEnd, int[] inorder, int iStart, int iEnd) {
        if (iStart > iEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[pStart]);
        int index = findNode(inorder, iStart, iEnd, preorder[pStart]);
        root.left = buildTree(preorder, pStart + 1, pStart + index - iStart, inorder, iStart, index - 1);
        root.right = buildTree(preorder, pStart + index - iStart + 1, pEnd, inorder, index + 1, iEnd);
        return root;
    }


    private int findNode(int[] arr, int start, int end, int val) {
        for (int i = start; i <= end; i++) {
            if (arr[i] == val) {
                return i;
            }
        }
        return -1;
    }
}
