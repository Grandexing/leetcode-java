package lintcode;

public class Q38Searcha2DMatrixII {
/*
http://www.lintcode.com/en/problem/search-a-2d-matrix/
 */

    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int r = 0;
        int c = cols - 1;
        int count = 0;
        while (r < rows && c >= 0) {
            if (matrix[r][c] == target) {
                count++;
                r++;
                c--;
            } else if (matrix[r][c] < target) {
                r++;
            } else {
                c--;
            }
        }
        return count;
    }
}
