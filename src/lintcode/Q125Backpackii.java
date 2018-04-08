package lintcode;

public class Q125Backpackii {
//    http://www.lintcode.com/zh-cn/problem/backpack-ii/#

    public int backPackII(int m, int[] A, int[] V) {
        // write your code here
        int n = A.length;
        int[][] f = new int[n + 1][m + 1];
        f[0][0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0 || j == 0) {
                    f[i][j] = 0;
                } else if (j < A[i - 1]) {
                    f[i][j] = f[i - 1][j];
                } else {
                    f[i][j] = Math.max(f[i - 1][j], f[i - 1][j - A[i - 1]] + V[i - 1]);
                }
            }
        }
        return f[n][m];
    }

    // o(m) space
    public int backPackII1(int m, int[] A, int[] V) {
        // write your code here
        int n = A.length;
        int[] f = new int[m + 1];
        for (int i = 0; i < n; i++) {
            for (int j = m; j >= A[i]; j--) {
                f[j] = Math.max(f[j], f[j - A[i]] + V[i]);
            }
        }
        return f[m];
    }
}
