package lintcode;

import java.util.*;

public class Q135CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        List<Integer> combination = new ArrayList<>();
        dfs(candidates, 0, target, combination, result);
        return result;
    }


    private void dfs(int[] candidates, int startIndex, int remainTarget,
                     List<Integer> combination, List<List<Integer>> result) {
        if (remainTarget == 0) {
            result.add(new ArrayList<Integer>(combination));
            return;
        }
        for (int i = startIndex; i < candidates.length; i++) {
            if (i != 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }
            int remain = remainTarget - candidates[i];
            if (remain < 0) {
                break;
            }
            combination.add(candidates[i]);
            dfs(candidates, i, remain, combination, result);
            combination.remove(combination.size() - 1);
        }
    }
}
