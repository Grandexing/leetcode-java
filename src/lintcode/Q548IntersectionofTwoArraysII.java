package lintcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q548IntersectionofTwoArraysII {
//    http://www.lintcode.com/en/problem/intersection-of-two-arrays-ii/

    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int item: nums1) {
            if (!map.containsKey(item)) {
                map.put(item, 1);
            } else {
                map.put(item, map.get(item) + 1);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int item : nums2) {
            if (map.containsKey(item) && map.get(item) > 0) {
                result.add(item);
                map.put(item, map.get(item) - 1);
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }
}
