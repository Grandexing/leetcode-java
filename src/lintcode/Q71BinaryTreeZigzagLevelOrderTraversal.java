package lintcode;

import classes.TreeNode;

import java.util.*;

public class Q71BinaryTreeZigzagLevelOrderTraversal {
//    http://www.lintcode.com/en/problem/binary-tree-zigzag-level-order-traversal/

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Stack[] stacks = new Stack[2];
        stacks[0] = new Stack<TreeNode>();
        stacks[1] = new Stack<TreeNode>();
        int curr = 0;
        stacks[curr].push(root);
        boolean normalOrder = true;
        while (!stacks[curr].isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int other = 1 - curr;
            while (!stacks[curr].isEmpty()) {
                TreeNode node = (TreeNode) stacks[curr].pop();
                level.add(node.val);
                if (normalOrder) {
                    if (node.left != null) {
                        stacks[other].push(node.left);
                    }
                    if (node.right != null) {
                        stacks[other].push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        stacks[other].push(node.right);
                    }
                    if (node.left != null) {
                        stacks[other].push(node.left);
                    }
                }
            }
            result.add(level);
            curr = other;
            normalOrder = !normalOrder;
        }
        return result;
    }
}
