package sword2offer;

/**
 * Created by grande on 2018/1/18.
 */
public class Q12 {
    public static void main(String[] args) {
        System.out.println(hasPath("ABCESFCSADEE".toCharArray(),3,4,"ABCCED".toCharArray()));
    }


    public static boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if (matrix == null || str == null || rows < 1 || cols < 1) return false;
        int pathLength = 0;
        boolean[] visited = new boolean[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPath(matrix, rows, cols, str, i, j, pathLength, visited)) {
                    return true;
                }
            }
        }
        return false;
    }


    static boolean hasPath(char[] matrix, int rows, int cols, char[] str, int row, int col, int pathLength, boolean[] visited) {
        if (pathLength == str.length) return true;
        boolean hasPath = false;
        int index = row * cols + col;
        System.out.println("row: "+row);
        System.out.println("col: "+col);
        System.out.println("pathLength: "+pathLength);
        System.out.println("str: "+str[pathLength]);
        if (row >= 0 && row < rows && col >= 0 && col < cols && !visited[index] && matrix[index] == str[pathLength]) {
            System.out.println("matrix: "+matrix[index]);
            ++pathLength;
            visited[index] = true;
            hasPath = hasPath(matrix, rows, cols, str, row + 1, col, pathLength, visited)
                    || hasPath(matrix, rows, cols, str, row - 1, col, pathLength, visited)
                    || hasPath(matrix, rows, cols, str, row, col + 1, pathLength, visited)
                    || hasPath(matrix, rows, cols, str, row, col - 1, pathLength, visited);
            if (!hasPath) {
                --pathLength;
                visited[index] = false;
            }
        }
        return hasPath;
    }
}
