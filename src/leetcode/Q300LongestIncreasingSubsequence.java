package leetcode;

public class Q300LongestIncreasingSubsequence {
//    https://leetcode.com/problems/longest-increasing-subsequence/description/

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            int maxVal = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    maxVal = Math.max(dp[j], maxVal);
                }
            }
            dp[i] = maxVal + 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
