package sword2offer;

import java.util.ArrayList;

public class Q29 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0;
        while (rows > 2 * start && cols > 2 * start) {
            printMatrix(matrix, rows, cols, start, result);
            start++;
        }
        return result;
    }


    void printMatrix(int [][] matrix, int rows, int cols, int start, ArrayList<Integer> result) {
        int endX = cols - start - 1;
        int endY = rows - start - 1;
        //第一步，从左到右打印一行
        for (int i = start; i <= endX; i++) {
            result.add(matrix[start][i]);
        }
        //第二步，从上到下打印一列
        if (endY > start) {
            for (int i = start + 1; i <= endY; i++) {
                result.add(matrix[i][endX]);
            }
        }
        //第三步，从右到左打印一行
        if (endY > start && endX > start) {
            for (int i = endX - 1; i >= start; i--) {
                result.add(matrix[endY][i]);
            }
        }
        //第四步，从下到上打印一列
        if (endX > start && endY - start >= 2) {
            for (int i = endY - 1; i > start; i--) {
                result.add(matrix[i][start]);
            }
        }
    }
}
