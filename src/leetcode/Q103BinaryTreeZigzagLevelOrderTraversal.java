package leetcode;
import classes.TreeNode;

import java.util.*;


public class Q103BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack[] stacks = new Stack[2];
        stacks[0] = new Stack<TreeNode>();
        stacks[1] = new Stack<TreeNode>();
        int curr = 0;
        stacks[curr].push(root);
        while (!stacks[curr].isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int next = 1 - curr;
            while (!stacks[curr].isEmpty()) {
                TreeNode node = (TreeNode)stacks[curr].pop();
                level.add(node.val);
                if (curr == 0) {
                    if (node.left != null) {
                        stacks[next].push(node.left);
                    }
                    if (node.right != null) {
                        stacks[next].push(node.right);
                    }
                } else {
                    if (node.right != null) {
                        stacks[next].push(node.right);
                    }
                    if (node.left != null) {
                        stacks[next].push(node.left);
                    }
                }
            }
            ans.add(level);
            curr = next;
        }
        return ans;
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        travel(root, ans, 0);
        return ans;
    }


    private void travel(TreeNode root, List<List<Integer>> ans, int level) {
        if (root == null) {
            return;
        }
        if (level >= ans.size()) {
            ans.add(new LinkedList<>());
        }
        if (level % 2 == 0) {
            ans.get(level).add(root.val);
        } else {
            ans.get(level).add(0, root.val);
        }
        travel(root.left, ans, level + 1);
        travel(root.right, ans, level + 1);
    }
}
