package lintcode;

public class Q79LongestCommonSubstring {
//    http://www.lintcode.com/en/problem/longest-common-substring/

    public int longestCommonSubstring(String A, String B) {
        // write your code here
        // state: f[i][j] is the length of the longest lcs
        // ended with A[i - 1] & B[j - 1] in A[0..i-1] & B[0..j-1]
        if (A == null || B == null || A.isEmpty() || B.isEmpty()) {
            return 0;
        }
        int n = A.length();
        int m = B.length();
        System.out.println(n);
        System.out.println(m);
        // initialize: f[i][j] is 0 by default

        // function: f[i][j] = f[i - 1][j - 1] + 1 or 0
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // A以i为结尾，B以j为结尾的最长公共子串
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        // answer: max{f[i][j]}
        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                max = Math.max(dp[i][j], max);
            }
        }
        return max;
    }
}
