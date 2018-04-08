package leetcode;

import java.util.Arrays;

public class Q322CoinChange {
//    https://leetcode.com/problems/coin-change/description/

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] f = new int[amount + 1];
        Arrays.fill(f, max);
        f[0] = 0;
        for (int i = 0; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    f[i] = Math.min(f[i], f[i - coins[j]] + 1);
                }
            }
        }
        return f[amount] > amount ? -1 : f[amount];
    }
}
