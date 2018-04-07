package lintcode;

/**
 * Created by grande on 2018/4/7.
 */
public class Q92Backpack {
//    http://www.lintcode.com/en/problem/backpack/#

    public int backPack(int m, int[] A) {
        // write your code here
        int[] f = new int[m + 1];
        f[0] = 0;
        for (int i = 0; i < A.length; i++) {
            for (int j = m; j >= A[i]; j--) {
                f[j] = Math.max(f[j], f[j - A[i]] + A[i]);
            }
        }
        return f[m];
    }
}
