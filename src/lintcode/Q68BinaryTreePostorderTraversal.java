package lintcode;

import classes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q68BinaryTreePostorderTraversal {
//    http://www.lintcode.com/en/problem/binary-tree-postorder-traversal/

//    非递归
    public List<Integer> postorderTraversal2(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        TreeNode curt = root;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            curt = stack.peek();
            if (prev == null || prev.left == curt || prev.right == curt) {
                if (curt.left != null) {
                    stack.push(curt.left);
                } else if (curt.right != null) {
                    stack.push(curt.right);
                }
            } else if (curt.left == prev) {
                if (curt.right != null) {
                    stack.push(curt.right);
                }
            } else {
                result.add(curt.val);
                stack.pop();
            }
            prev = curt;
        }
        return result;
    }

//递归2
    public List<Integer> postorderTraversal1(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(postorderTraversal(root.left));
        result.addAll(postorderTraversal(root.right));
        result.add(root.val);
        return result;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        postorderTraversal(root, result);
        return result;
    }


    private void postorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left, result);
        postorderTraversal(root.right, result);
        result.add(root.val);
    }
}
