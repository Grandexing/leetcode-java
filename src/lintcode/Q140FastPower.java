package lintcode;

public class Q140FastPower {
//    http://www.lintcode.com/en/problem/fast-power/

    public int fastPower(int a, int b, int n) {
        // write your code here
        long ans = 1;
        long tmp = a;
        while (n != 0) {
            if (n % 2 == 1) {
                ans = (ans * tmp) % b;
            }
            tmp = (tmp * tmp) % b;
            n /= 2;
        }
        return (int) ans % b;
    }
}
