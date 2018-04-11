package bishi.jingdong;

import java.util.Scanner;

public class Main3 {
    static int mod = 1000000007;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        System.out.println(dp(x, y, k));
    }


    private static int dp(int x, int y, int k) {
        int[][][] f = new int[9][9][100001];
        int[] directX = new int[]{1, 2, 2, 1, -1, -2, -2, -1};
        int[] directY = new int[]{2, 1, -1, -2, -2, -1, 1, 2};
        int xNew = 0;
        int yNew = 0;
        f[0][0][0] = 1;
        for (int z = 1; z <= k; z++) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    f[i][j][z] = 0;
                    for (int l = 0; l < 8; l++) {
                        xNew = i + directX[l];
                        yNew = j + directY[l];
                        if (xNew < 0 || yNew < 0 || xNew > 8 || yNew > 8) {
                            continue;
                        }
                        f[i][j][z] = (f[i][j][z] + f[xNew][yNew][z - 1]) % mod;
                    }
                }
            }
        }
        return f[x][y][k] % mod;
    }
}