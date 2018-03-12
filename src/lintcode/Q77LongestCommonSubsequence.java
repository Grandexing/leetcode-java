package lintcode;

public class Q77LongestCommonSubsequence {
//    http://www.lintcode.com/en/problem/longest-common-subsequence/
    public int longestCommonSubsequence(String A, String B) {
        // write your code here
        if (A == null || B == null || A.isEmpty() || B.isEmpty()) {
            return 0;
        }
        int n = A.length();
        int m = B.length();
        int longest = 0;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // A以i为结尾，B以j为结尾的最长公共子序列
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[n][m];
    }
}
