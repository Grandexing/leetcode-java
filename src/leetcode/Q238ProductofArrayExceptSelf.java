package leetcode;

public class Q238ProductofArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        show(productExceptSelf(nums));
    }


    public static int[] productExceptSelf(int[] nums) {
        // int[] provs, nexts = new int[nums.length];
        int lo = 1;
        int hi = nums.length - 2;
        int prov = 1;
        int next = 1;
        while(lo < hi) {
            prov = prov * nums[lo - 1];
            next = next * nums[hi + 1];
            nums[lo] = prov;
            nums[hi] = next;
            lo++;
            hi--;
        }

        while(lo < nums.length && nums.length > 2) {
            prov = prov * nums[lo - 1];
            next = next * nums[hi + 1];
            nums[lo] = prov * nums[lo];
            nums[hi] = next * nums[hi];
            lo++;
            hi--;
        }

        return nums;
    }


    public static void show(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
