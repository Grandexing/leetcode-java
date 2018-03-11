package lintcode;

public class Q148SortColors {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     * bugfree:
     * 1. hi-- 写成了 hi++
     * 2. lo++;index++;
     *
     * link: http://www.lintcode.com/zh-cn/problem/sort-colors/
     */
    public void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return;
        }
        int lo = 0;
        int hi = nums.length - 1;
        int index = 0;
        while (index <= hi) {
            if (nums[index] == 0) {
                // 如果是0，和前面交换
                swap(nums, lo, index);
                lo++;
                index++;
            } else if (nums[index] == 2) {
                swap(nums, hi, index);
                hi--;
            } else {
                // 如果是1
                index++;
            }
        }
    }


    private void swap(int[] nums, int left, int right) {
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
