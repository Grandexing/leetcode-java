package lintcode;

import classes.TreeNode;

import java.util.Stack;

public class Q86BinarySearchTreeIterator {
    class BSTIterator {
        /*
         * @param root: The root of binary tree.
         */public BSTIterator(TreeNode root) {
            // do intialization if necessary
            next = root;
        }

        private Stack<TreeNode> stack = new Stack<>();
        private TreeNode next = null;


        private void addToStack(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }
        /*
         * @return: True if there has next node, or false
         */
        public boolean hasNext() {
            // write your code here
            if (next != null) {
                addToStack(next);
                next = null;
            }
            return !stack.isEmpty();
        }

        /*
         * @return: return next node
         */
        public TreeNode next() {
            // write your code here
            if (!hasNext()) {
                return null;
            }
            TreeNode cur = stack.pop();
            next = cur.right;
            return cur;
        }
    }
}
