package lintcode;

import java.util.LinkedList;
import java.util.Queue;

public class Q433NumberofIslands {
    private int[] directX = {0, 0, 1, -1};
    private int[] directY = {1, -1, 0, 0};


    public int numIslands(boolean[][] grid) {
        // write your code here
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        // iterate all elements
        int rows = grid.length;
        int cols = grid[0].length;
        int islandCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j]) {
                    System.out.println(i+","+j);
                    markAsIsland(grid, i, j);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }


    private void markAsIsland(boolean[][] grid, int x, int y) {
        // find island by bfs
        Queue<Cordinate> queue = new LinkedList<>();
        queue.offer(new Cordinate(x, y));
        grid[x][y] = false;
        while (!queue.isEmpty()) {
            Cordinate cur = queue.poll();
            for (int i = 0; i < directX.length; i++) {
                int newX = cur.x + directX[i];
                int newY = cur.y + directY[i];
                if (isInGrid(grid, newX, newY)) {
                    if (grid[newX][newY]) {
                        queue.offer(new Cordinate(newX, newY));
                        grid[newX][newY] = false;
                    }
                }
            }
        }
    }


    private boolean isInGrid(boolean[][] grid, int x, int y) {
        int rows = grid.length;
        int cols = grid[0].length;
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}

class Cordinate {
    int x;
    int y;
    public Cordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }
}