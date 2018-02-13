package lintcode;

import java.util.*;

public class Q17Subsets {
/*
http://www.lintcode.com/en/problem/subsets/

思路：深度优先搜索（dfs）/回溯法
 */

    /*
     * @param nums: A set of numbers
     * @return: A list of lists
     */
    public List<List<Integer>> subsets(int[] nums) {
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
            // [1] -> [1,2]
            subset.add(nums[i]);
            // 寻找所有以 [1,2] 开头的集合，并扔到 results
            dfs(nums, subset, i + 1, result);
            // [1,2] -> [1]  回溯
            subset.remove(subset.size() - 1);
        }
    }


    public List<List<Integer>> subsets1(int[] nums) {
//        BFS
        // write your code here
        List<List<Integer>> results = new ArrayList<>();
        if (nums == null) {
            return results;
        }
        //防止重复
        Arrays.sort(nums);
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> subset = new ArrayList<>();
        queue.offer(subset);
        while (!queue.isEmpty()) {
            subset = queue.poll();
            results.add(subset);
            for (int i = 0; i < nums.length; i++) {
                if (subset.isEmpty() || subset.get(subset.size() - 1) < nums[i]) {
                    //[] -> [1]
                    //[1] -> [1, 2], [1, 3]
                    List<Integer> newSubset = new ArrayList<>(subset);
                    newSubset.add(nums[i]);
                    queue.offer(newSubset);
                }
            }
        }
        return results;
    }
}
