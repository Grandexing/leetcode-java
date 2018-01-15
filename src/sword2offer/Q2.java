package sword2offer;

public class Q2 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(duplicate(nums));
    }


    public static boolean duplicate(int[] nums) {
        if (nums == null || nums.length == 0) return false;
        for (int num : nums) {
            if (num < 0 || num > nums.length + 1) return false;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[nums[i]] == nums[i]) return true;
                int tmp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = tmp;
            }
        }
        return true;
    }
}
