package lintcode;

public class Q769SpiralArray {
    public int[][] spiralArray(int n) {
        // write your code here
        int[][] res = new int[n][n];
        int start = 0;
        int curr = 1;
        while (start * 2 < n) {
            // System.out.println(curr);
            curr = setOneCircle(res, start, curr);
            start++;
        }
        return res;
    }


    private int setOneCircle(int[][] res, int start, int curr) {
        System.out.println(start);
        int endX = res[0].length - start - 1;
        int endY = res.length - start - 1;
        // 从左到右
        for (int i = start; i <= endX; i++) {
            res[start][i] = curr;
            curr++;
        }
        System.out.println(curr);
        // 从上到下
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                res[i][endX] = curr;
                curr++;
            }
        }
        System.out.println(curr);
        // 从右到左
        if (start < endY && start < endX) {
            for (int i = endX - 1; i >= start; i--) {
                res[endY][i] = curr;
                curr++;
            }
        }
        System.out.println(curr);
        // 从下到上
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i > start; i--) {
                res[i][start] = curr;
                curr++;
            }
        }
        return curr;
    }
}
