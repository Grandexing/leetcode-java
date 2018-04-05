package leetcode;

import java.util.HashSet;

public class Q128LongestConsecutiveSequence {
//    https://leetcode.com/problems/longest-consecutive-sequence/description/

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int item : nums) {
            set.add(item);
        }
        int longest = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int down = nums[i] - 1;
            while (set.contains(down)) {
                set.remove(down);
                down--;
            }
            int up = nums[i] + 1;
            while (set.contains(up)) {
                set.remove(up);
                up++;
            }
            if (up - down + 1 > longest) {
                longest = up - down + 1;
            }
        }
        return longest;
    }
}
