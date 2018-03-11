package lintcode;

import java.util.HashSet;

public class Q124LongestConsecutiveSequence {
    /**
     * @param num: A list of integers
     * @return: An integer
     *
     * bugfree:
     * 1. 包含在 set 中的元素，判断之后应该 remove
     * 2. longest 重新赋值，应该用Math.max
     *
     */
    public int longestConsecutive(int[] num) {
        // write your code here
        if (num == null || num.length == 0) {
            return 0;
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i : num) {
            set.add(i);
        }
        int longest = 0;
        for (int i : num) {
            if (set.contains(i)) {
                set.remove(i);
                int l = i - 1;
                int r = i + 1;
                while (set.contains(l)) {
                    set.remove(l);
                    l--;
                }
                while (set.contains(r)) {
                    set.remove(r);
                    r++;
                }
                // (r - 1) - (l + 1) + 1
                longest = Math.max(longest, r - l - 1);
            }
        }
        return longest;
    }
}
