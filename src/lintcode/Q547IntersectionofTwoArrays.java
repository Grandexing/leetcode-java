package lintcode;

import java.util.Arrays;
import java.util.HashSet;

public class Q547IntersectionofTwoArrays {
//    http://www.lintcode.com/zh-cn/problem/intersection-of-two-arrays/
//hash

    public static void main(String[] args) {
        Q547IntersectionofTwoArrays q = new Q547IntersectionofTwoArrays();
        int[] input1 = {1, 2, 2, 1};
        int[] input2 = {2, 2};
        System.out.println(Arrays.asList(q.intersection1(input1, input2)));
    }
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        if (nums1 == null || nums2 == null) {
            return null;
        }
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i) && !result.contains(i)) {
                result.add(i);
            }
        }
        int[] ans = new int[result.size()];
        int index = 0;
        for (int i : result) {
            ans[index++] = i;
        }
        return ans;
    }

//sort & merge
    public int[] intersection1(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        int index = 0;
        int[] tmp = new int[nums1.length];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                // 不重复
                if (index == 0 || tmp[index - 1] != nums1[i]) {
                    tmp[index++] = nums1[i];
                }
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        System.out.println(index);
        int[] result = new int[index];
        for (int k = 0; k < index; k++) {
            result[k] = tmp[k];
        }
        return result;
    }

//sort & binary search
    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) {
            return null;
        }
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        for (int i : nums2) {
            if (set.contains(i)) {
                continue;
            }
            if (binarySearch(nums1, i)) {
                set.add(i);
            }
        }
        int[] ans = new int[set.size()];
        int index = 0;
        for (int i : set) {
            ans[index++] = i;
        }
        return ans;
    }


    private boolean binarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return nums[start] == target || nums[end] == target;
    }
//
}
