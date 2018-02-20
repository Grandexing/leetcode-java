package lintcode;

import classes.TreeNode;

public class Q85InsertNodeinaBinarySearchTree {
//    http://www.lintcode.com/en/problem/insert-node-in-a-binary-search-tree/


    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if (node == null) {
            return root;
        }
        if (root == null) {
            return node;
        }
        TreeNode curt = root;
        insert(curt, node);
        return root;
    }


    private void insert(TreeNode root, TreeNode node) {
        if (root == null || node == null) {
            return;
        }
        if (root.val > node.val) {
            if (root.left == null) {
                root.left = node;
                return;
            } else {
                insert(root.left, node);
            }
        }
        if (root.val < node.val) {
            if (root.right == null) {
                root.right = node;
                return;
            } else {
                insert(root.right, node);
            }
        }
    }
}
