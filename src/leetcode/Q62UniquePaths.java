package leetcode;

public class Q62UniquePaths {
    public int uniquePaths(int m, int n) {
//         combine(m - 1, m-1 + n - 1)

        return combine (m - 1, m + n - 2);
    }


    int combine(int m, int n) {
        long result = 1;
        int count = Math.min(m, n - m);
        int i = 1;
        while (i <= count) {
            result *= n--;
            result /= i++;
        }
        return (int) result;
    }


    public int uniquePaths1(int m, int n) {
        int[][] f = new int[m][n];
        f[0][0] = 1;
        for (int i = 1; i < m; i++) {
            f[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            f[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }
}
