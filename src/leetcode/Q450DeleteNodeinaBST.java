package leetcode;

import classes.TreeNode;

public class Q450DeleteNodeinaBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        TreeNode parent = findNode(dummy, root, key);
        TreeNode node;
        if (parent.left != null && parent.left.val == key) {
            node = parent.left;
        } else if (parent.right != null && parent.right.val == key) {
            node = parent.right;
        } else {
//            not find
            return dummy.left;
        }
        deleteNode(parent, node);
        return dummy.left;
    }


    private TreeNode findNode(TreeNode parent, TreeNode node, int key) {
        if (node == null) {
            return parent;
        }
        if (node.val == key) {
            return parent;
        }
        if (key < node.val) {
            return findNode(node, node.left, key);
        } else {
            return findNode(node, node.right, key);
        }
    }


    private void deleteNode(TreeNode parent, TreeNode node) {
        if (node.right == null) {
//            one subtree and it is the left subtree
            if (parent.left == node) {
                parent.left = node.left;
            } else {
                parent.right = node.left;
            }
        } else {
//            find min node in right subtree
            TreeNode successor = node.right;
            TreeNode father = node;
            while (successor.left != null) {
                father = successor;
                successor = successor.left;
            }
//            remove successor from tree, fit either successor.right is null or successor has a right subtree
            if (father.left == successor) {
                father.left = successor.right;
            } else {
                father.right = successor.right;
            }
//            replace node with successor
            if (parent.left == node) {
                parent.left = successor;
            } else {
                parent.right = successor;
            }
            successor.left = node.left;
            successor.right = node.right;
        }
    }
}
