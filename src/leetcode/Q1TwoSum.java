package leetcode;

import java.util.HashMap;

public class Q1TwoSum {
    public static void main(String[] args) {

    }


    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result[0] = i;
                result[1] = map.get(nums[i]);
            } else {
                map.put(target - nums[i], i);
            }
        }
        return result;
    }
}
