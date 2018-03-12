package leetcode;

public class Q673NumberofLongestIncreasingSubsequence {
//    https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
//         最长递增子序列数
        int[] ans = new int[n];
//         最长子序列长度
        int[] f = new int[n];
        f[0] = 1;
        ans[0] = 1;
        int maxLength = 1;
        for (int i = 1; i < n; i++) {
            f[i] = 1;
            ans[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    if (f[i] < f[j] + 1) {
                        f[i] = f[j] + 1;
                        ans[i] = ans[j];
                    } else if (f[i] == f[j] + 1) {
                        ans[i] += ans[j];
                    }
                }
            }
            maxLength = Math.max(f[i], maxLength);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (f[i] == maxLength) {
                res += ans[i];
            }
        }
        for (int i : ans) {
            System.out.println(i);
        }
        for (int i : f) {
            System.out.println(i);
        }
        return res;
    }
}
