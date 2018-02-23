package lintcode;

import classes.TreeNode;

import java.util.*;

public class Q70BinaryTreeLevelOrderTraversalII {
//    http://www.lintcode.com/en/problem/binary-tree-level-order-traversal-ii/

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(level);
        }
        Collections.reverse(result);
        return result;
    }
}
