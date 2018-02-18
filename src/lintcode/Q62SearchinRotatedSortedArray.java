package lintcode;

public class Q62SearchinRotatedSortedArray {
//    http://www.lintcode.com/en/problem/search-in-rotated-sorted-array/

    public int search(int[] A, int target) {
        // write your code here
        if (A == null || A.length == 0) {
            return -1;
        }
        int start = 0;
        int end = A.length - 1;
        int mid;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (A[mid] == target) {
                return mid;
            }
            if (A[start] < A[mid]) {
                if (A[mid] > target && A[start] <= target) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (A[mid] < target && A[end] >= target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        if (A[start] == target) {
            return start;
        } else if (A[end] == target){
            return end;
        }
        return -1;
    }
}
