package leetcode;

public class Q55JumpGame {
//    https://leetcode.com/problems/jump-game/description/

    public boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(i>max) {
                return false;
            }
            max = Math.max(nums[i]+i,max);
        }
        return true;
    }

    public boolean canJump1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int farthest = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i <= farthest && nums[i] + i > farthest) {
                farthest = nums[i] + i;
            }
        }
        return farthest >= nums.length - 1;
    }
}
