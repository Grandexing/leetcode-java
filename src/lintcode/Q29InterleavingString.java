package lintcode;

public class Q29InterleavingString {
//    http://www.lintcode.com/en/problem/interleaving-string/

    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        if (s1 == null || s2 == null || s3 == null) {
            return false;
        }
        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }
        int n = s1.length();
        int m = s2.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][0] && s3.charAt(i - 1) == s1.charAt(i - 1);
        }
        for (int i = 1; i <= m; i++) {
            dp[0][i] = dp[0][i - 1] && s3.charAt(i - 1) == s2.charAt(i - 1);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                        || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return dp[n][m];
    }
}
