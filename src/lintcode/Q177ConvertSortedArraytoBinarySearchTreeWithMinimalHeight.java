package lintcode;

import classes.TreeNode;

public class Q177ConvertSortedArraytoBinarySearchTreeWithMinimalHeight {
//    http://www.lintcode.com/en/problem/convert-sorted-array-to-binary-search-tree-with-minimal-height/

    public TreeNode sortedArrayToBST(int[] A) {
        // write your code here
        if (A == null) {
            return null;
        }
        TreeNode root = sortedArrayToBST(A, 0, A.length - 1);
        return root;
    }


    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        TreeNode root = null;
        if (start <= end) {
            int mid = start + (end - start) / 2;
            root = new TreeNode(nums[mid]);
            root.left = sortedArrayToBST(nums, start, mid - 1);
            root.right = sortedArrayToBST(nums, mid + 1, end);
        }
        return root;
    }
}
