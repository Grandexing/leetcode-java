package lintcode;

public class Q74FirstBadVersion {

    public int findFirstBadVersion(int n) {
        // write your code here
        // if (n < 1) {
        //     return -1;
        // }
        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            // int mid = (start + end) / 2;
            if (isBadVersion(mid)) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (isBadVersion(start)) {
            return start;
        }
        return end;
    }

    int firstBadVersion = 5;

    boolean isBadVersion(int n) {
        return n < firstBadVersion;
    }
}
