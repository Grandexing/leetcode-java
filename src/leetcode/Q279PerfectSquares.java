package leetcode;

import java.util.Arrays;

public class Q279PerfectSquares {
//    https://leetcode.com/problems/perfect-squares/description/
    public int numSquares(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}