package lintcode;

public class Q65MedianoftwoSortedArrays {
//    http://www.lintcode.com/en/problem/median-of-two-sorted-arrays/
//http://www.cnblogs.com/yuzhangcmu/p/4138184.html

    public double findMedianSortedArrays(int[] A, int[] B) {
        // write your code here
        if (A == null || B == null) {
            return 0;
        }
        int len = A.length + B.length;
        if (len % 2 == 0) {
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2.0;
        } else {
            return findKth(A, 0, B, 0, len / 2 + 1);
        }
    }


    private int findKth(int[] A, int AStart, int[] B, int BStart, int k) {
        // k 从 1 开始
        if (A.length <= AStart) {
            return B[BStart + k - 1];
        }
        if (B.length <= BStart) {
            return A[AStart + k - 1];
        }
        if (k <= 1) {
            return Math.min(A[AStart], B[BStart]);
        }
        int keyA = AStart + k / 2 - 1 < A.length ? A[AStart + k / 2 - 1] : Integer.MAX_VALUE;
        int keyB = BStart + k / 2 - 1 < B.length ? B[BStart + k / 2 - 1] : Integer.MAX_VALUE;
        if (keyA < keyB) {
            return findKth(A, AStart + k / 2, B, BStart, k - k / 2);
        } else {
            return findKth(A, AStart, B, BStart + k / 2, k - k / 2);
        }
    }

}
