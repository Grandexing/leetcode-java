package sword2offer;

import classes.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class Q34 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Stack<Integer> path = new Stack<>();
        int currentSum = 0;
        return findPath(root, target, result, path, currentSum);
    }


    ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target, ArrayList<ArrayList<Integer>> result,
                                           Stack<Integer> path, int currentSum) {
        currentSum += root.val;
        path.push(root.val);
        boolean isLeaf = root.left == null && root.right == null;
        if (isLeaf && currentSum == target) {
            result.add(new ArrayList<>(path));
        }
        if (root.left != null) {
            result = findPath(root.left, target, result, path, currentSum);
        }
        if (root.right != null) {
            result = findPath(root.right, target, result, path, currentSum);
        }
        path.pop();
        return result;
    }
}
