package sword2offer;

public class Q13 {
    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(10,1,100));
    }
}
class Solution {
    public int movingCount(int threshold, int rows, int cols)
    {
        if (threshold < 0 || rows <= 0 || cols <= 0) return 0;
        boolean[] visited = new boolean[rows * cols];
        int count = movingCount(threshold, rows, cols, 0, 0, visited);
        return count;
    }


    private int movingCount(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row * cols + col] = true;
            count = 1 + movingCount(threshold, rows, cols, row - 1, col, visited)
                    + movingCount(threshold, rows, cols, row, col - 1, visited)
                    + movingCount(threshold, rows, cols, row, col + 1, visited)
                    + movingCount(threshold, rows, cols, row + 1, col, visited);
        }
        return count;
    }


    private boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
        return row >= 0 && col >= 0 && row < rows && col < cols && !visited[row * cols + col]
                && getDigitSum(row) + getDigitSum(col) <= threshold;
    }


    private int getDigitSum(int digit) {
        int sum = 0;
        while (digit >0) {
            sum += digit % 10;
            digit /= 10;
        }
        return sum;
    }
}