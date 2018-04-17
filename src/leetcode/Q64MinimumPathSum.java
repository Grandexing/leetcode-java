package leetcode;

import java.util.Arrays;

public class Q64MinimumPathSum {
    static int[][] input = {{0,7,7,8,1,2,4,3,0,0,5,9,8,3,6,5,1,0},{2,1,1,0,8,1,3,3,9,9,5,8,7,5,7,5,5,8},{9,2,3,1,2,8,1,2,3,7,9,7,9,3,0,0,3,8},{3,9,3,4,8,1,2,6,8,9,3,4,9,4,8,3,6,2},{3,7,4,7,6,5,6,5,8,6,7,3,6,2,2,9,9,3},{2,3,1,1,5,4,7,4,0,7,7,6,9,1,5,5,0,3},{0,8,8,8,4,7,1,0,2,6,1,1,1,6,4,2,7,9},{8,6,6,8,3,3,5,4,6,2,9,8,6,9,6,6,9,2},{6,2,2,8,0,6,1,1,4,5,3,1,7,3,9,3,2,2},{8,9,8,5,3,7,5,9,8,2,8,7,4,4,1,9,2,2},{7,3,3,1,0,9,4,7,2,3,2,6,7,1,7,7,8,1},{4,3,2,2,7,0,1,4,4,4,3,8,6,2,1,2,5,4},{1,9,3,5,4,6,4,3,7,1,0,7,2,4,0,7,8,0},{7,1,4,2,5,9,0,4,1,4,6,6,8,9,7,1,4,3},{9,8,6,8,2,6,5,6,2,8,3,2,8,1,5,4,5,2},{3,7,8,6,3,4,2,3,5,1,7,2,4,6,0,2,5,4},{8,2,1,2,2,6,6,0,7,3,6,4,5,9,4,4,5,7}};

    public static void main(String[] args) {
        Q64MinimumPathSum q = new Q64MinimumPathSum();
        System.out.println(q.minPathSum(input));
        System.out.println(q.minPathSum1(input));
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            f[0][i] = f[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = Math.min(f[i - 1][j], f[i][j - 1]) + grid[i][j];
            }
        }
        return f[m - 1][n - 1];
    }


    public int minPathSum1(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] memo = new int[n][m];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        memo[0][0] = grid[0][0];
        return dfs(grid, n - 1, m - 1, memo);
    }


    int dfs(int[][] grid, int x, int y, int[][] memo) {
//        for (int[] row : grid) {
//            System.out.println(Arrays.toString(row));
//        }
        if (x < 0 || y < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[x][y] != -1) {
            return memo[x][y];
        }
        int ans = Math.min(dfs(grid, x - 1, y, memo), dfs(grid, x, y - 1, memo)) + grid[x][y];
        memo[x][y] = ans;
        return ans;
    }
}
