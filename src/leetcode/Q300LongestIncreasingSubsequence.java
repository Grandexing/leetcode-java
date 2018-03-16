package leetcode;

public class Q300LongestIncreasingSubsequence {
//    https://leetcode.com/problems/longest-increasing-subsequence/description/

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
//         f[i]: 以 nums[i] 为结尾的最长增长子序列长度
        int[] f = new int[n];
        f[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && f[i] < f[j] + 1) {
                    f[i] = f[j] + 1;
                }
            }
            max = Math.max(f[i], max);
        }
        return max;
    }
}
