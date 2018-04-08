package leetcode;

public class Q518CoinChange2 {
//  https://leetcode.com/problems/coin-change-2/description/

    public int change(int amount, int[] coins) {
        int[] f = new int[amount + 1];
        f[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                if (j >= coins[i]) {
                    f[j] += f[j - coins[i]];
                }
            }
        }
        return f[amount];
    }
}
