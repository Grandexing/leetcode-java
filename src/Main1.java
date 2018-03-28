/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import sun.nio.cs.ext.MacHebrew;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author lyk
 * @date 2018-3-27
 */
public class Main1 {

    static int[] x1;
    static int[] y1;
    static int[] x2;
    static int[] y2;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        x1 = new int[n];
        y1 = new int[n];
        x2 = new int[n];
        y2 = new int[n];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            min = Math.min(min, x1[i]);
        }
        for (int i = 0; i < n; i++) {
            y1[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            x2[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y2[i] = sc.nextInt();
            max = Math.max(max, y2[i]);
        }
        System.out.println(min);
        System.out.println(max);
        long[][] grid = new long[max - min + 1][max - min + 1];
        for (int i = min; i <= max; i++) {
            for (int j = min; j <= max; j++) {
                for (int k = 0; k < n; k++) {
                    if (isIn(i, j, x1[k], y1[k], x2[k], y2[k])) {
                        grid[i - min][j - min]++;
                    }
                }
            }
        }
        long ans = Integer.MIN_VALUE;
        for (int i = min; i <= max; i++) {
            for (int j = min; j <= max; j++) {
                ans = Math.max(ans, grid[i - min][j - min]);
            }
        }
        System.out.println(ans);
//        int[] result = new int[n];
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
////                if (i == j) {
////                    continue;
////                }
//                if (i != j) {
//                    boolean flag = isLap(x1[i], y1[i], x2[i], y2[i], x1[j], y1[j], x2[j], y2[j]);
//                    if (!flag) {
//                        result[i]++;
//                    }
//                }
//            }
//        }
//        Arrays.sort(result);
//        System.out.println(result[n-1]+1);
    }


    private static boolean isIn(int x, int y, int x1, int y1, int x2, int y2) {
        return x >= x1 && x <= x2 && y <= y2 && y >= y1;
    }

    public static boolean isLap(int x1, int y1, int x2, int y2, int x_1, int y_1, int x_2, int y_2) {
        if (y2 > y_1 && y1 < y_2 && x2 > x_1 && x1 < x_2) {
            return false;
        }

        return true;
    }

}