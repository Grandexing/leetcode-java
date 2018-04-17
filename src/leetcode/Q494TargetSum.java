package leetcode;

import java.util.Arrays;

public class Q494TargetSum {
    int sum = 0;
    int max = 1000;
    public int findTargetSumWays(int[] nums, int S) {
        // max = 0;
        // for (int i : nums) {
        //     max += i;
        // }
        sum = S;
        int[][] memo = new int[nums.length][2 * max + 1];
        for (int[] row : memo) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return dfs(nums, 0, 0, memo);
    }


    int dfs(int[] nums, int index, int curSum, int[][] memo) {
        if (index == nums.length) {
            if (curSum == sum) {
                return 1;
            } else {
                return 0;
            }
        }
        if (memo[index][curSum + max] != Integer.MIN_VALUE) {
            return memo[index][curSum + max];
        }
        int add = dfs(nums, index + 1, curSum + nums[index], memo);
        int substract = dfs(nums, index + 1, curSum - nums[index], memo);
        memo[index][curSum + max] = add + substract;
        return memo[index][curSum + max];
    }


    public int findTargetSumWays1(int[] nums, int S) {
        int n = nums.length;
        int[][] f = new int[n][2001];
        f[0][nums[0] + 1000] = 1;
//         可能和上面是同一个位置（第一个数是0）
        f[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < n; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (f[i - 1][sum + 1000] > 0) {
                    f[i][sum + 1000 + nums[i]] += f[i - 1][sum + 1000];
                    f[i][sum + 1000 - nums[i]] += f[i - 1][sum + 1000];
                }
            }
        }
        return S > 1000 ? 0 : f[n - 1][S + 1000];
    }
}
