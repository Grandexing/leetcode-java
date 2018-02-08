package sword2offer;

public class Q66 {
// 面试题66：构建乘积数组
// 题目：给定一个数组A[0, 1, …, n-1]，请构建一个数组B[0, 1, …, n-1]，其
// 中B中的元素B[i] =A[0]×A[1]×… ×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。

    public int[] multiply(int[] A) {
        if (A == null || A.length <= 1) return A;
        int[] B = new int[A.length];
        B[0] = 1;
//        第一轮，每一位更新为当前位前面数字的乘积
        for (int i = 1; i < A.length; i++) {
            B[i] = A[i - 1] * B[i - 1];
        }
//        第二轮，每一位乘上当前位后面数字的乘积
        int temp = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            temp *= A[i + 1];
            B[i] *= temp;
        }
        return B;
    }
}
