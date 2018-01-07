package leetcode;

public class Q238ProductofArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        show(productExceptSelf(nums));
    }


    public static int[] productExceptSelf1(int[] nums) {
        int N = nums.length;
        int[] provs = new int[N];
        int[] nexts = new int[N];
        provs[0] = 1;
        nexts[N - 1] = 1;
        int i = 1;
        int j = N - 2;
        while (i < j) {
            provs[i] = provs[i - 1] * nums[i - 1];
            nexts[j] = nexts[j + 1] * nums[j + 1];
            i++;
            j--;
        }
        while (i < N) {
            provs[i] = provs[i - 1] * nums[i - 1];
            nexts[j] = nexts[j + 1] * nums[j + 1];
            nums[i] = provs[i] * nexts[i];
            nums[j] = provs[j] * nexts[j];
            i++;
            j--;
        }
        return nums;
    }


    public static int[] productExceptSelf(int[] nums) {
        int N = nums.length;
        int[] provs = new int[N];
        int[] nexts = new int[N];
        provs[0] = 1;
        nexts[N - 1] = 1;
        for (int i = 1; i < N; i++) {
            provs[i] = provs[i - 1] * nums[i - 1];
        }
        for (int j = N - 2; j > -1; j--) {
            nexts[j] = nexts[j + 1] * nums[j + 1];
        }
        for (int k = 0; k < N; k++) {
            nums[k] = provs[k] * nexts[k];
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
