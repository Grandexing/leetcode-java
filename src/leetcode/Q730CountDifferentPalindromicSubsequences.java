package leetcode;

public class Q730CountDifferentPalindromicSubsequences {
//    https://leetcode.com/problems/count-different-palindromic-subsequences/discuss/109507/Java-96ms-DP-Solution-with-Detailed-Explanation


    public int countPalindromicSubsequences(String S) {
        if (S == null || S.isEmpty()) {
            return 0;
        }
        String str = S;
        int mod = 1000000007;
        int n = S.length();
        int[][] dp = new int[n][n];
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (i == j) {
                    dp[i][j] = 1;
                }
                else if (S.charAt(i) != S.charAt(j)) {
                    dp[i][j] = dp[i][j - 1] + dp[i + 1][j] - dp[i + 1][j - 1];
                }
                else {
                    int left = i + 1;
                    int right = j - 1;
                    while (left <= right && S.charAt(left) != S.charAt(i)) {
                        left++;
                    }
                    while (left <= right && S.charAt(right) != S.charAt(i)) {
                        right--;
                    }
                    if (left == right) {
                        dp[i][j] = 2 * dp[i + 1][j - 1] + 1;
                    } else if (left > right) {
                        dp[i][j] = 2 * dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = 2 * dp[i + 1][j - 1] - dp[left + 1][right - 1];
                    }
                }
                if (dp[i][j] < 0) {
                    dp[i][j] += mod;
                } else {
                    dp[i][j] %= mod;
                }
            }
        }
        return dp[0][n - 1];
    }
}
