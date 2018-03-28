package leetcode;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q200NumberofIslands {
//    https://leetcode.com/problems/number-of-islands/description/

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int m = grid[0].length;
//        boolean[][] visited = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    mark(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }


    private void mark(char[][] grid, int x, int y) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != '1') {
            return;
        }
        grid[x][y] = '0';
        mark(grid, x + 1, y);
        mark(grid, x - 1, y);
        mark(grid, x, y + 1);
        mark(grid, x, y + 1);
    }

    int[] directX = {1, 0, -1, 0};
    int[] directY = {0, 1, 0, -1};
    private void markByBFS(char[][] grid, int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(x, y));
        while (!queue.isEmpty()) {
            Pair point = queue.poll();
            for (int i = 0; i < directX.length; i++) {
                int newX = point.x + directX[i];
                int newY = point.y + directY[i];
                if (inBound(grid, newX, newY) && grid[newX][newY] == '1') {
                    grid[newX][newY] = '0';
                    queue.offer(new Pair(newX, newY));
                }
            }
        }
    }


    private boolean inBound(char[][] grid, int x, int y) {
        return x >= 0 && x < grid.length && y >= 0 && y < grid[0].length;
    }


    class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
