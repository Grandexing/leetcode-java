package bishi.wangyihuyu;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        try{
            int m = scan.nextInt();
            int n = scan.nextInt();
            int[][] nums = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    nums[i][j] = scan.nextInt();
                }
            }
            int target = scan.nextInt();
            int result = findNumInMatrix(nums, target);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("input error");
        }

    }


    public static int findNumInMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        int colIndex = matrix[0].length - 1;
        int rowIndex = 0;
        while (rowIndex < rows && colIndex >= 0) {
            if (matrix[rowIndex][colIndex] == target) {
                return 1;
            }
            if (matrix[rowIndex][colIndex] < target) {
                rowIndex++;
            } else {
                colIndex--;
            }
        }
        return 0;
    }
}