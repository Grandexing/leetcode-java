package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q39CombinationSum {
//    https://leetcode.com/problems/combination-sum/description/


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return ans;
        }
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>(), ans);
        return ans;
    }


    private void dfs(int[] candidates, int start, int target, List<Integer> cur, List<List<Integer>> ans) {
        if (target <= 0) {
            if (target == 0) {
                ans.add(new ArrayList<>(cur));
            }
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) break;
            cur.add(candidates[i]);
            dfs(candidates, i, target - candidates[i], cur, ans);
            cur.remove(cur.size() - 1);
        }
    }
}
