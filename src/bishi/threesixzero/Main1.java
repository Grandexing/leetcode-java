package bishi.threesixzero;

import java.util.*;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dataSize = scanner.nextInt();
        List<int[][]> dataList = new ArrayList<>();
        for (int k = 0; k < dataSize; k++) {
            int n = scanner.nextInt();
            int[][] data  = new int[4][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 4; j++) {
                    data[j][i] = scanner.nextInt();
                }
            }
            dataList.add(data);
        }
        for (int[][] data : dataList) {
            System.out.println(find(data));
        }
    }


    private static int find(int[][] data) {
//        x1 y1 x2 y2
        int count = 0;
        int[] x1 = data[0];
        int[] y1 = data[1];
        int[] x2 = data[2];
        int[] y2 = data[3];
        for (int i = 0; i < x1.length; i++) {
            count += (Math.abs(x1[i] - x2[i]) + 1) * (Math.abs(y1[i] - y2[i]) + 1);
        }
        return count;
    }
}
