package leetcode;

public class Q238ProductofArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        show(productExceptSelf(nums));
    }


    public static int[] productExceptSelf1(int[] nums) {
        int N = nums.length;
        int[] res = new int[N];
        res[0] = 1;
        int i = 1;
        while (i < N) {
            res[i] = res[i - 1] * nums[i - 1];
            i++;
        }
        int right = 1;
        i = N - 1;
        while (i >= 0) {
            res[i] = res[i] * right;
            right = right * nums[i];
            i--;
        }
        return res;
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
