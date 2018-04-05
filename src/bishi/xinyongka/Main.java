package bishi.xinyongka;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] f1 = scanner.nextLine().split(" ");
        int n = Integer.parseInt(f1[0]);
        int m = Integer.parseInt(f1[1]);
        int[][] links = new int[m][2];
        for (int i = 0; i < m; i++) {
            String[] f = scanner.nextLine().split(",");
            links[i][0] = Integer.parseInt(f[0]) - 1;
            links[i][1] = Integer.parseInt(f[1]) - 1;
        }
        Main.n = n;
        boolean[] isSafe = new boolean[n];
        Arrays.fill(isSafe, true);
        int[] visited = new int[n];
        for (int i = 0; i < n; i++) {
            isSafe[i] = true;
        }
        int[][] matrix = new int[n][n];
        for (int i = 0; i < m; i++) {
            matrix[links[i][0]][links[i][1]] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            System.out.println("new round");
            if (!isSafe[i]) {
                continue;
            }
            dfs(i, matrix, new ArrayList<>(), isSafe, visited);
        }
        ArrayList<Integer> safeList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (isSafe[i]) {
//                1 开始
                safeList.add(i + 1);
            }
        }
        if (safeList.isEmpty()) {
            System.out.println("None");
        } else {
            for (int item : safeList) {
                System.out.print(item + " ");
            }
        }
    }


    private static void dfs(int i, int[][] matrix, ArrayList<Integer> path, boolean[] isSafe, int[] visited) {
        System.out.println("cur:");
        show(path);
        System.out.println("next:" + (i + 1));
        if (path.contains(i) || !isSafe[i]) {
//            找到环，或者从路径上找到了不安全的客户
            System.out.println("not safe");
            for (int item : path) {
                System.out.println(item + 1);
                isSafe[item] = false;
            }
            return;
        }
        path.add(i);
        for (int j = 0; j < n; j++) {
            if (matrix[i][j] == 1) {
                dfs(j, matrix, path, isSafe, visited);
            }
        }
        path.remove(path.size() - 1);
    }


    private static void show(ArrayList<Integer> list) {
        for (int item : list
             ) {
            System.out.print(item + 1 + " ");
        }
        System.out.println();
    }
}
/*
7 7
1,3
2,4
2,6
3,4
4,5
5,3
6,7
 */

/*
7 8
1,3
2,4
2,6
4,5
4,6
5,3
6,7
7,4
 */