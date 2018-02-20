package lintcode;

import classes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q11SearchRangeinBinarySearchTree {
//    http://www.lintcode.com/en/problem/search-range-in-binary-search-tree/

    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if (root == null || k1 > k2) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curt = root;
        while (curt != null || !stack.isEmpty()) {
            while (curt != null) {
                stack.push(curt);
                curt = curt.left;
            }
            curt = stack.pop();
            if (k1 <= curt.val && curt.val <= k2) {
                result.add(curt.val);
            } else if (curt.val > k2) {
                break;
            }
            curt = curt.right;
        }
        return result;
    }
}
