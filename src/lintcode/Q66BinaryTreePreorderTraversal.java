package lintcode;

import classes.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q66BinaryTreePreorderTraversal {
//    http://www.lintcode.com/en/problem/binary-tree-preorder-traversal/
//非递归
    public List<Integer> preorderTraversal2(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            result.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return result;
    }


//    递归
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        preorderTraversal(root, result);
        return result;
    }


    private void preorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        preorderTraversal(root.left, result);
        preorderTraversal(root.right, result);
    }

//递归2 divide and conquer
    public List<Integer> preorderTraversal1(TreeNode root) {
        // write your code here
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // divide
        List<Integer> leftBranch = preorderTraversal(root.left);
        List<Integer> rightBranch = preorderTraversal(root.right);
        // conquer
        result.add(root.val);
        result.addAll(leftBranch);
        result.addAll(rightBranch);
        return result;
    }
}
