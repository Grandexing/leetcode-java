package lintcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by grande on 2018/3/18.
 */
public class Q15Permutations {
//    http://www.lintcode.com/en/problem/permutations/

    public List<List<Integer>> permute(int[] nums) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 0) {
            result.add(new ArrayList<>());
            return result;
        }
        // Arrays.sort(nums);
        List<Integer> permutation = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, permutation, result, visited);
        return result;
    }


    private void dfs(int[] nums, List<Integer> permutation, List<List<Integer>> result, boolean[] visited) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation.add(nums[i]);
                dfs(nums, permutation, result, visited);
                permutation.remove(permutation.size() - 1);
                visited[i] = false;
            }
        }
    }
}
