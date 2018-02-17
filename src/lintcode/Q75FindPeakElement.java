package lintcode;

public class Q75FindPeakElement {
//    http://www.lintcode.com/en/problem/find-peak-element/

    public int findPeak(int[] A) {
        // write your code here
        if (A == null || A.length < 3) {
            return -1;
        }
        // length >= 3
        int start = 1;
        int end = A.length - 2;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] < A[mid + 1]) {
                start = mid;
            } else if (A[mid] < A[mid - 1]) {
                end = mid;
            } else {
                end = mid;
            }
        }
        if (A[start] < A[end]) {
            return end;
        } else {
            return start;
        }
    }
}
