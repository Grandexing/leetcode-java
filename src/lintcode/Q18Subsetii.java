package lintcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q18Subsetii {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        // 防止重复
        Arrays.sort(nums);
        dfs(nums, new ArrayList<Integer>(), 0, result);
        return result;
    }


    private void dfs(int[] nums, List<Integer> subset, int startIndex,
                     List<List<Integer>> result) {
        result.add(new ArrayList<>(subset));
        for (int i = startIndex; i < nums.length; i++) {
            if (i != startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            // [1] -> [1,2]
            subset.add(nums[i]);
            // 寻找所有以 [1,2] 开头的集合，并扔到 results
            dfs(nums, subset, i + 1, result);
            // [1,2] -> [1]  回溯
            subset.remove(subset.size() - 1);
        }
    }
}
