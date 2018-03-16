package leetcode;

import java.util.Random;

public class Q384ShuffleanArray {
//    https://leetcode.com/problems/shuffle-an-array/description/
//    bugfree: 写错太多了，状态差，边界条件、语法错误，这是 null 和 length == 0 要分别处理的题

    int[] origin;
    int[] nums;
    Random rand;

    public Q384ShuffleanArray(int[] nums) {
        origin = deepCopy(nums);
        rand = new Random();
    }


    private int[] deepCopy(int[] nums) {
        if (nums == null) {
            return null;
        }
        if (nums.length == 0) {
            return nums;
        }
        int[] copy = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            copy[i] = nums[i];
        }
        return copy;
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        int[] result = new int[origin.length];
        result = deepCopy(origin);
        return result;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] result = deepCopy(origin);
        if (result == null) {
            return null;
        }
        if (result.length == 0) {
            return result;
        }
        for (int i = result.length - 1; i >= 0; i--) {
            int index = rand.nextInt(i + 1);
            swap(result, index, i);
        }
        return result;
    }


    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
