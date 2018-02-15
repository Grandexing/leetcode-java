package lintcode;

public class Q28Searcha2DMatrix {
//    http://www.lintcode.com/en/problem/search-a-2d-matrix/


    public boolean searchMatrix2(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
//         search row
        int start = 0;
        int end = rows - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int number = matrix[mid][0];
            if (number == target) {
                return true;
            }
            if (number > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (matrix[end][0] <= target) {
            rows = end;
        } else if (matrix[start][0] <= target) {
            rows = start;
        } else {
            return false;
        }
        start = 0;
        end = cols - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            int number = matrix[rows][mid];
            if (number == target) {
                return true;
            }
            if (number > target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (matrix[rows][start] == target || matrix[rows][end] == target) {
            return true;
        }
        return false;
    }


    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        int end = rows * cols - 1;
        boolean find = false;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int number = matrix[mid / cols][mid % cols];
            if (number == target) {
                return true;
            }
            if (number < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }


    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int r = 0;
        int c = cols - 1;
        boolean find = false;
        while (r < rows && c >= 0) {
            if (matrix[r][c] == target) {
                find = true;
                break;
            }
            if (matrix[r][c] < target) {
                r++;
            } else {
                c--;
            }
        }
        return find;
    }
}
