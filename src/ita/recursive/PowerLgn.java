package ita.recursive;

/**
 * Created by grande on 2017/12/20.
 */
public class PowerLgn {
//    复杂度为logn的，递归式的乘方算法
    public static void main(String[] args) {
        System.out.println(power(2, 6));
    }


    static int power(int i, int n){
        if (n < 0) return 0;
        if (n == 0) return 1;
        int half = power(i, n/2);
        if (n % 2 == 0){
            return half * half;
        } else {
            return half * half * i;
        }
    }
}
