package leetcode;




import classes.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Q337HouseRobberIII {
//    ans[0] 代表不偷根节点的最大情况，ans[1] 代表偷根节点的最大情况
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }


    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] ans = new int[2];
        ans[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        ans[1] = left[0] + right[0] + root.val;
        return ans;
    }
}
