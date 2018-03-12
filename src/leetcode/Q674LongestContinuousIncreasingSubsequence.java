package leetcode;

public class Q674LongestContinuousIncreasingSubsequence {
//    https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/

    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int start = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            max = Math.max(max, i - start + 1);
        }
        return max;
    }
}
