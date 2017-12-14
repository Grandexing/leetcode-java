package leetcode;

/**
 * Created by grande on 2017/12/13.
 */
public class Q26RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
//        int[] nums = {1, 1, 2, 3, 3, 3, 4};
        int[] nums = {1, 1, 1};
        System.out.println((solution(nums)));
        for (int i : nums) {
            System.out.println(i);
        }
    }

    static int solution(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int pos = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                pos = pos + 1;
                nums[pos] = nums[i + 1];
            }
        }
        return pos + 1;
    }
}
