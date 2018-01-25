package sword2offer;

import classes.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class Q32Part3 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (pRoot == null) return result;
        Stack<TreeNode>[] stacks = new Stack[2];
        int current = 0;
        int next = 1;
        stacks[current] = new Stack<TreeNode>();
        stacks[next] = new Stack<TreeNode>();
        stacks[current].push(pRoot);
        ArrayList<Integer> row = new ArrayList<>();
        while (!stacks[0].isEmpty() || !stacks[1].isEmpty()) {
            TreeNode node = stacks[current].pop();
            row.add(node.val);
            if (current == 0) {
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
            if (stacks[current].isEmpty()) {
                current = 1 - current;
                next = 1 - next;
                result.add(row);
                row = new ArrayList<>();
            }
        }
        return result;
    }
}
