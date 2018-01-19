package sword2offer;

public class Q10 {

//    非递归解法，时间复杂度 O(n)
    public int Fibonacci1(int n) {
        if (n < 0) return 0;
        if (n <= 1) return n;
        int fibNMinusOne = 1;
        int fibNMinusTwo = 0;
        int result = 0;
        int i = 2;
        while (i <= n) {
            result = fibNMinusTwo + fibNMinusOne;
            fibNMinusTwo = fibNMinusOne;
            fibNMinusOne = result;
            i++;
        }
        return result;
    }


//    递归，存在重复计算引起的效率问题
    public int Fibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }
}
