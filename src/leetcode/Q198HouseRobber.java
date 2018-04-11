package leetcode;

public class Q198HouseRobber {

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int nMinusTwo = nums[0];
        int nMinusOne = Math.max(nums[0], nums[1]);
        int ans = 0;
        for (int i = 2; i < n; i++) {
            ans = Math.max(nMinusTwo + nums[i], nMinusOne);
            nMinusTwo = nMinusOne;
            nMinusOne = ans;
        }
        return ans;
    }


    public int rob1(int[] nums) {
        int include = 0;
        int exclude = 0;
        for (int n : nums) {
            int temp = exclude;
            exclude = Math.max(exclude, include);
            include = temp + n;
        }
        return Math.max(include, exclude);
    }
}
